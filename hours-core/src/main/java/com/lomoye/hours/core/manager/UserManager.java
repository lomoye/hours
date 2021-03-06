package com.lomoye.hours.core.manager;

import com.lomoye.common.manager.DomainManager;
import com.lomoye.hours.core.domain.User;


public interface UserManager extends DomainManager<Long,User> {
    User findByMobile(String mobile);

    User findByMobileAndPassword(String mobile, String password);
}
