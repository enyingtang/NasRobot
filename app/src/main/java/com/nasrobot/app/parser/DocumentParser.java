package com.nasrobot.app.parser;

import org.jsoup.nodes.Document;

import java.util.List;

/**
 * 解析器
 */
public interface DocumentParser<T> {

    /**
     * HTML解析器
     *
     * @param document html文档
     * @return 解析完后的JSON字符串
     */
    List<T> parse(Document document);

}
