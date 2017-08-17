package com.lomoye.hours.core.dao;

import com.lomoye.common.dao.PagedMapper;
import org.springframework.stereotype.Repository;
import com.lomoye.hours.core.domain.ItemGoal;


@Repository
public interface ItemGoalMapper extends PagedMapper<Long,ItemGoal> {
}
