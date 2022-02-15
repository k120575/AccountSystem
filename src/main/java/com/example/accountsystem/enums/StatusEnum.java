package com.example.accountsystem.enums;

public enum StatusEnum {

    LOGIN_SUCCESS(1, "登入成功"),
    LOGIN_FALSE(2, "登入失敗"),
    REGISTER_SUCCESS(3, "註冊成功"),
    REGISTER_FALSE(4, "註冊失敗"),
    DEPOSIT_SUCCESS(5, "存款成功"),
    DEPOSIT_FALSE(6, "存款失敗"),
    WITHDRAW_SUCCESS(7, "取款成功"),
    WITHDRAW_FALSE(8, "取款失敗"),
    INQUIRY_SUCCESS(9, "查詢成功"),
    INQUIRY_FALSE(10, "查詢失敗"),
    TRANSFER_SUCCESS(11, "轉帳成功"),
    TRANSFER_FALSE(12, "轉帳失敗");

    private int code;
    private String msg;

    StatusEnum(int code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public static StatusEnum get(int status){
        for (StatusEnum statusEnum : StatusEnum.values()){
            if (statusEnum.code == status){
                return statusEnum;
            }
        }
        return null;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
