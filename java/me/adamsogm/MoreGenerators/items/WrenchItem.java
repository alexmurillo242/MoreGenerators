package me.adamsogm.MoreGenerators.items;

import java.util.List;

import me.adamsogm.MoreGenerators.MoreGeneratorsMod;
import me.adamsogm.MoreGenerators.blocks.WrenchableBlock;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class WrenchItem extends ItemHandler {

	public IIcon icons[] = new IIcon[7];
	
	public WrenchItem() {
		super("wrench", true);
		setHasSubtypes(true);
		setMaxStackSize(1);
	}
	
	@Override
	public boolean onItemUse(ItemStack itemstack, EntityPlayer player, World world, int x,
			int y, int z, int side, float px, float py, float pz) {
		Block block = world.getBlock(x, y, z);
		if(block instanceof WrenchableBlock) {
			((WrenchableBlock)block).onWrenched(0, world, x, y, z, player);
			return true;
		}
		
		return false;
	}
	
	@Override
	public void registerIcons(IIconRegister r) {
		for(int i = 0; i < icons.length; i++){
			icons[i] = r.registerIcon(MoreGeneratorsMod.MODID + ":" + unlocName + i);
		}
	}
	
	@Override
	public String getUnlocalizedName(ItemStack stack) {
	    return this.getUnlocalizedName() + "_" + stack.getItemDamage();
	}
	
	@Override
	public IIcon getIconFromDamage(int meta) {
		if(meta >= icons.length){
			meta = 0;
		}
		return icons[meta];
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void getSubItems(Item item, CreativeTabs tab, List list) {
		for (int i = 0; i < icons.length; i ++) {
	        list.add(new ItemStack(item, 1, i));
	    }
	}

}
