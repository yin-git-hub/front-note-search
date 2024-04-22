package com.yin.controller;

import com.yin.service.FrontNoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class TTTestController {
    @Autowired
    FrontNoteService frontNoteService;

    @GetMapping("/save")
    public String sava() throws IOException {
        frontNoteService.save(null);
        return "success";
    }
}
