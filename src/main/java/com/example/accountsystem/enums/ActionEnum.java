package com.example.accountsystem.enums;

public enum ActionEnum {

    INCOME(1, "收入"),
    EXPENDITURE(2, "支出"),
    LOGOUT(3, "登出"),
    TRANSFER(4, "轉帳");

    private int code;
    private String msg;

    ActionEnum(int code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public static ActionEnum get(int status){
        for (ActionEnum actionEnum : ActionEnum.values()){
            if (actionEnum.code == status){
                return actionEnum;
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
