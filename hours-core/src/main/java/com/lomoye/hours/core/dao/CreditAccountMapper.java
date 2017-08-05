package com.lomoye.hours.core.dao;

import com.lomoye.common.dao.PagedMapper;
import org.springframework.stereotype.Repository;
import com.lomoye.hours.core.domain.CreditAccount;


@Repository
public interface CreditAccountMapper extends PagedMapper<Long,CreditAccount> {
    int updateByPrimaryKeyWithVersion(CreditAccount creditAccount);
}
