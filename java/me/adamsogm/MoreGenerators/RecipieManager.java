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

public class RecipieManager {
	public static void init(){
		
		if(MoreGeneratorsMod.DEBUGGING){
			GameRegistry.addRecipe(new ItemStack(Blocks.crafting_table, 64),
					"A",
					'A', Blocks.dirt );

			GameRegistry.addRecipe(new ItemStack(Blocks.stone),
					"AA",
					'A', Blocks.dirt);
			
			GameRegistry.addRecipe(new ItemStack(Blocks.cobblestone, 64), 
					"A ",
					" A",
					'A', Blocks.dirt);
			
			GameRegistry.addRecipe(new ItemStack(Items.iron_ingot, 64), 
					"AA",
					"A ",
					'A', Blocks.dirt);
			
			GameRegistry.addRecipe(new ItemStack(Blocks.dirt, 64), 
					"AA",
					"AA",
					'A', Blocks.dirt);
			
			GameRegistry.addRecipe(new ItemStack(ItemList.copperIngot, 64), 
					"AAA",
					'A', Blocks.dirt);
			
			GameRegistry.addRecipe(new ItemStack(Items.redstone, 64), 
					"A A",
					'A', Blocks.dirt);
			
			GameRegistry.addRecipe(new ItemStack(Blocks.glass, 64), 
					"A A",
					"A A",
					'A', Blocks.dirt);
			
			GameRegistry.addRecipe(new ItemStack(Items.quartz), 
					"A A",
					" A ",
					'A', Blocks.dirt);
			
			GameRegistry.addRecipe(new ItemStack(Blocks.planks), 
					"A A",
					"AAA",
					'A', Blocks.dirt);
		} // End of debugging recipes
		
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
				"A A",
				" B ",
				"A A",
				'A', Blocks.dirt,
				'B', new ItemStack(BlockList.machineBlock, 1, 3));
		
		GameRegistry.addRecipe(new ItemStack(BlockList.machineBlock, 1, 5), 
				"A A",
				" B ",
				"A A",
				'A', Blocks.dirt,
				'B', new ItemStack(BlockList.machineBlock, 1, 4));
		
		GameRegistry.addRecipe(new ItemStack(BlockList.machineBlock, 1, 6), 
				"A A",
				" B ",
				"A A",
				'A', Blocks.dirt,
				'B', new ItemStack(BlockList.machineBlock, 1, 5));
		
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
	}
}
