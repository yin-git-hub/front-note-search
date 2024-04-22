package com.yin.controller;

import com.yin.dao.FrontNoteESDao;
import com.yin.pojo.FrontNoteES;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SearchFile {
 
    public static void main(String[] args) throws IOException {
        //初始目录
        File dir = new File("C:/Users/11230/Desktop/htmlcssjs/frontNotes");
        SearchFile searchFile = new SearchFile();
        searchFile.printDirByRecursive(dir);

    }
    @Autowired
    FrontNoteESDao frontNoteESDao;
 
    /**
     *  遍历文件夹（递归）
     * @param dir
     */
    public void printDirByRecursive(File dir) throws IOException {

        File[] files = dir.listFiles();
        //遍历这个数组，取出每个File对象
        if (files != null) {
            for (File f : files) {
                if(f.isHidden()){
                   continue;
                }
                //判断这个File是否是一个文件，是：
                if (f.isFile()&&(f.getName().toLowerCase().endsWith(".md")||f.getName().toLowerCase().endsWith(".html"))) {
                    if(f.getName().toLowerCase().endsWith(".md")){
                        List<String> list = MarkdownParserUtils.parseMarkdown(f.getAbsolutePath());
                        for (int i=0;i<list.size();i++) {
                            FrontNoteES frontNoteES = new FrontNoteES();
                            frontNoteES.setId(f.getName()+"-"+i);
                            frontNoteES.setContext(list.get(i));
                            Pattern pattern = Pattern.compile("##.*");
                            Matcher matcher = pattern.matcher(list.get(i));
                            if (matcher.find()) {
                                frontNoteES.setLocation(f.getPath()+"-"+matcher.group());
                            } else {
                            }
                            System.out.println(frontNoteES);
                        }
                    }
                    if(f.getName().toLowerCase().endsWith(".html")){

                    }
                } else {//否则就是一个目录，继续递归
                    //递归调用
                    printDirByRecursive(f);
                }

            }
        }
    }
}