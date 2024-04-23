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
@CrossOrigin
public class TTTestController {
    @Autowired
    FrontNoteService frontNoteService;

    @GetMapping("/save")
    public String sava() throws IOException {
        frontNoteService.save(null);
        return "success";
    }


    @GetMapping("/getContext/{keyC}")
    public List<SearchHit<FrontNoteES>> getContext(@PathVariable("keyC") String keyC) throws IOException {
        List<SearchHit<FrontNoteES>> list = frontNoteService.getContext(keyC);
        return list;
    }
}
