package com.cynda.item_basics.init;

import com.cynda.item_basics.items.ItemCheese;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by 15Cyndaquil on 2/16/2017.
 */
public class ModItems {

    public static Item cheese;

    public static void init(){

        cheese = new ItemCheese();

    }

    public static void register(){

        GameRegistry.register(cheese);

    }

    public static void registerRenders(){

        registerRedner(cheese);

    }

    private static void registerRedner(Item item){

        ModelResourceLocation model = new ModelResourceLocation(item.getRegistryName(), "inventory");
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, model);
    }
}
