package com.lomoye.hours.web.controller;

import com.google.common.collect.Lists;

import com.lomoye.hours.core.domain.ItemParam;
import com.lomoye.hours.core.manager.ItemParamManager;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private ItemParamManager itemParamManager;

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ResponseBody
    List<ItemParam> listItemParams(HttpServletRequest request, Long itemId) {
        return itemParamManager.findByItemId(itemId);
    }
}