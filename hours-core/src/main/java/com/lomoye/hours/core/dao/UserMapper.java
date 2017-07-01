package com.lomoye.hours.core.dao;

import com.lomoye.common.dao.PagedMapper;
import com.lomoye.hours.core.domain.User;
import org.springframework.stereotype.Repository;


@Repository
public interface UserMapper extends PagedMapper<Long,User> {
}
