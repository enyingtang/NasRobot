package com.nasrobot.app.services.douban;

import com.nasrobot.app.client.PersistentThreadWebScraper;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;

@Service
@Slf4j
public class DoubanService {

    @Autowired
    private PersistentThreadWebScraper persistentThreadWebScraper;

    /**
     * 获取豆瓣排行榜
     */
    public void getDoubanTop() {

        String userAgent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.124 Safari/537.36";
        Map<String, String> cookies = null; // 可以设置具体的Cookie值
        String proxyHost = null; // 可以设置代理服务器地址
        int proxyPort = 0; // 可以设置代理服务器端口号

        Connection connection = Jsoup.connect("https://movie.douban.com/chart")
                .userAgent(userAgent)
//                .cookies(cookies)
                .timeout(5000);
        try {
            persistentThreadWebScraper.scrapePage(connection);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
