package com.lomoye.hours.core.manager.impl;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.lomoye.common.dao.BasicMapper;
import com.lomoye.common.dao.OrderCondition;
import com.lomoye.hours.core.dao.VersionNoteMapper;
import com.lomoye.hours.core.domain.VersionNote;
import com.lomoye.hours.core.manager.VersionNoteManager;
import com.lomoye.common.manager.AbstractManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class VersionNoteManagerImpl extends AbstractManager<VersionNote> implements VersionNoteManager{

    @Autowired
    private VersionNoteMapper mapper;


    @Override
    protected BasicMapper<Long, VersionNote> getMapper() {
        return mapper;
    }

    @Override
    public List<VersionNote> listAllOrderByDay(Long userId) {
        Preconditions.checkArgument(userId != null);
        VersionNote condition = new VersionNote();

        return nonEmptyList(listByCondition(condition, Lists.newArrayList(new OrderCondition("`day`", "desc"))));
    }
}
