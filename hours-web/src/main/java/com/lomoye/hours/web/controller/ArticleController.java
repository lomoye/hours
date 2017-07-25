package com.lomoye.hours.web.controller;

import com.lomoye.common.dao.OrderCondition;
import com.lomoye.common.dto.ResultData;
import com.lomoye.common.dto.ResultList;
import com.lomoye.common.dto.ResultPagedList;
import com.lomoye.hours.core.domain.Article;

import com.lomoye.hours.core.manager.ArticleManager;
import com.lomoye.hours.core.model.ArticleSearchModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.http.HttpServletRequest;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by lomoye on 2017/7/25.
 *
 */
@Controller
@Scope(WebApplicationContext.SCOPE_REQUEST)
@RequestMapping("/api/article")
public class ArticleController extends BaseController {

    @Autowired
    private ArticleManager articleManager;

    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    ResultData<Article> addArticle(HttpServletRequest request) {

        return new ResultData<>();
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @ResponseBody
    ResultPagedList<Article> searchArticle(HttpServletRequest request, @RequestBody ArticleSearchModel searchModel) {
        List<Article> articles = articleManager.searchArticle(searchModel);
        long count = articleManager.countArticle(searchModel);
        return new ResultPagedList<>(articles, count, searchModel);
    }
}
