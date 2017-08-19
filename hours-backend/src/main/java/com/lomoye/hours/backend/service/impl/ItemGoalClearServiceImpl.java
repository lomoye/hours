package com.lomoye.hours.backend.service.impl;


import com.lomoye.common.util.DateUtil;
import com.lomoye.common.util.SerializationUtil;
import com.lomoye.hours.backend.service.ItemGoalClearService;
import com.lomoye.hours.core.domain.ItemGoal;
import com.lomoye.hours.core.domain.ItemParamValue;
import com.lomoye.hours.core.enums.ItemGoalStatus;
import com.lomoye.hours.core.manager.ItemGoalManager;
import com.lomoye.hours.core.manager.ItemParamValueManager;
import org.apache.commons.collections.CollectionUtils;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.PersistJobDataAfterExecution;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by lomoye on 2017/8/18.
 */
@DisallowConcurrentExecution
@PersistJobDataAfterExecution
@Service
public class ItemGoalClearServiceImpl implements ItemGoalClearService {
    private Logger LOGGER = LoggerFactory.getLogger(ItemGoalClearServiceImpl.class);

    @Autowired
    private ItemGoalManager itemGoalManager;
    @Autowired
    private ItemParamValueManager itemParamValueManager;

    @Override
    public void clearItemGoal() {
        List<ItemGoal> itemGoals = itemGoalManager.getAllStartGoal();
        if (CollectionUtils.isEmpty(itemGoals)) {
            return;
        }

        for (ItemGoal itemGoal : itemGoals) {
            doClearItemGoal(itemGoal);
        }
    }

    private void doClearItemGoal(ItemGoal itemGoal) {
        checkItemGoal(itemGoal);
    }

    private void checkItemGoal(ItemGoal itemGoal) {
        LOGGER.info("start clearItemGoal|itemGoal={}", SerializationUtil.gson2String(itemGoal));
        if (itemGoal.getEndTime().after(new Date())) {
            LOGGER.info("this goal not end , return|itemGoal={}", SerializationUtil.gson2String(itemGoal));
            return;
        }

        if (!ItemGoalStatus.START.equals(itemGoal.getStatus())) {
            LOGGER.warn("status not start! big warning..|itemGoalId={}", itemGoal.getId());
            return;
        }

        LOGGER.info("start clear endTimed goal|itemGoalId={}", itemGoal.getId());
    }
}
