package com.lomoye.hours.core.manager.impl;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.lomoye.common.dao.BasicMapper;
import com.lomoye.hours.core.dao.CreditAccountLogMapper;
import com.lomoye.hours.core.domain.CreditAccountLog;
import com.lomoye.hours.core.manager.CreditAccountLogManager;
import com.lomoye.common.manager.AbstractManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class CreditAccountLogManagerImpl extends AbstractManager<CreditAccountLog> implements CreditAccountLogManager{

    @Autowired
    private CreditAccountLogMapper mapper;


    @Override
    protected BasicMapper<Long, CreditAccountLog> getMapper() {
        return mapper;
    }

    @Override
    public long countByType(String type, Long userId) {
        Preconditions.checkArgument(!Strings.isNullOrEmpty(type) && userId != null);
        CreditAccountLog condition = new CreditAccountLog();
        condition.setUserId(userId);
        condition.setType(type);
        return count(condition);
    }
}
