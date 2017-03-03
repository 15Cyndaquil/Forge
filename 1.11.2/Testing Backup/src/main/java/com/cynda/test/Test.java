package com.cynda.test;

import com.cynda.test.init.ModBlocks;
import com.cynda.test.init.ModCrafting;
import com.cynda.test.init.ModItems;
import com.cynda.test.proxy.CommonProxy;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * Created by 15Cyndaquil on 2/16/2017.
 */


@Mod(
        modid = Referance.MOD_ID,
        name = Referance.NAME,
        version = Referance.VERSION,
        acceptedMinecraftVersions = Referance.ACCEPTED_VERSIONS
    )
public class Test {

    @Mod.Instance
    public static Test instance;

    @SidedProxy(
                    clientSide = Referance.CLIENT_PROXY_CLASS,
                    serverSide = Referance.SERVER_PROXY_CLASS
                )
    public static CommonProxy proxy;



    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event){

        ModItems.init();
        ModItems.register();

        ModBlocks.init();
        ModBlocks.register();

    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event){

        proxy.init();

        ModCrafting.register();

    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event){

    }

}