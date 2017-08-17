package com.lomoye.hours.core.manager.impl;

import com.lomoye.common.dao.BasicMapper;
import com.lomoye.hours.core.dao.ItemGoalMapper;
import com.lomoye.hours.core.domain.ItemGoal;
import com.lomoye.hours.core.manager.ItemGoalManager;
import com.lomoye.common.manager.AbstractManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ItemGoalManagerImpl extends AbstractManager<ItemGoal> implements ItemGoalManager{

    @Autowired
    private ItemGoalMapper mapper;


    @Override
    protected BasicMapper<Long, ItemGoal> getMapper() {
        return mapper;
    }
}
