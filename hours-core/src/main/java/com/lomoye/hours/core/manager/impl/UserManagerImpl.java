package com.lomoye.hours.core.manager.impl;

import com.lomoye.common.dao.BasicMapper;
import com.lomoye.hours.core.dao.UserMapper;
import com.lomoye.hours.core.domain.User;
import com.lomoye.hours.core.manager.UserManager;
import com.lomoye.common.manager.AbstractManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class UserManagerImpl extends AbstractManager<User> implements UserManager{

    @Autowired
    private UserMapper mapper;


    @Override
    protected BasicMapper<Long, User> getMapper() {
        return mapper;
    }
}
