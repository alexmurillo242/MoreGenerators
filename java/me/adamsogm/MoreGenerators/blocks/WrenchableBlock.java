package me.adamsogm.MoreGenerators.blocks;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public interface WrenchableBlock {
	void onWrenched(int wrenchLevel, World world, int x, int y, int z, EntityPlayer player);
}
