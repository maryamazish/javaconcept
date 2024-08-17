package com.azish.juni5;

public enum ExceptionEnum {
    RUNTIME(0),
    IO(1),
    NULL_POINTER(2);

    private final Integer code;

    ExceptionEnum(Integer code) {
        this.code = code;
    }

    public Integer getCode(){
        return this.code;
    }

    public static ExceptionEnum valueOfLabel(Integer code) {
        for (ExceptionEnum exceptionEnum : values()) {
            if (exceptionEnum.code.equals(code)) {
                return exceptionEnum;
            }
        }
        return null;
    }
}
