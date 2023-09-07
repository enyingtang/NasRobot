package com.nasrobot.app.client;

import org.jsoup.Connection;
import org.jsoup.nodes.Document;
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

    public Document scrapePage(Connection connection) throws IOException {
        // 发起HTTP GET请求
        return connection.get();
    }

}
