package com.example.accountsystem.enums;

public enum StatusEnum {

    LOGIN_SUCCESS(1, "登入成功"),
    LOGIN_FALSE(2, "登入失敗"),
    REGISTER_SUCCESS(3, "註冊成功"),
    REGISTER_FALSE(4, "註冊失敗"),
    INCOME_SUCCESS(5, "收入新增成功"),
    INCOME_FALSE(6, "收入新增失敗"),
    EXPENDITURE_SUCCESS(7, "支出新增成功"),
    EXPENDITURE_FALSE(8, "支出新增失敗"),
    INQUIRY_SUCCESS(9, "查詢成功"),
    INQUIRY_FALSE(10, "查詢失敗"),
    TRANSFER_SUCCESS(11, "轉帳成功"),
    TRANSFER_FALSE(12, "轉帳失敗"),
    SEARCH_SUCCESS(13, "搜尋成功"),
    SEARCH_FALSE(14, "搜尋失敗");

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
