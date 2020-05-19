package aarcaddon.core.proxies;

import aarcaddon.handlers.ConfigHandler;
import aarcaddon.handlers.EventHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy
{
	public boolean isClient()
	{
		return false;
	}
	
	public void registerHandlers()
	{
		MinecraftForge.EVENT_BUS.register(new EventHandler());
	}
	
	public void registerConfig(FMLPreInitializationEvent event)
	{
		ConfigHandler.initConfig(event.getSuggestedConfigurationFile());;
	}
	
	public void initList()
	{
		ConfigHandler.buildList();
	}
}
