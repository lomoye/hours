package com.lomoye.hours.core.manager.impl;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.lomoye.common.dao.BasicMapper;
import com.lomoye.common.dao.OrderCondition;
import com.lomoye.common.util.DateUtil;
import com.lomoye.hours.core.dao.CreditAccountLogMapper;
import com.lomoye.hours.core.domain.CreditAccountLog;
import com.lomoye.hours.core.manager.CreditAccountLogManager;
import com.lomoye.common.manager.AbstractManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;


@Component
public class CreditAccountLogManagerImpl extends AbstractManager<CreditAccountLog> implements CreditAccountLogManager{

    @Autowired
    private CreditAccountLogMapper mapper;


    @Override
    protected BasicMapper<Long, CreditAccountLog> getMapper() {
        return mapper;
    }

    @Override
    public long countTodayByType(String type, Long userId) {
        Preconditions.checkArgument(!Strings.isNullOrEmpty(type) && userId != null);
        CreditAccountLog condition = new CreditAccountLog();
        condition.setUserId(userId);
        condition.setType(type);
        condition.setDay(DateUtil.getDailyStartTime(new Date()));
        return count(condition);
    }

    @Override
    public List<CreditAccountLog> listByUserId(Long userId) {
        Preconditions.checkArgument(userId != null);
        CreditAccountLog condition = new CreditAccountLog();
        condition.setUserId(userId);

        return listByCondition(condition, Lists.newArrayList(new OrderCondition("`id`", "desc")));
    }


}
