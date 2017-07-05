package com.lomoye.hours.web.service;


import com.lomoye.hours.web.dto.ItemRecordDto;
import com.lomoye.hours.web.dto.ItemRecordTableDto;

import java.util.List;

/**
 * Created by lomoye on 2017/6/30.
 * item数据拼装service
 */
public interface ViewItemService {
    List<ItemRecordDto> listItemRecordDto(Long userId, Long itemId);

    ItemRecordTableDto reportItemRecord(Long userId, Long itemId);
}
