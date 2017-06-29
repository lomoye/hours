package com.lomoye.hours.web.controller;

import com.lomoye.common.dto.ResultData;
import com.lomoye.hours.core.domain.User;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.http.HttpServletRequest;


/**
 * Created by lomoye on 2017/6/12.
 * 测试用
 */
@Controller
@Scope(WebApplicationContext.SCOPE_REQUEST)
@RequestMapping("/api/user")
public class HelloController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    ResultData<User> giveHelloData(HttpServletRequest request) {
        User user = new User();
        user.setName("庆祝服务器定时发布任务脚本运行成功!");
        user.setAge(18);

        return new ResultData<>(user);
    }
}
