package com.cynda.test.init;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by 15Cyndaquil on 2/28/2017.
 */
public class ModCrafting {

    public static void register(){

        GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.cheeseBlock),"CCC", "CCC", "CCC", 'C', ModItems.cheese);

        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.cheese), Items.MILK_BUCKET, Items.MILK_BUCKET);

        GameRegistry.addSmelting(Items.MILK_BUCKET, new ItemStack(ModItems.cheese), 10f);
    }
}
