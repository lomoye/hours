package com.lomoye.hours.core.service;




/**
 * Created by lomoye on 2017/8/5.
 * 积分账户服务
 */
public interface CreditAccountService {
    void addCreditUtilSuccess(Long userId, Long credit, String type, String memo);
}
