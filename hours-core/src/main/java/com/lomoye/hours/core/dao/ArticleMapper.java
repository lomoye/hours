package com.lomoye.hours.core.dao;

import com.lomoye.common.dao.PagedMapper;
import com.lomoye.hours.core.domain.Article;
import org.springframework.stereotype.Repository;


@Repository
public interface ArticleMapper extends PagedMapper<Long,Article> {
}
