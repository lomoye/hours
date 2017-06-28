package com.lomoye.hours.web.controller;


import com.lomoye.hours.core.domain.ItemRecord;
import com.lomoye.hours.core.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.http.HttpServletRequest;


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
    ItemRecord addItemRecord(HttpServletRequest request, @RequestBody ItemRecord itemRecord) {
        return itemService.addItemRecord(itemRecord);
    }
}
