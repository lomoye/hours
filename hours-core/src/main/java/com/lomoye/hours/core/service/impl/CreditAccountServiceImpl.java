package com.lomoye.hours.core.service.impl;


import com.google.common.base.Preconditions;
import com.lomoye.common.concurrent.ThreadUtil;
import com.lomoye.common.exception.BusinessException;
import com.lomoye.common.util.DateUtil;
import com.lomoye.hours.core.constant.ErrorCode;
import com.lomoye.hours.core.domain.CreditAccount;
import com.lomoye.hours.core.domain.CreditAccountLog;
import com.lomoye.hours.core.enums.CreditAccountLogType;
import com.lomoye.hours.core.manager.CreditAccountLogManager;
import com.lomoye.hours.core.manager.CreditAccountManager;
import com.lomoye.hours.core.service.CreditAccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by lomoye on 2017/8/5.
 * 积分账户服务
 */
@Service
public class CreditAccountServiceImpl implements CreditAccountService {
    private Logger LOGGER = LoggerFactory.getLogger(CreditAccountServiceImpl.class);


    @Autowired
    private CreditAccountManager creditAccountManager;

    @Autowired
    private CreditAccountLogManager creditAccountLogManager;

    @Override
    public void addCreditUtilSuccess(Long userId, Long credit, String type, String memo) {
        Preconditions.checkArgument(userId != null && credit != null && type != null);
        CreditAccount creditAccount = creditAccountManager.getOrCreateByUserId(userId);
        if (creditAccount == null) {
            LOGGER.warn("creditAccount no exist|userId={}|credit={}|type={}", userId, credit, type);
            throw new BusinessException(ErrorCode.PARAMETER_IS_ILLEGAL, "账户不存在");
        }

        CreditAccountLog creditAccountLog = generateCreditAccountLog(creditAccount, userId, credit, type, memo);

        creditAccount.setCredit(creditAccount.getCredit() + credit);
        creditAccount.setHistoryCredit(creditAccount.getCredit());// warning: 只增不减

        while (true) {
            try {
                creditAccountManager.updateByPrimaryKeyWithVersion(creditAccount);
                break;
            } catch (BusinessException e) {
                throw e;//自己抛的异常不捕获
            } catch (Throwable e) {
                LOGGER.warn("addCredit failed,retry util success|userId={}|credit={}|type={}", userId, credit, type);
                ThreadUtil.safeSleep(1000L , "addCredit failed,retry util success");
            }
        }

        saveCreditAccountLogUtilSuccess(creditAccountLog);
    }

    private void saveCreditAccountLogUtilSuccess(CreditAccountLog creditAccountLog) {
        while (true) {
            try {
                int res = creditAccountLogManager.save(creditAccountLog);
                if (res > 0) {
                    break;
                }
            } catch (Throwable e) {
                LOGGER.warn("saveCreditAccountLogUtilSuccess|userId={}|type={}", creditAccountLog.getUserId(), creditAccountLog.getType());
                ThreadUtil.safeSleep(1000L , "saveCreditAccountLogUtilSuccess");
            }
        }
    }

    private CreditAccountLog generateCreditAccountLog(CreditAccount creditAccount, Long userId, Long credit, String type, String memo) {
        CreditAccountLog accountLog = new CreditAccountLog();
        accountLog.setUserId(userId);
        accountLog.setDay(DateUtil.getDailyStartTime(new Date()));
        accountLog.setBeforeCredit(creditAccount.getCredit());
        accountLog.setAfterCredit(creditAccount.getCredit() + credit);
        accountLog.setType(type);
        accountLog.setMemo(type + "|" + userId + "|" + credit + "|" + memo);
        accountLog.setContent(CreditAccountLogType.getContent(type) + "," + "获得" + credit + "点积分");
        return accountLog;
    }
}
