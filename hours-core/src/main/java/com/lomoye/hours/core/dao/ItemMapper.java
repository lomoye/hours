package com.lomoye.hours.core.dao;


import com.lomoye.common.dao.PagedMapper;
import com.lomoye.hours.core.domain.Item;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface ItemMapper extends PagedMapper<Long, Item> {

    void logicallyDeleteById(@Param("id") Long id, @Param("userId") Long userId);
}
