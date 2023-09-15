package com.nasrobot.app.parser;

import org.jsoup.Connection;

import java.io.IOException;
import java.util.List;

/**
 * 解析器
 */
public interface DocumentParser<T> {

    /**
     * HTML解析器
     *
     * @param connection 链接
     * @return 解析完后的JSON字符串
     */
    List<T> parse(Connection connection) throws IOException;

}
