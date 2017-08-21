package com.lomoye.hours.web.controller;

import com.lomoye.common.dto.ResultData;
import com.lomoye.common.dto.ResultList;
import com.lomoye.hours.core.domain.CreditAccount;
import com.lomoye.hours.core.domain.CreditAccountLog;
import com.lomoye.hours.core.domain.User;
import com.lomoye.hours.core.manager.CreditAccountLogManager;
import com.lomoye.hours.core.manager.CreditAccountManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.http.HttpServletRequest;


/**
 * Created by lomoye on 2017/8/5.
 * CreditAccount
 */
@Controller
@Scope(WebApplicationContext.SCOPE_REQUEST)
@RequestMapping("/api")
public class CreditAccountController extends BaseController {

    @Autowired
    private CreditAccountManager creditAccountManager;
    @Autowired
    private CreditAccountLogManager creditAccountLogManager;

    @RequestMapping(value = "/creditAccount", method = RequestMethod.GET)
    @ResponseBody
    ResultData<CreditAccount> getCreditAccount(HttpServletRequest request) {
        User user = getSessionUser(request);
        CreditAccount creditAccount = creditAccountManager.getOrCreateByUserId(user.getId());
        return new ResultData<>(creditAccount);
    }

    @RequestMapping(value = "/creditAccountLog/list", method = RequestMethod.POST)
    @ResponseBody
    ResultList<CreditAccountLog> listCreditAccountLog(HttpServletRequest request) {
        User user = getSessionUser(request);

        return new ResultList<>(creditAccountLogManager.listByUserId(user.getId()));
    }
}
