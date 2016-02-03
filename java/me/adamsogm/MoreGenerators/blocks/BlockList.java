package me.adamsogm.MoreGenerators.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.oredict.OreDictionary;

public class BlockList {
	public static BlockHandler solarPanel, 
	machineBlock, 
	copperOre, 
	tungstenOre,
	titaniumOre,
	tinOre,
	leadOre,
	nickelOre,
	crucible;
	
	private static Class<?extends ItemBlock> imbh = ItemMetaBlockHandler.class;
	
	public static void init(){
		solarPanel = new SolarPanelBlock();
		register(solarPanel, imbh);
		
		machineBlock = new MachineBlock();
		register(machineBlock, imbh);
		
		copperOre = new BlockHandler(Material.rock, "copperOre", 1, "pickaxe", 1, 1);
		register(copperOre, "oreCopper");
		
		tungstenOre = new BlockHandler(Material.rock, "tungstenOre", 1, "pickaxe", 1, 1);
		register(tungstenOre, "oreTungsten");
		
		titaniumOre = new BlockHandler(Material.rock, "titaniumOre", 1, "pickaxe", 1, 1);
		register(titaniumOre, "oreTitanium");
		
		tinOre = new BlockHandler(Material.rock, "tinOre", 1, "pickaxe", 1, 1);
		register(tinOre, "oreTin");
		
		leadOre = new LeadOreBlock(Material.rock, "leadOre", 1, "pickaxe", 1, 1);
		register(leadOre, "oreLead");
		
		nickelOre = new BlockHandler(Material.rock, "nickelOre", 1, "pickaxe", 1, 1);
		register(nickelOre, "oreNickel");
		
		crucible = new CrucibleBlock(Material.rock, "crucible", 1, "pickaxe", 1, 1);
		register(crucible);
	}
	
	private static void register(BlockHandler block){
		GameRegistry.registerBlock(block, block.unlocName);
	}
	
	private static void register(BlockHandler block, Class<?extends ItemBlock> itemBlock){
		GameRegistry.registerBlock(block, itemBlock, block.unlocName);
	}
	
	private static void register(BlockHandler block, String oreDictName){
		register(block);
		OreDictionary.registerOre(oreDictName, block);
	}
}