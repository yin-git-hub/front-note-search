package com.yin.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * markdown分段
 */
public class MarkdownParserUtils {

    public static void main(String[] args) {
        String filePath = "C:\\Users\\11230\\Desktop\\y" +
                "\\Knowledge-Fragments\\notes\\frontNotes\\1.css\\css.md";
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
            // 逐行分段
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
