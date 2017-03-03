package com.cynda.test.proxy;

import com.cynda.test.init.ModBlocks;
import com.cynda.test.init.ModItems;

/**
 * Created by 15Cyndaquil on 2/16/2017.
 */
public class ClientProxy implements CommonProxy {

    @Override
    public void init() {
        ModItems.registerRenders();
        ModBlocks.registerRenders();
    }

}
