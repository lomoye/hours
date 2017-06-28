package com.lomoye.hours.core.dao;


import com.lomoye.common.dao.PagedMapper;
import com.lomoye.hours.core.domain.ItemParamValue;

import org.springframework.stereotype.Repository;


@Repository
public interface ItemParamValueMapper extends PagedMapper<Long,ItemParamValue> {
}
