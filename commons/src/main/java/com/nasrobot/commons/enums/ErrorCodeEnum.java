package com.nasrobot.commons.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 系统错误码
 */
@AllArgsConstructor
@Getter
public enum ErrorCodeEnum {

    USER_NOT_FOUND("USER_NOT_FOUND", "用户未找到");

    private String code;
    private String message;

    public String getMessage(Object... args) {
        return String.format(this.getMessage(), args);
    }

}
