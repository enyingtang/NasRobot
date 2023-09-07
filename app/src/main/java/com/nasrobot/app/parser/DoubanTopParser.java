package com.nasrobot.app.parser;

import com.nasrobot.repository.entity.douban.DoubanTop;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class DoubanTopParser implements DocumentParser<DoubanTop> {
    @Override
    public List<DoubanTop> parse(Document document) {
        Elements topTables = document.select("div[class='indent'] > div > table");
        if (topTables.isEmpty()) {
            return null;
        }
        List<DoubanTop> doubanTopList = topTables.stream().map(table -> {
                            Elements trs = table.select("tbody > tr > td");
                            String title = trs.get(0).select("a > img").attr("alt");
                            String subtitle = trs.get(1).select("td > div > a").text();
                            String thumbnailImgUrl = trs.get(0).select("a > img").attr("src");
                            String desc = trs.get(1).select("p").text();
                            String rating = trs.get(1).select("span.rating_nums").text();
                            String numberOfReviews = trs.get(1).select("span.pl").text();
                            return DoubanTop.builder()
                                    .title(title)
                                    .subtitle(subtitle)
                                    .thumbnailImgUrl(thumbnailImgUrl)
                                    .desc(desc)
                                    .rating(rating)
                                    .numberOfReviews(numberOfReviews)
                                    .order(1)
                                    .build();
                        }
                )
                .sorted(Comparator.comparing(DoubanTop::getRating))
                .toList();
        return doubanTopList.stream().peek(doubanTop -> {
            doubanTop.setOrder(doubanTopList.indexOf(doubanTop));
        }).collect(Collectors.toList());
    }
}
