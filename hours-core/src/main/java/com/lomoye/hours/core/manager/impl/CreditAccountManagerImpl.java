package com.lomoye.hours.core.manager.impl;

import com.lomoye.common.dao.BasicMapper;
import com.lomoye.hours.core.dao.CreditAccountMapper;
import com.lomoye.hours.core.domain.CreditAccount;
import com.lomoye.hours.core.manager.CreditAccountManager;
import com.lomoye.common.manager.AbstractManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class CreditAccountManagerImpl extends AbstractManager<CreditAccount> implements CreditAccountManager{

    @Autowired
    private CreditAccountMapper mapper;


    @Override
    protected BasicMapper<Long, CreditAccount> getMapper() {
        return mapper;
    }
}
