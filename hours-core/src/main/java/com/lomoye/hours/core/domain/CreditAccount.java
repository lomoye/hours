package com.lomoye.hours.core.domain;

import com.lomoye.common.domain.CommonDomain;

/**
 * Created by lomoye on 2017/8/3.
 * 账户表
 */
public class CreditAccount extends CommonDomain {
    private Long userId;//用户id

    private Long credit;//积分

    private Long historyCredit;//历史上总的获取到的积分。只增不减

    private Long version;//版本号 乐观锁


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getCredit() {
        return credit;
    }

    public void setCredit(Long credit) {
        this.credit = credit;
    }

    public Long getHistoryCredit() {
        return historyCredit;
    }

    public void setHistoryCredit(Long historyCredit) {
        this.historyCredit = historyCredit;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
}
