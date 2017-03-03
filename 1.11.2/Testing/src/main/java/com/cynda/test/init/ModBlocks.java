package com.cynda.test.init;

import com.cynda.test.blocks.BlockCheese;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by 15Cyndaquil on 2/23/2017.
 */
public class ModBlocks {

    public static Block cheeseBlock;

    public static void init(){

        cheeseBlock = new BlockCheese();

    }

    public static void register(){

        registerBlock(cheeseBlock);

    }

    public static void registerRenders(){

        registerRedner(cheeseBlock);

    }

    private static void registerBlock(Block block){

        GameRegistry.register(block);
        ItemBlock item = new ItemBlock(block);
        item.setRegistryName(block.getRegistryName());
        GameRegistry.register(item);

    }

    private static void registerRedner(Block block){

        ModelResourceLocation model = new ModelResourceLocation(block.getRegistryName(), "inventory");
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(block), 0, model);

    }
}
