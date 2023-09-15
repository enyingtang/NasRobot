package com.nasrobot.app.parser;

import com.nasrobot.repository.entity.douban.DoubanWantWatch;
import org.jsoup.Connection;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class DoubanWantWatchParser implements DocumentParser<DoubanWantWatch> {
    @Override
    public List<DoubanWantWatch> parse(Connection connection) throws IOException {
        Document document = connection.get();

        // 第一页
        ArrayList<DoubanWantWatch> doubanWantWatchList = new ArrayList<>(parserWantWatchList(document));
        if (doubanWantWatchList.isEmpty()) {
            return new ArrayList<>();
        }
        // 分页
        Elements nextA = document.select("span.next > a").select("a");
        boolean hasNext = !nextA.isEmpty();
        while (hasNext) {
            Document documentNext = connection.url(nextA.attr("abs:href")).get();
            doubanWantWatchList.addAll(parserWantWatchList(documentNext));
            nextA = documentNext.select("span.next > a").select("a");
            hasNext = !nextA.isEmpty();
        }
        return doubanWantWatchList;

    }

    private static List<DoubanWantWatch> parserWantWatchList(Document document) {
        Elements wantWatchItemList = document.select("div.item.comment-item");
        if (wantWatchItemList.isEmpty()) {
            return new LinkedList<>();
        }
        return wantWatchItemList.stream().map(table -> {
                            String title = table.select("div.pic a").attr("title");
                            String subtitle = table.select("div.info > ul > li.title").text();
                            String thumbnailImgUrl = table.select("div.pic > a > img").attr("src");
                            String desc = table.select("div.info > ul > li.intro").text();
                            String date = table.select("div.info > ul > li > span.date").text();
                            String tags = table.select("div.info > ul > li > span.tags").text();
                            return DoubanWantWatch.builder()
                                    .title(title)
                                    .subTitle(subtitle)
                                    .thumbnailImgUrl(thumbnailImgUrl)
                                    .desc(desc)
                                    .wantWatchDate(date)
                                    .wantWatchTags(tags)
                                    .build();
                        }
                )
                .collect(Collectors.toList());
    }
}
