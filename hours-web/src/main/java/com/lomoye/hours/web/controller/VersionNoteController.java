package com.lomoye.hours.web.controller;

import com.lomoye.common.dto.ResultList;
import com.lomoye.hours.core.domain.User;
import com.lomoye.hours.core.domain.VersionNote;
import com.lomoye.hours.core.manager.VersionNoteManager;
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
 * Created by lomoye on 2017/8/11.
 *
 */
@Controller
@Scope(WebApplicationContext.SCOPE_REQUEST)
@RequestMapping("/api/versionNote")
public class VersionNoteController extends BaseController {
    @Autowired
    private VersionNoteManager versionNoteManager;

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ResponseBody
    ResultList<VersionNote> list(HttpServletRequest request) {
        User user = getSessionUser(request);
        List<VersionNote> versionNotes = versionNoteManager.listAllOrderByDay(user.getId());
        return new ResultList<>(versionNotes);
    }
}
