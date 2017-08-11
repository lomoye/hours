package com.lomoye.hours.core.manager.impl;

import com.lomoye.common.dao.BasicMapper;
import com.lomoye.hours.core.dao.VersionNoteMapper;
import com.lomoye.hours.core.domain.VersionNote;
import com.lomoye.hours.core.manager.VersionNoteManager;
import com.lomoye.common.manager.AbstractManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class VersionNoteManagerImpl extends AbstractManager<VersionNote> implements VersionNoteManager{

    @Autowired
    private VersionNoteMapper mapper;


    @Override
    protected BasicMapper<Long, VersionNote> getMapper() {
        return mapper;
    }
}
