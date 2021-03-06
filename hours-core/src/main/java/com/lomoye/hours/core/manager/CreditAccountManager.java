package com.lomoye.hours.core.manager;

import com.lomoye.common.manager.DomainManager;
import com.lomoye.hours.core.domain.CreditAccount;


public interface CreditAccountManager extends DomainManager<Long, CreditAccount> {
    CreditAccount getOrCreateByUserId(Long userId);

    int updateByPrimaryKeyWithVersion(CreditAccount creditAccount);//乐观锁,通过version控制
}
