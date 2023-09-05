package com.nasrobot.commons.exceptions;

import com.nasrobot.commons.enums.ErrorCodeEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@SuppressWarnings({"unused"})
public class BaseException extends RuntimeException {

    /**
     * 异常场景枚举
     */
    private ErrorCodeEnum codeEnum;
    /**
     * 需要传递或者做业务处理的错误码
     */
    private String code;
    /**
     * 错误描述
     */
    private String msg;

    /**
     * 构造器
     *
     * @param codeEnum 异常场景枚举
     */
    public BaseException(ErrorCodeEnum codeEnum) {
        super(detail(codeEnum));
        init(codeEnum);
    }

    public BaseException(ErrorCodeEnum codeEnum, Throwable e) {
        super(detail(codeEnum), e);
        init(codeEnum);
    }

    public BaseException(ErrorCodeEnum codeEnum, Object... args) {
        super(detail(codeEnum, args));
        init(codeEnum, args);
    }

    public BaseException(ErrorCodeEnum codeEnum, Throwable e, Object... args) {
        super(detail(codeEnum, args), e);
        init(codeEnum, args);
    }

    public BaseException(String errorCode, String errorMessage) {
        super(errorMessage);
        init(errorCode, errorMessage);
    }

    /**
     * 填充参数构建异常原因详细信息(detailMessage)
     *
     * @param codeEnum ErrorCode
     * @param args     用以填充的参数
     * @return 异常原因详细信息
     */
    private static String detail(ErrorCodeEnum codeEnum, Object... args) {
        return codeEnum.getMessage(args) + ";" + codeEnum.getCode();
    }

    /**
     * 初始化code和msg实例变量
     */
    private void init(String errorCode, String errorMessage) {
        this.code = errorCode;
        this.msg = errorMessage;
    }

    /**
     * 初始化code和msg实例变量
     *
     * @param codeEnum ErrorCode
     * @param args     用以填充错误描述信息的参数
     */
    private void init(ErrorCodeEnum codeEnum, Object... args) {
        this.codeEnum = codeEnum;
        this.code = codeEnum.getCode();
        this.msg = codeEnum.getMessage(args);
    }

}
