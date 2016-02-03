package me.adamsogm.MoreGenerators.TileEntities;

import cpw.mods.fml.common.registry.GameRegistry;
import me.adamsogm.MoreGenerators.MoreGeneratorsMod;
import net.minecraft.tileentity.TileEntity;

public final class TileEntityRegistry {
	public static void init(){
		register(TileEntityCrucible.class, "tileEntityCrucible");
	}
	
	private static void register(Class<?extends TileEntity> tileEntityClass, String id){
		GameRegistry.registerTileEntity(tileEntityClass, MoreGeneratorsMod.MODID + "_" + id);
	}
}
