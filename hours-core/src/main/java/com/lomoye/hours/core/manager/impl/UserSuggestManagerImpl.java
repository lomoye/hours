package com.lomoye.hours.core.manager.impl;

import com.google.common.base.Preconditions;
import com.lomoye.common.dao.BasicMapper;
import com.lomoye.common.dao.Page;
import com.lomoye.hours.core.dao.UserSuggestMapper;
import com.lomoye.hours.core.domain.User;
import com.lomoye.hours.core.domain.UserSuggest;
import com.lomoye.hours.core.manager.UserSuggestManager;
import com.lomoye.common.manager.AbstractManager;
import com.lomoye.hours.core.model.UserSuggestSearchModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class UserSuggestManagerImpl extends AbstractManager<UserSuggest> implements UserSuggestManager{

    @Autowired
    private UserSuggestMapper mapper;


    @Override
    protected BasicMapper<Long, UserSuggest> getMapper() {
        return mapper;
    }

    @Override
    public long searchCount(UserSuggestSearchModel searchModel, User user) {
        Preconditions.checkArgument(searchModel != null && user.getId() != null);
        UserSuggest condition = new UserSuggest();
        condition.setStatus(searchModel.getStatus());
        condition.setUserId(user.getId());

        return count(condition);
    }

    @Override
    public List<UserSuggest> search(UserSuggestSearchModel searchModel, User user) {
        Preconditions.checkArgument(searchModel != null && user.getId() != null);
        UserSuggest condition = new UserSuggest();
        condition.setStatus(searchModel.getStatus());
        condition.setUserId(user.getId());

        Page page = new Page(searchModel);
        return nonEmptyList(listWithPage(condition, page));
    }
}
