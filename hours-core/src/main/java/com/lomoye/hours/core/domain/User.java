package com.lomoye.hours.core.domain;

import com.lomoye.common.domain.CommonDomain;

/**
 * Created by lomoye on 2017/6/12.
 * 用户
 */
public class User extends CommonDomain {
    private String name;

    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
