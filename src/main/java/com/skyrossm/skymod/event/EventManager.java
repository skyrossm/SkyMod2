package com.skyrossm.skymod.event;

import com.skyrossm.skymod.init.SkyBlocks;

import net.minecraft.block.Block;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class EventManager {
	
	/*
	 * Main on tick method
	 */
	@SubscribeEvent
	public void livingUpdate(LivingUpdateEvent event){
		
	}
	
	@SubscribeEvent
	public void registerBlocks(RegistryEvent.Register<Block> event) {
		SkyBlocks.registerBlocks(event);
		System.out.println("Registered blocks.");
	}
	
}
