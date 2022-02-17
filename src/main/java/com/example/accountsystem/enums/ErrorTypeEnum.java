package com.example.accountsystem.enums;

public enum ErrorTypeEnum {

    NOT_LOGIN(1, "尚未登入"),
    NO_USER_NAME(2, "使用者名稱尚未輸入"),
    NO_PASSWORD(3, "使用者密碼尚未輸入"),
    CREDITS_MUST_GREATER_THAN_ZERO(4, "金額需大於0"),
    NO_MONEY(5, "尚未輸入金額"),
    NO_TRANSFER_FROM(6, "尚未輸入轉出帳號"),
    NO_TRANSFER_TO(7, "尚未輸入轉入帳號"),
    BALANCE_NOT_ENOUGH(8, "餘額不足"),
    NO_START_DATE(9, "尚未輸入開始時間"),
    NO_END_DATE(10, "尚未輸入結束時間"),
    NO_DATA(11, "查無資料"),
    NO_TRANSFER_FROM_DATA(12, "查無轉出帳號資料"),
    NO_TRANSFER_TO_DATA(13, "查無轉入帳號資料");

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
