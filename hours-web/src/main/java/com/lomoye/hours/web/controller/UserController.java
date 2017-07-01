package com.lomoye.hours.web.controller;

import com.google.common.base.Strings;
import com.lomoye.common.dto.ResultData;
import com.lomoye.common.exception.BusinessException;

import com.lomoye.hours.core.constant.ErrorCode;
import com.lomoye.hours.core.constant.SessionConstant;
import com.lomoye.hours.core.domain.User;

import com.lomoye.hours.core.encryption.AesEncryption;
import com.lomoye.hours.core.encryption.CookieHelper;
import com.lomoye.hours.core.manager.UserManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.WebApplicationContext;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Created by lomoye on 2017/6/12.
 * 测试用
 */
@Controller
@Scope(WebApplicationContext.SCOPE_REQUEST)
@RequestMapping("/api/user")
public class UserController extends BaseController {
    @Autowired
    private UserManager userManager;

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    ResultData<User> getUser(HttpServletRequest request) {
        return new ResultData<>(getSessionUser(request));
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    ResultData<User> userLogin(HttpServletRequest request, @RequestBody User user) {
        if (user == null) {
            throw new BusinessException(ErrorCode.PARAMETER_IS_ILLEGAL, "user can not null");
        }
        if (user.getMobile() == null && user.getNick() == null) {
            throw new BusinessException(ErrorCode.PARAMETER_IS_ILLEGAL, "用户名或者手机不能为空");
        }

        User selectUser = userManager.getByCondition(user);
        if (selectUser == null) {
            throw new BusinessException(ErrorCode.PARAMETER_IS_ILLEGAL, "用户不存在");
        }

        //将用户放入session中
        request.getSession().setAttribute(SessionConstant.USER, selectUser);

        return new ResultData<>(selectUser);
    }
}
