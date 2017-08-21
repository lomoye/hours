package com.lomoye.hours.core.manager;

import com.lomoye.common.manager.DomainManager;
import com.lomoye.hours.core.domain.CreditAccountLog;

import java.util.List;


public interface CreditAccountLogManager extends DomainManager<Long,CreditAccountLog> {
    long countTodayByType(String type, Long userId);

    List<CreditAccountLog> listByUserId(Long userId);
}
