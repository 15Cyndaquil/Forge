package com.cynda.test.items;

import com.cynda.test.Referance;
import net.minecraft.item.Item;

/**
 * Created by 15Cyndaquil on 2/16/2017.
 */
public class ItemCheese extends Item {

    public ItemCheese(){
        setUnlocalizedName(Referance.TestItems.CHEESE.getUnlocalizedName());
        setRegistryName(Referance.TestItems.CHEESE.getRegistryName());
    }
}
