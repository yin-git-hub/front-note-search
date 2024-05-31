package com.yin.service;

import com.yin.utils.MarkdownParserUtils;
import com.yin.dao.FrontNoteESDao;
import com.yin.pojo.FrontNoteES;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class FrontNoteService {
    public static ExecutorService executorService = Executors.newFixedThreadPool(4);
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
                        List<String> list = MarkdownParserUtils.parseMarkdown(f.getAbsolutePath());
                        for (int i = 0; i < list.size(); i++) {
                            // 封装到ES先关的DAO
                            FrontNoteES frontNoteES = new FrontNoteES();
                            frontNoteES.setId(f.getName() + "-" + i);
                            frontNoteES.setContext(list.get(i));
                            frontNoteES.setLocation(f.getPath() + "-" + (i + 1));
                            // 保存到ES
                            frontNoteESDao.save(frontNoteES);
                        }
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
//        for (SearchHit<FrontNoteES> frontNoteESSearchHit : byContext) {
//            List<String> context = frontNoteESSearchHit.getHighlightField("context");
//            FrontNoteES content = frontNoteESSearchHit.getContent();
//            System.out.println("=============================================================");
//            for (int i=0;i<context.size();i++) {
//                System.out.println(i);
//                System.out.println(context.get(i));
//            }
//            System.out.println("=============================================================");
//        }
//        for (SearchHit<FrontNoteES> frontNoteESSearchHit : byContext) {
//            System.out.println("=============================================================");
//            System.out.println(frontNoteESSearchHit);
//            System.out.println("=============================================================");
//        }
        return byContext;
    }
}
