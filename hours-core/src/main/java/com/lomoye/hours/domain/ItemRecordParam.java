package com.lomoye.hours.domain;

/**
 * Created by lomoye on 2017/6/27.
 * 记录的参数类
 */
public class ItemRecordParam extends CommonDomain {
    private String key;

    private String value;

    private String type;

    private String displayName;//文案名

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
}
