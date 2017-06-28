package com.lomoye.hours.web.controller;

import com.lomoye.hours.core.domain.ItemParamValue;
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
@RequestMapping("/api/itemParamValue")
public class ItemParamValueController {
    @RequestMapping(value = "/batch", method = RequestMethod.POST)
    @ResponseBody
    Boolean batchAddItemParamValue(HttpServletRequest request, @RequestBody List<ItemParamValue> values) {
        return true;
    }
}
