package com.lomoye.hours.core.manager.impl;

import com.google.common.base.Preconditions;
import com.lomoye.common.dao.BasicMapper;
import com.lomoye.common.dao.Page;
import com.lomoye.hours.core.dao.ArticleMapper;
import com.lomoye.hours.core.domain.Article;
import com.lomoye.hours.core.manager.ArticleManager;
import com.lomoye.common.manager.AbstractManager;
import com.lomoye.hours.core.model.ArticleSearchModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class ArticleManagerImpl extends AbstractManager<Article> implements ArticleManager{

    @Autowired
    private ArticleMapper mapper;


    @Override
    protected BasicMapper<Long, Article> getMapper() {
        return mapper;
    }

    @Override
    public long countArticle(ArticleSearchModel searchModel) {
        Preconditions.checkArgument(searchModel != null);
        Article condition = new Article();
        return count(condition);
    }

    @Override
    public List<Article> searchArticle(ArticleSearchModel searchModel) {
        Preconditions.checkArgument(searchModel != null);
        Page page = new Page(searchModel);
        page.addOrder("id", "desc");
        return nonEmptyList(listWithPage(new Article(), page));
    }
}
