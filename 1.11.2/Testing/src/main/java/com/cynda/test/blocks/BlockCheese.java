package com.cynda.test.blocks;

import com.cynda.test.Referance;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

/**
 * Created by 15Cyndaquil on 2/23/2017.
 */
public class BlockCheese extends Block{

    public BlockCheese() {
        super(Material.SPONGE);
        setUnlocalizedName(Referance.TestBlocks.CHEESEBLOCK.getUnlocalisedName());
        setRegistryName(Referance.TestBlocks.CHEESEBLOCK.getRegistryName());
    }
}
