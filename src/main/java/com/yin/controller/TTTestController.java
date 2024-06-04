package com.yin.controller;

import com.yin.pojo.FrontNoteES;
import com.yin.service.FrontNoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController

public class TTTestController {
    @Autowired
    FrontNoteService frontNoteService;

    @GetMapping("/save/{path}")
    @CrossOrigin
    public String sava(@PathVariable("path") String path) throws IOException {
        path = "C:\\Users\\11230\\Desktop\\webpack+Vue基础课程资料";
        System.out.println("开始。");
        frontNoteService.save(path);
        System.out.println("完成。");
        return "success";
    }


    @GetMapping("/getContext/{keyC}")
    @CrossOrigin
    public List<SearchHit<FrontNoteES>> getContext(@PathVariable("keyC") String keyC) throws IOException {
        List<SearchHit<FrontNoteES>> list = frontNoteService.getContext(keyC);
        return list;
    }
}
