package me.adamsogm.MoreGenerators.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.ItemBlock;

public class BlockList {
	public static BlockHandler solarPanel;
	public static BlockHandler machineBlock;
	
	private static Class<?extends ItemBlock> imbh = ItemMetaBlockHandler.class;
	
	public static void init(){
		solarPanel = new SolarPanelBlock();
		register(solarPanel, imbh);
		
		machineBlock = new MachineBlock();
		register(machineBlock, imbh);
	}
	
	private static void register(BlockHandler block){
		GameRegistry.registerBlock(block, block.unlocName);
	}
	
	private static void register(BlockHandler block, Class<?extends ItemBlock> itemBlock){
		GameRegistry.registerBlock(block, itemBlock, block.unlocName);
	}
}