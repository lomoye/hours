package com.lomoye.hours.web.controller;


import com.lomoye.common.dto.ResultData;
import com.lomoye.common.exception.BusinessException;
import com.lomoye.hours.core.domain.ItemRecord;
import com.lomoye.hours.core.service.ItemService;
import com.lomoye.hours.web.dto.ItemRecordDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


/**
 * Created by lomoye on 2017/6/28.
 * 项目参数值
 */
@Controller
@Scope(WebApplicationContext.SCOPE_REQUEST)
@RequestMapping("/api/itemRecord")
public class ItemRecordController {

    @Autowired
    private ItemService itemService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    ResultData<ItemRecord> addItemRecord(HttpServletRequest request, @RequestBody ItemRecord itemRecord) {
        return new ResultData<>(itemService.addItemRecord(itemRecord));
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    ResultData<ItemRecordDto> listItemRecordDto(HttpServletRequest request, Long itemId) {
        List<ItemRecord> itemRecordList = itemService.listItemRecord(itemId);
        return new ResultData<>();
    }
}
