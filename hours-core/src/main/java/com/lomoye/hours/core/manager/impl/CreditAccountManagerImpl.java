package com.lomoye.hours.core.manager.impl;

import com.google.common.base.Preconditions;
import com.lomoye.common.dao.BasicMapper;
import com.lomoye.common.exception.BusinessException;
import com.lomoye.hours.core.dao.CreditAccountMapper;
import com.lomoye.hours.core.domain.CreditAccount;
import com.lomoye.hours.core.manager.CreditAccountManager;
import com.lomoye.common.manager.AbstractManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;


@Component
public class CreditAccountManagerImpl extends AbstractManager<CreditAccount> implements CreditAccountManager {

    @Autowired
    private CreditAccountMapper mapper;


    @Override
    protected BasicMapper<Long, CreditAccount> getMapper() {
        return mapper;
    }

    @Override
    public CreditAccount getOrCreateByUserId(Long userId) {
        Preconditions.checkArgument(userId != null);
        CreditAccount condition = new CreditAccount();
        condition.setUserId(userId);

        CreditAccount selectCreditAccount = getByCondition(condition);
        if (selectCreditAccount != null) {
            return selectCreditAccount;
        }

        return initCreditAccount(userId);
    }

    @Override
    public int updateByPrimaryKeyWithVersion(CreditAccount creditAccount) {
        Preconditions.checkNotNull(creditAccount.getId());

        creditAccount.setModifyTime(new Date());
        int res = mapper.updateByPrimaryKeyWithVersion(creditAccount);
        if (res <= 0) {
            throw new BusinessException("updateByPrimaryKeyWithVersionError", "updateByPrimaryKeyWithVersion failed|id=" + creditAccount.getId() + "|version=" + creditAccount.getVersion());
        }
        creditAccount.setVersion(creditAccount.getVersion() + 1);
        return res;
    }

    private CreditAccount initCreditAccount(Long userId) {
        CreditAccount creditAccount = new CreditAccount();
        creditAccount.setUserId(userId);
        creditAccount.setCredit(0L);
        creditAccount.setHistoryCredit(0L);
        creditAccount.setVersion(0L);

        save(creditAccount);

        return creditAccount;
    }
}
