package com.lomoye.hours.core.model;

import com.lomoye.common.model.PagedModel;

/**
 * Created by lomoye on 2017/9/23.
 * 用户建议搜索
 */
public class UserSuggestSearchModel extends PagedModel {
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
