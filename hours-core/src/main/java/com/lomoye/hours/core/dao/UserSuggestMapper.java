package com.lomoye.hours.core.dao;

import com.lomoye.common.dao.PagedMapper;
import org.springframework.stereotype.Repository;
import com.lomoye.hours.core.domain.UserSuggest;


@Repository
public interface UserSuggestMapper extends PagedMapper<Long,UserSuggest> {
}
