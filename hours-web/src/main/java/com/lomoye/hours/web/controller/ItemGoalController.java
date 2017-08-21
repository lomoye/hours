package com.lomoye.hours.web.controller;

import com.lomoye.common.dto.ResultData;
import com.lomoye.common.dto.ResultList;
import com.lomoye.common.exception.BusinessException;
import com.lomoye.common.util.DateUtil;
import com.lomoye.hours.core.constant.ErrorCode;
import com.lomoye.hours.core.domain.Item;
import com.lomoye.hours.core.domain.ItemGoal;
import com.lomoye.hours.core.domain.ItemRecord;
import com.lomoye.hours.core.domain.User;
import com.lomoye.hours.core.enums.ItemGoalStatus;
import com.lomoye.hours.core.manager.ItemGoalManager;
import com.lomoye.hours.core.manager.ItemManager;
import com.lomoye.hours.core.manager.ItemRecordManager;
import com.lomoye.hours.web.dto.ItemGoalDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by lomoye on 2017/8/18.
 *
 */
@Controller
@Scope(WebApplicationContext.SCOPE_REQUEST)
@RequestMapping("/api/itemGoal")
public class ItemGoalController extends BaseController {

    @Autowired
    private ItemGoalManager itemGoalManager;
    @Autowired
    private ItemManager itemManager;
    @Autowired
    private ItemRecordManager itemrecordManager;

    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    ResultData<ItemGoal> addItemGoal(HttpServletRequest request, @RequestBody ItemGoal itemGoal) {
        User user = getSessionUser(request);

        long count = itemGoalManager.countItemGoal(ItemGoalStatus.START, user.getId());
        if (count > 0) {
            LOGGER.info("you has one goal on process|userId={}", user.getId());
            throw new BusinessException(ErrorCode.PARAMETER_IS_ILLEGAL, "你已有一个进行中的目标,请等该目标完成后再创建新的目标");
        }

        ItemRecord todayItemRecord = itemrecordManager.findTodayItemRecord(user.getId(), itemGoal.getItemId());
        if (todayItemRecord == null) {
            LOGGER.info("you today have no record,please record one|userId={}", user.getId());
            throw new BusinessException(ErrorCode.PARAMETER_IS_ILLEGAL, "你今天还没有该项目的数据记录，请先去记录一条数据吧");
        }

        itemGoal.setUserId(user.getId());
        itemGoal.setStartTime(DateUtil.getDailyStartTime(new Date()));
        itemGoal.setStatus(ItemGoalStatus.START);
        itemGoalManager.save(itemGoal);
        return new ResultData<>(itemGoal);
    }


    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ResponseBody
    ResultList<ItemGoalDto> listItemGoal(HttpServletRequest request) {
        User user = getSessionUser(request);
        List<ItemGoal> itemGoals = itemGoalManager.listAllItemGoalOfUser(user.getId());
        List<ItemGoalDto> dtos = new ArrayList<>();
        for (ItemGoal itemGoal : itemGoals) {
            ItemGoalDto dto = new ItemGoalDto();
            dto.setItemGoal(itemGoal);
            Item item = itemManager.findByItemId(itemGoal.getItemId(), user.getId());
            dto.setItemName(item.getName());
            dtos.add(dto);
        }
        return new ResultList<>(dtos);
    }
}
