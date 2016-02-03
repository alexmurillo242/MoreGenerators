package me.adamsogm.MoreGenerators;

import cpw.mods.fml.common.registry.GameRegistry;
import me.adamsogm.MoreGenerators.blocks.BlockList;
import me.adamsogm.MoreGenerators.items.ItemList;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.World;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

public class RecipeManager {
	public static void init(){
		
		GameRegistry.addSmelting(BlockList.tungstenOre, new ItemStack(ItemList.tungstenIngot), 100);
		GameRegistry.addSmelting(BlockList.copperOre, new ItemStack(ItemList.copperIngot), 100);
		GameRegistry.addSmelting(BlockList.titaniumOre, new ItemStack(ItemList.titaniumIngot), 100);
		GameRegistry.addSmelting(BlockList.leadOre, new ItemStack(ItemList.leadIngot), 100);
		GameRegistry.addSmelting(BlockList.tinOre, new ItemStack(ItemList.tinIngot), 100);
		GameRegistry.addSmelting(BlockList.nickelOre, new ItemStack(ItemList.leadIngot), 100);
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemList.antimonyIngot), 
				"NNN",
				"NNN",
				"NNN",
				'N', "nuggetAntimony"));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemList.tinIngot), 
				"NNN",
				"NNN",
				"NNN",
				'N', "nuggetTin"));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemList.nickelIngot), 
				"NNN",
				"NNN",
				"NNN",
				'N', "nuggetNickel"));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemList.leadIngot), 
				"NNN",
				"NNN",
				"NNN",
				'N', "nuggetLead"));
		
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ItemList.antimonyNugget, 9), 
				"ingotAntimony"));
		
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ItemList.tinNugget, 9), 
				"ingotTin"));
		
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ItemList.leadNugget, 9), 
				"ingotLead"));
		
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ItemList.nickelNugget, 9), 
				"ingotNickel"));
		
		GameRegistry.addRecipe(new ItemStack(ItemList.ironSheet, 2), 
				"III",
				'I', Items.iron_ingot);
		
		GameRegistry.addRecipe(new ItemStack(BlockList.solarPanel, 64, 1),
				"AAA",
				"ABA", 
				"AAA", 
				'A', Blocks.dirt,
				'B', BlockList.machineBlock);
		
		GameRegistry.addRecipe(new ItemStack(ItemList.wrench, 1, 0), 
				"A",
				"A",
				'A', Blocks.dirt
		);
		
		GameRegistry.addRecipe(new ItemStack(ItemList.wrench, 1, 1), 
				"A",
				"A",
				'A', new ItemStack(ItemList.wrench, 1, 0)
		);
		
		GameRegistry.addRecipe(new ItemStack(ItemList.wrench, 1, 2), 
				"A",
				"A",
				'A', new ItemStack(ItemList.wrench, 1, 1)
		);
		
		GameRegistry.addRecipe(new ItemStack(ItemList.wrench, 1, 3), 
				"A",
				"A",
				'A', new ItemStack(ItemList.wrench, 1, 2)
		);
		
		GameRegistry.addRecipe(new ItemStack(ItemList.wrench, 1, 4), 
				"A",
				"A",
				'A', new ItemStack(ItemList.wrench, 1, 3)
		);
		
		GameRegistry.addRecipe(new ItemStack(ItemList.wrench, 1, 5), 
				"A",
				"A",
				'A', new ItemStack(ItemList.wrench, 1, 4)
		);
		
		GameRegistry.addRecipe(new ItemStack(ItemList.wrench, 1, 6), 
				"A",
				"A",
				'A', new ItemStack(ItemList.wrench, 1, 5)
		);
		
		GameRegistry.addRecipe(new ItemStack(BlockList.machineBlock, 1, 0),
				"CSC",
				"SIS",
				"CSC",
				'C', Blocks.cobblestone,
				'S', Blocks.stone,
				'I', Items.iron_ingot);
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BlockList.machineBlock, 1, 1), 
				"SIS",
				"IFI",
				"SIS",
				'S', Blocks.stone,
				'F', new ItemStack(BlockList.machineBlock, 1, 0),
				'I', Items.iron_ingot));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BlockList.machineBlock, 1, 2), 
				"ICI",
				"IFI",
				"ICI",
				'C', "ingotCopper",
				'I', "ingotIron",
				'F', new ItemStack(BlockList.machineBlock, 1, 1)));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BlockList.machineBlock, 1, 3), 
				"ISI",
				"RFR",
				"CSC",
				'I', "ingotIron",
				'S', ItemList.ironSheet,
				'R', Blocks.redstone_block,
				'C', "ingotCopper",
				'F', new ItemStack(BlockList.machineBlock, 1, 2)));
		
		GameRegistry.addRecipe(new ItemStack(BlockList.machineBlock, 1, 4), 
				"CSC",
				"DFD",
				"BOB",
				'C', ItemList.advancedCircuit,
				'S', ItemList.steelSheet,
				'D', Items.diamond,
				'F', new ItemStack(BlockList.machineBlock, 1, 3),
				'B', ItemList.bronzeSheet,
				'O', Blocks.obsidian);
		
		GameRegistry.addRecipe(new ItemStack(BlockList.machineBlock, 1, 5), 
				"TAT",
				"QFQ",
				"THT",
				'T', ItemList.titaniumSheet,
				'A', ItemList.advancedCircuit,
				'Q', Blocks.quartz_block,
				'F', new ItemStack(BlockList.machineBlock, 1, 4),
				'H', ItemList.tungstenHeatSink);
		
		GameRegistry.addRecipe(new ItemStack(BlockList.machineBlock, 1, 6), 
				"ONO",
				"TFT",
				"TPT",
				'O', Blocks.obsidian,
				'N', ItemList.netherCore,
				'T', ItemList.titaniumSheet,
				'F', new ItemStack(BlockList.machineBlock, 1, 5),
				'P', ItemList.netherPlating);
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemList.lightFocus), 
				"G",
				"R",
				"W",
				'G', Blocks.glass,
				'R', Items.redstone,
				'W', "slabWood"));
		
		GameRegistry.addRecipe(new ItemStack(ItemList.superiorFocus), 
				" G ",
				"RQR",
				"SSS",
				'G', Blocks.glass,
				'R', Items.redstone,
				'S', Blocks.stone_slab,
				'Q', Items.quartz);
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemList.standardCircuit), 
				" I ",
				"SCR",
				"sLs",
				'I', "ingotIron",
				'S', "materialSolder",
				'C', "ingotCopper",
				's', Blocks.stone_slab,
				'L', Blocks.lapis_block,
				'R', Blocks.redstone_block));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemList.solder, 2), 
				"TTT",
				"TAL",
				"LLL",
				'T', "nuggetTin",
				'A', "nuggetAntimony",
				'L', "nuggetLead"));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemList.leadlessSolder, 2), 
				"TTT",
				"TAT",
				"TAA",
				'T', "nuggetTin",
				'A', "nuggetAntimony"));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemList.advancedCircuit), 
				" C ",
				"SPR",
				"sLs",
				'C', ItemList.standardCircuit,
				'S', "materialSolder",
				'P', ItemList.copperSheet,
				'R', Blocks.redstone_block,
				's', Blocks.stone_slab,
				'L', Blocks.lapis_block));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemList.copperSheet, 2), 
				"CCC",
				'C', "ingotCopper"));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemList.titaniumSheet, 2), 
				"TTT",
				'T', "ingotTitanium"));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemList.tungstenHeatSink, 2),
				"TTT",
				'T', "ingotTungsten"));
		
		GameRegistry.addRecipe(new ItemStack(ItemList.netherCore), 
				"BOB",
				"ONO",
				"BOB",
				'B', Blocks.nether_brick,
				'O', Blocks.obsidian,
				'N', Items.nether_star);
		
		GameRegistry.addRecipe(new ItemStack(ItemList.netherPlating), 
				"SOS",
				"TNT",
				'S', Blocks.soul_sand,
				'O', Blocks.obsidian,
				'T', ItemList.titaniumSheet,
				'N', Items.nether_star);
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemList.steelSheet, 2), 
				"SSS",
				'S', "ingotSteel"));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemList.bronzeSheet, 2),
				"BBB",
				'B', "ingotBronze"));
	}
}
