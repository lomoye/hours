package com.lomoye.hours.core.dao;

import com.lomoye.common.dao.PagedMapper;
import org.springframework.stereotype.Repository;
import com.lomoye.hours.core.domain.CreditAccountLog;


@Repository
public interface CreditAccountLogMapper extends PagedMapper<Long,CreditAccountLog> {
}
