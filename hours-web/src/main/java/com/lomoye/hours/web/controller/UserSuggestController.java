package com.lomoye.hours.web.controller;

import com.lomoye.common.dto.ResultData;
import com.lomoye.common.dto.ResultPagedList;
import com.lomoye.hours.core.domain.User;
import com.lomoye.hours.core.domain.UserSuggest;
import com.lomoye.hours.core.enums.UserSuggestStatus;
import com.lomoye.hours.core.manager.UserSuggestManager;
import com.lomoye.hours.core.model.UserSuggestSearchModel;
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
 * Created by lomoye on 2017/9/21.
 * 用户建议
 */
@Controller
@Scope(WebApplicationContext.SCOPE_REQUEST)
@RequestMapping("/api/userSuggest")
public class UserSuggestController extends BaseController {
    @Autowired
    private UserSuggestManager userSuggestManager;

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @ResponseBody
    ResultPagedList<UserSuggest> searchUserSuggest(HttpServletRequest request, @RequestBody UserSuggestSearchModel searchModel) {
        User user = getSessionUser(request);

        long count = userSuggestManager.searchCount(searchModel, user);
        List<UserSuggest> userSuggests = userSuggestManager.search(searchModel, user);
        return new ResultPagedList<>(userSuggests, count, searchModel);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    ResultData<UserSuggest> addUserSuggest(HttpServletRequest request, @RequestBody UserSuggest userSuggest) {
        User user = getSessionUser(request);
        userSuggest.setUserId(user.getId());
        userSuggest.setUserNick(user.getNick());
        userSuggest.setStatus(UserSuggestStatus.WAIT_PROCESS);

        userSuggestManager.save(userSuggest);
        return new ResultData<>(userSuggest);
    }
}
