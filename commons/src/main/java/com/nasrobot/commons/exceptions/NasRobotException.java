package com.nasrobot.commons.exceptions;

import com.nasrobot.commons.enums.ErrorCodeEnum;

public class NasRobotException extends BaseException{

    public NasRobotException(ErrorCodeEnum codeEnum) {
        super(codeEnum);
    }
}
