package com.nasrobot.app.client;

import org.jsoup.Connection;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
public class PersistentThreadWebScraper {


    public void scrapePages(Connection[] connections) {
        // 创建常驻线程池
        ExecutorService executor = Executors.newCachedThreadPool();

        for (Connection connection : connections) {
            // 提交任务给线程池
            executor.submit(() -> {
                try {
                    scrapePage(connection);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
    }

    public void scrapePage(Connection connection) throws IOException {
        // 发起HTTP GET请求
        Document document = connection.get();

        // 解析页面内容
        String pageTitle = document.title();
        System.out.println("Page Title: " + pageTitle);

        // 提取关键字
        Elements keywords = document.select("meta[name=keywords]");
        if (!keywords.isEmpty()) {
            String keywordContent = keywords.attr("content");
            System.out.println("Keywords: " + keywordContent);
        } else {
            System.out.println("Keywords not found.");
        }

        // 提取按钮文本
        Elements buttons = document.select("button");
        for (Element button : buttons) {
            System.out.println("Button Text: " + button.text());
        }
    }

}
