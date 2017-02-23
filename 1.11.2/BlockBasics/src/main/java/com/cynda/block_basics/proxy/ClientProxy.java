package com.cynda.block_basics.proxy;

import com.cynda.block_basics.init.ModBlocks;

/**
 * Created by 15Cyndaquil on 2/16/2017.
 */
public class ClientProxy implements CommonProxy {

    @Override
    public void init() {
        ModBlocks.registerRenders();
    }

}
