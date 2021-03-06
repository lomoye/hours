package com.lomoye.hours.core.manager;

import com.lomoye.common.manager.DomainManager;
import com.lomoye.hours.core.domain.VersionNote;

import java.util.List;


public interface VersionNoteManager extends DomainManager<Long,VersionNote> {
    List<VersionNote> listAllOrderByDay(Long userId);
}
