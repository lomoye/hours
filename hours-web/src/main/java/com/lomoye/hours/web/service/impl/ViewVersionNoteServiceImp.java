package com.lomoye.hours.web.service.impl;

import com.google.common.base.Function;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimaps;
import com.lomoye.common.util.DateUtil;
import com.lomoye.hours.core.domain.User;
import com.lomoye.hours.core.domain.VersionNote;
import com.lomoye.hours.core.manager.VersionNoteManager;
import com.lomoye.hours.web.dto.VersionNoteDto;
import com.lomoye.hours.web.service.ViewVersionNoteService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by lomoye on 2017/8/17.
 *
 */
@Service
public class ViewVersionNoteServiceImp implements ViewVersionNoteService {

    @Autowired
    private VersionNoteManager versionNoteManager;

    @Override
    public List<VersionNoteDto> listVersionNoteDto(User user) {
        List<VersionNote> versionNotes = versionNoteManager.listAllOrderByDay(user.getId());
        if (CollectionUtils.isEmpty(versionNotes)) {
            return new ArrayList<>();
        }

        Map<String, List<VersionNote>> versionMap = Multimaps.asMap(Multimaps.index(versionNotes, new Function<VersionNote, String>() {
            @Override
            public String apply(VersionNote versionNote) {
                return DateUtil.format(versionNote.getDay(), "yyyy-MM-dd");
            }
        }));

        List<VersionNoteDto> versionNoteDtos = Lists.newArrayList();
        for (Map.Entry<String, List<VersionNote>> entry : versionMap.entrySet()) {
            VersionNoteDto dto = new VersionNoteDto();
            dto.setDay(entry.getKey());
            dto.setContents(FluentIterable.from(entry.getValue()).transform(new Function<VersionNote, String>() {
                @Override
                public String apply(VersionNote versionNote) {
                    return versionNote.getContent();
                }
            }).toList());
            versionNoteDtos.add(dto);
        }

        return versionNoteDtos;
    }
}
