package aarcaddon.core;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import aarcaddon.core.proxies.CommonProxy;

@Mod(modid = AARCAddon.MODID, name = AARCAddon.NAME, version = AARCAddon.VERSION)
public class AARCAddon
{
    public static final String MODID = "aarcaddon";
    public static final String NAME = "AARCAddon";
    public static final String VERSION = "1.0.0";
    
    @SidedProxy(clientSide = "aarcaddon.core.proxies.ClientProxy", serverSide = "aarcaddon.core.proxies.CommonProxy")
    public static CommonProxy proxy;
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {      
        proxy.registerConfig(event);
        proxy.initList();
        proxy.registerHandlers();
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {

    }
}
