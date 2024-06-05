package com.yin.service;

import com.yin.utils.MarkdownParserUtils;
import com.yin.dao.FrontNoteESDao;
import com.yin.pojo.FrontNoteES;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

@Service
public class FrontNoteService {

    @Autowired
    FrontNoteESDao frontNoteESDao;

    public void save(String path) throws IOException {
        printDirByRecursive(new File(path));
    }
    public void printDirByRecursive(File dir) throws IOException {

        File[] files = dir.listFiles();
        //遍历这个数组，取出每个File对象
        if (files != null) {

            for (File f : files) {
                if (f.isHidden()) {
                    continue;
                }
                if (f.isFile() && (f.getName().toLowerCase().endsWith(".md") || f.getName().toLowerCase().endsWith(".html"))) {
                    if (f.getName().toLowerCase().endsWith(".md")) {
                        System.out.println("开始->"+f.getPath());
                        List<String> list = MarkdownParserUtils.parseMarkdown(f.getAbsolutePath());
                        for (int i = 0; i < list.size(); i++) {
                            // 封装到ES先关的DAO
                            FrontNoteES frontNoteES = new FrontNoteES();
                            frontNoteES.setId(f.getName() + "-" + i);
                            frontNoteES.setContext(list.get(i));
                            frontNoteES.setLocation(f.getPath() + "   " + (i + 1));
                            // 保存到ES
                            frontNoteESDao.save(frontNoteES);
                        }
                        System.out.println("完成->"+f.getPath());
                    }
                } else {//否则就是一个目录，继续递归
                    //递归调用
                    try {
                        printDirByRecursive(f);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }
        }
    }

    public List getContext(String keyC) {
        List<SearchHit<FrontNoteES>> byContext = frontNoteESDao.findByContext(keyC);
        LinkedList<FrontNoteES> searchHits = new LinkedList<>();
        for (SearchHit<FrontNoteES> frontNoteESSearchHit : byContext) {
            String context = frontNoteESSearchHit.getHighlightField("context").get(0);
            String outSpan = context
                    .replace("<span style='color:red'>","")
                    .replace("</span>","");
            String context1 = frontNoteESSearchHit.getContent().getContext().replace(outSpan,context);

            FrontNoteES frontNoteES = new FrontNoteES();
            frontNoteES.setId(frontNoteESSearchHit.getContent().getId());
            frontNoteES.setContext(context1);
            frontNoteES.setLocation(frontNoteESSearchHit.getContent().getLocation());
            searchHits.add(frontNoteES);
        }

        return searchHits;
    }
}
