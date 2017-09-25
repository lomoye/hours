package com.lomoye.hours.core.manager;

import com.lomoye.common.manager.DomainManager;
import com.lomoye.hours.core.domain.User;
import com.lomoye.hours.core.domain.UserSuggest;
import com.lomoye.hours.core.model.UserSuggestSearchModel;

import java.util.List;


public interface UserSuggestManager extends DomainManager<Long,UserSuggest> {
    long searchCount(UserSuggestSearchModel searchModel, User user);

    List<UserSuggest> search(UserSuggestSearchModel searchModel, User user);
}
