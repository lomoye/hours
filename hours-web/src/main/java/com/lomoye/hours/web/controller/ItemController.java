package com.lomoye.hours.web.controller;

import com.lomoye.common.dto.ResultList;
import com.lomoye.hours.core.domain.Item;
import com.lomoye.hours.core.manager.ItemManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by lomoye on 2017/6/27.
 * 项目的控制类
 */
@Controller
@Scope(WebApplicationContext.SCOPE_REQUEST)
@RequestMapping("/api/item")
public class ItemController {
    @Autowired
    private ItemManager itemManager;

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ResponseBody
    ResultList<Item> listItems(HttpServletRequest request) {
        List<Item> items = itemManager.listAll();

        return new ResultList<>(items);
    }

}
