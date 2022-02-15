package com.example.accountsystem.enums;

public enum ErrorTypeEnum {

    NOT_LOGIN(1, "尚未登入"),
    NO_USER_NAME(2, "使用者名稱尚未輸入"),
    NO_PASSWORD(3, "使用者密碼尚未輸入"),
    AMOUNT_MUST_GREATER_THAN_ZERO(4, "金額需大於0"),
    NO_MONEY(5, "尚未輸入金額");

    private int code;
    private String msg;

    ErrorTypeEnum(int code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public static ErrorTypeEnum get(int status){
        for (ErrorTypeEnum errorTypeEnum : ErrorTypeEnum.values()){
            if (errorTypeEnum.code == status){
                return errorTypeEnum;
            }
        }
        return null;
    }

    public int getCode(){
        return code;
    }

    public String getMsg(){
        return msg;
    }

}