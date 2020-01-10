package com.skyrossm.skymod.init;

import com.skyrossm.skymod.block.BlockBase;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;

public class SkyBlocks {
	public static final BlockBase oreCobalt = new BlockBase("oreCobalt", Material.ROCK);
    public static final BlockBase oreSilver = new BlockBase("oreSilver", Material.ROCK);
    public static final BlockBase oreCopper = new BlockBase("oreCopper", Material.ROCK);
    public static final BlockBase oreTitanium = new BlockBase("oreTitanium", Material.ROCK);
    
    
    public static void init(Side side) {
        oreCobalt.setHardness(2F);
        oreSilver.setHardness(1F);
        oreCopper.setHardness(1F);
        oreTitanium.setHardness(5F);
        
        registerBlocks(side, oreCobalt, oreSilver, oreCopper, oreTitanium);
        System.out.println("debug: loaded blocks");
    }
    
    private static void registerBlocks(Side side, Block...blocks){
        for(Block block : blocks){
            final ItemBlock itemBlock = new ItemBlock(block);
            if(side == Side.CLIENT){
                ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation(block.getRegistryName(), "inventory"));
            }
        }
    }

	public static void registerBlocks(Register<Block> event) {
		event.getRegistry().registerAll(oreCobalt, oreSilver, oreCopper, oreTitanium);
	}
}
