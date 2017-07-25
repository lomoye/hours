package com.lomoye.hours.core.manager;

import com.lomoye.common.manager.DomainManager;
import com.lomoye.hours.core.domain.Article;
import com.lomoye.hours.core.model.ArticleSearchModel;

import java.util.List;


public interface ArticleManager extends DomainManager<Long,Article> {
    long countArticle(ArticleSearchModel searchModel);

    List<Article> searchArticle(ArticleSearchModel searchModel);
}
