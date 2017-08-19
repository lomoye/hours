package com.lomoye.hours.core.enums;

/**
 * Created by lomoye on 2017/8/5.
 *
 */
public class CreditAccountLogType {
    public static final String ITEM_RECORD = "item_record";//记录项目数据

    public static final String ITEM_GOAL = "item_goal";//目标达成奖励

    public static String getContent(String type) {
        if (ITEM_RECORD.equals(type)) {
            return "记录一条项目记录";
        }
        if (ITEM_GOAL.equals(type)) {
            return "目标达成奖励";
        }
        return "[出错了,无效的类型,不应该有这条日志]";
    }
}
