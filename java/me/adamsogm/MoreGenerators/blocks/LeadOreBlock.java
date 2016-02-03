package me.adamsogm.MoreGenerators.blocks;

import java.util.ArrayList;
import java.util.Random;

import me.adamsogm.MoreGenerators.items.ItemList;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class LeadOreBlock extends BlockHandler {

	public LeadOreBlock(Material material, String unlocalizedName, float hardness, String harvestToolClass,
			int harvestLevel, float resistance) {
		super(material, unlocalizedName, hardness, harvestToolClass, harvestLevel, resistance);
	}
	
	@Override
	public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune) {
		ArrayList<ItemStack> res = new ArrayList<ItemStack>();
		Random rand = new Random();
		
		res.add(new ItemStack(BlockList.leadOre));
		if(rand.nextInt(100) < 50){
			res.add(new ItemStack(ItemList.antimonyNugget, rand.nextInt(fortune + 2)));
			
		}
		
		return res;
	}

}
