package com.lomoye.hours.core.enums;

/**
 * Created by lomoye on 2017/8/5.
 *
 */
public class CreditAccountLogType {
    public static final String ITEM_RECORD = "item_record";//记录项目数据

    public static String getContent(String type) {
        if (ITEM_RECORD.equals(type)) {
            return "记录一条项目记录";
        }
        return "[出错了,无效的类型,不应该有这条日志]";
    }
}
