package com.skyrossm.skymod.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockBase extends Block{

	public BlockBase(Material blockMaterialIn) {
		super(blockMaterialIn);
		this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
	}
	
	public BlockBase(String blockName, Material materialIn){
        this(materialIn);
        setRegistryName(blockName);
        setUnlocalizedName(blockName);
    }

}
