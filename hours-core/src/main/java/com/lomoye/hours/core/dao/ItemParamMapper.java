package com.lomoye.hours.core.dao;


import com.lomoye.common.dao.PagedMapper;
import com.lomoye.hours.core.domain.ItemParam;

import org.springframework.stereotype.Repository;


@Repository
public interface ItemParamMapper extends PagedMapper<Long,ItemParam> {
}
