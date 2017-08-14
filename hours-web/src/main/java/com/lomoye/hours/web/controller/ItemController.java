package com.lomoye.hours.web.controller;

import com.lomoye.common.dto.ResultData;
import com.lomoye.common.dto.ResultList;
import com.lomoye.hours.core.domain.Item;
import com.lomoye.hours.core.domain.User;
import com.lomoye.hours.core.manager.ItemManager;
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
import java.util.List;

/**
 * Created by lomoye on 2017/6/27.
 * 项目的控制类
 */
@Controller
@Scope(WebApplicationContext.SCOPE_REQUEST)
@RequestMapping("/api/item")
public class ItemController extends BaseController {
    @Autowired
    private ItemManager itemManager;
    @Autowired
    private ItemService itemService;

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ResponseBody
    ResultList<Item> listItems(HttpServletRequest request) {
        User user = getSessionUser(request);
        List<Item> items = itemManager.listByUserId(user.getId());

        return new ResultList<>(items);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    ResultData<Item> addItem(HttpServletRequest request, @RequestBody Item item) {
        User user = getSessionUser(request);

        return new ResultData<>(itemService.addItem(user.getId(), item));
    }

    @RequestMapping(value = "", method = RequestMethod.DELETE)
    @ResponseBody
    ResultData<Boolean> deleteItem(HttpServletRequest request, Long id) {
        User user = getSessionUser(request);
        itemManager.logicallyDeleteById(id, user.getId());
        return new ResultData<>(true);
    }


}
