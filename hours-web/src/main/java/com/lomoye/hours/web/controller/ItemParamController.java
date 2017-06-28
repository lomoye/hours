package com.lomoye.hours.web.controller;

import com.google.common.collect.Lists;

import com.lomoye.hours.core.domain.ItemParam;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.http.HttpServletRequest;

import java.util.Date;
import java.util.List;

/**
 * Created by lomoye on 2017/6/28.
 * 项目参数指标类
 */
@Controller
@Scope(WebApplicationContext.SCOPE_REQUEST)
@RequestMapping("/api/itemParam")
public class ItemParamController {
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ResponseBody
    List<ItemParam> listItemParams(HttpServletRequest request, Long itemId) {
        ItemParam itemParam1 = new ItemParam();
        itemParam1.setDisplayName("体重");
        itemParam1.setItemId(1L);
        itemParam1.setType("NUMBER");
        itemParam1.setUnit("kg");
        itemParam1.setCreateTime(new Date());
        itemParam1.setModifyTime(new Date());

        return Lists.newArrayList(itemParam1);
    }
}
