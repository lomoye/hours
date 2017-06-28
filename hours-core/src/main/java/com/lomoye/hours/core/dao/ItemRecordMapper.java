package com.lomoye.hours.core.dao;


import com.lomoye.common.dao.PagedMapper;
import com.lomoye.hours.core.domain.ItemRecord;

import org.springframework.stereotype.Repository;


@Repository
public interface ItemRecordMapper extends PagedMapper<Long,ItemRecord> {
}
