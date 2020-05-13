package com.wanglei.business.enums;

/**
 * Created by sunxuyang on 16/12/19.
 */
public enum TicketStatus {
    UNKNOWN(0,"未知"),
    TOBESELL(1,"即将开售"),
    PRESELL(2,"预订"),
    SELLING(3,"在售中"),
    SOLDOUT(4,"已售空"),
    SOLDEND(5,"已结束"),
    TOBEPRESELL(11,"即将开抢"),
    UNUSUAL(12,"异常售卖");


    private int code;
    private String desc;

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    TicketStatus(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static TicketStatus valueOf(int value) {
        for (TicketStatus item : TicketStatus.values()) {
            if (item.getCode() == value) {
                return item;
            }
        }
        throw new IllegalArgumentException("Illegal value for TicketStatus : " + value);
    }
}

