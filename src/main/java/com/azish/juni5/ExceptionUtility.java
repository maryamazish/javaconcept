package com.azish.juni5;

public class ExceptionUtility {
    public static Integer generate(ExceptionEnum exceptionEnum, Exception exception) {
        if (exception.getMessage().isBlank())
            return -1;
        return exceptionEnum.getCode();
    }

}
