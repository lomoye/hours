package com.lomoye.hours.web.service;

import com.lomoye.hours.core.domain.User;
import com.lomoye.hours.web.dto.VersionNoteDto;

import java.util.List;

/**
 * Created by lomoye on 2017/8/17.
 * versionNote数据展示
 */
public interface ViewVersionNoteService {
    List<VersionNoteDto> listVersionNoteDto(User user);
}
