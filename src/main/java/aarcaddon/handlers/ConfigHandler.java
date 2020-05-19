package aarcaddon.handlers;

import java.io.File;
import java.util.HashMap;

import net.minecraftforge.common.config.Configuration;

public class ConfigHandler
{
	public static Configuration config;
	
	public static String[] structureDeclaration = {""};
	
	public static HashMap<String, String[]> structureDeclarationList = new HashMap<>();
	
	public static void initConfig(File configFile)
	{
		config = new Configuration(configFile);
		
		structureDeclaration = config.getStringList("structureDeclaration", "General", structureDeclaration, "Declare structures to be added in atlas, format: structurename,alwaysvisible,markertype,label");
		if (config.hasChanged())
		{
			config.save();
		}
	}
	
	public static void buildList()
	{
		if(structureDeclaration.length>0)
		{
			for(String input : structureDeclaration)
			{
				String[] list = input.split(",");
				if(list.length==4)
				{
					String[] listInfo = new String[] { list[1].trim(),list[2].trim(),list[3] };
					structureDeclarationList.put(list[0].trim(), listInfo);
				}
			}
		}
	}
}
