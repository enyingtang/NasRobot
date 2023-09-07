package com.nasrobot.app.services.douban;

import com.nasrobot.app.parser.DoubanTopParser;
import com.nasrobot.repository.entity.douban.DoubanTop;
import com.nasrobot.repository.repository.douban.DoubanTopRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionTemplate;

import java.io.IOException;
import java.util.List;

@Service
@Slf4j
public class DoubanService {

    @Autowired
    private DoubanTopParser doubanTopParser;
    @Autowired
    private DoubanTopRepository doubanTopRepository;
    @Autowired
    private TransactionTemplate transactionTemplate;

    /**
     * 获取豆瓣排行榜
     */
    @Transactional
    public void getDoubanTop() {
        String userAgent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.124 Safari/537.36";

        Connection connection = Jsoup.connect("https://movie.douban.com/chart")
                .userAgent(userAgent)
                .timeout(5000);
        try {
            Document document = connection.get();
            List<DoubanTop> doubanTops = doubanTopParser.parse(document);
            doubanTopRepository.deleteAll();
            doubanTopRepository.saveAll(doubanTops);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
