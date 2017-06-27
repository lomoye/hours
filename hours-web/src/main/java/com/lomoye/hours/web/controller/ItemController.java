package com.lomoye.hours.web.controller;

import com.google.common.collect.Lists;
import com.lomoye.hours.domain.Item;
import com.lomoye.hours.domain.User;
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
 * Created by lomoye on 2017/6/27.
 * 项目的控制类
 */
@Controller
@Scope(WebApplicationContext.SCOPE_REQUEST)
@RequestMapping("/api/item")
public class ItemController {

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ResponseBody
    List<Item> listItems(HttpServletRequest request) {
        Item item1 = new Item();
        item1.setName("减肥");
        item1.setDesc("吃饱了在减肥");
        item1.setId(1L);
        item1.setCreateTime(new Date());
        item1.setModifyTime(new Date());

        Item item2 = new Item();
        item2.setName("电影");
        item2.setDesc("看看电影逛逛街");
        item2.setId(2L);
        item2.setCreateTime(new Date());
        item2.setModifyTime(new Date());

        return Lists.newArrayList(item1, item2);
    }

}
