package com.lomoye.hours.core.dao;


import com.lomoye.common.dao.PagedMapper;
import com.lomoye.hours.core.domain.Item;
import org.springframework.stereotype.Repository;


@Repository
public interface ItemMapper extends PagedMapper<Long, Item> {

}
