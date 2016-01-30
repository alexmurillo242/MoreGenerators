package me.adamsogm.MoreGenerators.blocks;

import java.util.List;

import me.adamsogm.MoreGenerators.MoreGeneratorsMod;
import me.adamsogm.MoreGenerators.ToolTier;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class MachineBlock extends BlockHandler implements WrenchableBlock {
	IIcon icons[];

	public MachineBlock() {
		super(Material.rock, "machineBlock", 1, "pickaxe", 0, 1, true);
	}

	@Override
	public void onWrenched(int wrenchLevel, World world, int x, int y, int z, EntityPlayer player) {
		if (!world.isRemote) {
			Block block = world.getBlock(x, y, z);
			ItemStack itemstack = new ItemStack(block, 1, world.getBlockMetadata(x, y, z));
			EntityItem ie = new EntityItem(world, x, y, z, itemstack);
			world.func_147480_a(x, y, z, false); // Destroy block
			world.spawnEntityInWorld(ie);
		}
	}

	@Override
	public IIcon getIcon(int side, int meta) {
		ToolTier tier = ToolTier.getTier(meta);
		if (tier == null) {
			meta = 0;
			tier = ToolTier.getTier(meta);
		}
		return icons[meta];
	}

	@Override
	public void registerBlockIcons(IIconRegister par1IconRegister) {
		icons = new IIcon[7];

		for (int i = 0; i < icons.length; i++) {
			icons[i] = par1IconRegister.registerIcon(MoreGeneratorsMod.MODID + ":" + unlocName + i);
		}
	}

	@Override
	public void getSubBlocks(Item item, CreativeTabs tab, List list) {
		for (int i = 0; i < 7; i++) {
			list.add(new ItemStack(item, 1, i));
		}
	}

}
