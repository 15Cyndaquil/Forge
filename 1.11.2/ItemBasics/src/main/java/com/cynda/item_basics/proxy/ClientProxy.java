package com.cynda.item_basics.proxy;

import com.cynda.item_basics.init.ModItems;

/**
 * Created by 15Cyndaquil on 2/16/2017.
 */
public class ClientProxy implements CommonProxy {

    @Override
    public void init() {
        ModItems.registerRenders();
    }

}
