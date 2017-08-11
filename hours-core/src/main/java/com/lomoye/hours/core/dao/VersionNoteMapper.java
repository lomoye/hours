package com.lomoye.hours.core.dao;

import com.lomoye.common.dao.PagedMapper;
import org.springframework.stereotype.Repository;
import com.lomoye.hours.core.domain.VersionNote;


@Repository
public interface VersionNoteMapper extends PagedMapper<Long,VersionNote> {
}
