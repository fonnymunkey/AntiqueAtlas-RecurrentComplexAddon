package aarcaddon.handlers;

import hunternif.mc.atlas.api.AtlasAPI;
import ivorius.reccomplex.events.StructureGenerationEventLite;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class EventHandler {
	
	@SubscribeEvent(priority = EventPriority.LOW)
	public void onStructureGenerationLitePost(StructureGenerationEventLite.Post event)
	{
		World world = event.getWorld();
		if(world.isRemote) return;
		
		StructureBoundingBox boundingBox = event.getBoundingBox();
		String structureName = event.getStructureName();
		
		int minX = boundingBox.minX;
		int minZ = boundingBox.minZ;
		int maxX = boundingBox.maxX;
		int maxZ = boundingBox.maxZ;
		int middleX = (Math.round(maxX - minX)/2)+minX;
		int middleZ = (Math.round(maxZ - minZ)/2)+minZ;
		
		if(ConfigHandler.structureDeclarationList.containsKey(structureName))
		{
			String[] list = ConfigHandler.structureDeclarationList.get(structureName);
			AtlasAPI.getMarkerAPI().putGlobalMarker(world, Boolean.parseBoolean(list[0]), list[1], list[2], middleX, middleZ);
		}
	}
}
