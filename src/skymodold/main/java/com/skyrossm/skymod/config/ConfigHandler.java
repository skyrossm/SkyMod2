package com.skyrossm.skymod.config;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

public class ConfigHandler {
	
	public static Configuration config;
	
	public static void init(File configFile){
        if(config == null){
            config = new Configuration(configFile);
            //loadConfig();
        }
    }
}
