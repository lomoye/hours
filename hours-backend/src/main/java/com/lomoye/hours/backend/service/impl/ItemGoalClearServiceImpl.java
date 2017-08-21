package com.lomoye.hours.backend.service.impl;


import com.lomoye.common.util.SerializationUtil;
import com.lomoye.hours.backend.service.ItemGoalClearService;
import com.lomoye.hours.core.domain.ItemGoal;
import com.lomoye.hours.core.domain.ItemParamValue;
import com.lomoye.hours.core.enums.CreditAccountLogType;
import com.lomoye.hours.core.enums.ItemGoalStatus;
import com.lomoye.hours.core.manager.ItemGoalManager;
import com.lomoye.hours.core.manager.ItemParamValueManager;
import com.lomoye.hours.core.service.CreditAccountService;
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
    @Autowired
    private CreditAccountService creditAccountService;

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
        if (!checkItemGoal(itemGoal)) {
            return;
        }

        ItemParamValue startValue = itemParamValueManager.findByDay(itemGoal.getStartTime(), itemGoal.getUserId(), itemGoal.getItemId(), itemGoal.getItemParamId());

        if (startValue == null) {
            LOGGER.warn("startValue not exist|itemGoalId={}", itemGoal.getId());
            return;
        }

        ItemParamValue endValue = itemParamValueManager.findByDay(itemGoal.getEndTime(), itemGoal.getUserId(), itemGoal.getItemId(), itemGoal.getItemParamId());
        if (endValue == null) {
            LOGGER.warn("endValue not exist, please add|itemGoalId={}", itemGoal.getId());
            return;
        }

        compute(startValue, endValue, itemGoal);
    }

    private void compute(ItemParamValue startValue, ItemParamValue endValue, ItemGoal itemGoal) {
        BigDecimal sv = new BigDecimal(startValue.getValue());
        BigDecimal ev = new BigDecimal(endValue.getValue());
        BigDecimal gv = new BigDecimal(itemGoal.getGoalNum());

        LOGGER.info("compute|sv={}|ev={}|gv={}|itemGoalId={}", itemGoal.getId());
        //TODO 这里业务逻辑有缺陷 不一定大于0才是对的 但对于记录体重来说没错 先这样吧 以后再改
        if (ev.subtract(gv).doubleValue() > 0) {
            LOGGER.info("you have not finish the goal|id={}", itemGoal.getId());
            itemGoal.setStatus(ItemGoalStatus.FAILED);
            itemGoalManager.update(itemGoal);
            return;
        }

        Long credit = sv.subtract(ev).multiply(new BigDecimal(itemGoal.getCreditRate())).multiply(new BigDecimal(10)).longValue();
        //增加积分
        creditAccountService.addCreditUtilSuccess(itemGoal.getUserId(), credit, CreditAccountLogType.ITEM_GOAL, itemGoal.getId().toString());
        //更新目标状态
        itemGoal.setStatus(ItemGoalStatus.SUCCESS);
        itemGoalManager.update(itemGoal);
    }

    private boolean checkItemGoal(ItemGoal itemGoal) {
        LOGGER.info("start clearItemGoal|itemGoal={}", SerializationUtil.gson2String(itemGoal));
        if (itemGoal.getEndTime().after(new Date())) {
            LOGGER.info("this goal not end , return|itemGoal={}", SerializationUtil.gson2String(itemGoal));
            return false;
        }

        if (!ItemGoalStatus.START.equals(itemGoal.getStatus())) {
            LOGGER.info("status not start! big warning..|itemGoalId={}", itemGoal.getId());
            return false;
        }

        LOGGER.info("start clear endTimed goal|itemGoalId={}", itemGoal.getId());
        return true;
    }
}
