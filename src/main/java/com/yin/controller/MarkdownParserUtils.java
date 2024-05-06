package com.yin.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MarkdownParserUtils {

    public static void main(String[] args) {
        String filePath = "C:\\Users\\11230\\Desktop\\htmlcssjs\\frontNotes\\3.webAPI_and_数据可视化\\webapis_note_day1-day4.md";
        List<String> paragraphs = parseMarkdown(filePath);
        for (String paragraph : paragraphs) {
            System.out.println(paragraph);
            System.out.println("-----------------------");
        }
    }

    // 根据# ## ### 对 markdown 进行分段
    public static List<String> parseMarkdown(String filePath) {
        List<String> paragraphs = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                StringBuilder paragraphBuilder = new StringBuilder();
                paragraphBuilder.append(line).append("\n");
                paragraphs.add(paragraphBuilder.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return paragraphs;
    }
}
