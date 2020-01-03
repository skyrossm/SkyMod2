package com.skyrossm.skymod;

import net.minecraft.init.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

import java.util.UUID;

import org.apache.logging.log4j.Logger;

import com.skyrossm.skymod.config.ConfigHandler;
import com.skyrossm.skymod.event.EventManager;
import com.skyrossm.skymod.proxy.IProxy;


@Mod(modid = SkyMod.MODID, name = SkyMod.NAME, version = SkyMod.VERSION)
public class SkyMod {
	
	public static final String MODID = "skymod";
	public static final String NAME = "SkyMod";
	public static final String VERSION = "1.0";
	
	@Mod.Instance(SkyMod.MODID)
	public static SkyMod instance;
	
	public static UUID globalID;
	
	@SidedProxy(
			clientSide="com.skyrossm.skymod.proxy.ClientProxy",
			serverSide="com.skyrossm.skymod.proxy.ServerProxy"
			)
	public static IProxy proxy;

	private static Logger logger;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		SkyMod.globalID = UUID.fromString("f3efbbbb-b418-4c13-82d9-28590ca0db3b");
		
		ConfigHandler.init(event.getSuggestedConfigurationFile());
		MinecraftForge.EVENT_BUS.register(new ConfigHandler());
		
		//SkyBlocks.init(event.getSide());
		//SkyItems.init(event.getSide());
		//SkyAdvancements.init();
		//PacketHandler.init();
		
		
		MinecraftForge.EVENT_BUS.register(new EventManager());
		logger = event.getModLog();
		proxy.preInit(event);
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		logger.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
		proxy.init(event);
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		logger.info("Post initlization.");
		proxy.postInit(event);
	}
	
	@EventHandler
	public void serverStarting(FMLServerStartingEvent event) {
		logger.info("Server starting.");
		proxy.serverStarting(event);
	}
}
