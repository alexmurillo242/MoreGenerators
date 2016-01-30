package me.adamsogm.MoreGenerators.blocks;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlockWithMetadata;
import net.minecraft.item.ItemStack;

public class ItemMetaBlockHandler extends ItemBlockWithMetadata{

	public ItemMetaBlockHandler(Block block) {
		super(block, block);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String getUnlocalizedName(ItemStack stack) {
	    return this.getUnlocalizedName() + "_" + stack.getItemDamage();
	}

}
