package com.lomoye.hours.web.dto;


import com.lomoye.hours.core.domain.ItemGoal;

/**
 * Created by lomoye on 2017/8/18.
 *
 */
public class ItemGoalDto {
    private String itemName;

    private ItemGoal itemGoal;


    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public ItemGoal getItemGoal() {
        return itemGoal;
    }

    public void setItemGoal(ItemGoal itemGoal) {
        this.itemGoal = itemGoal;
    }
}
