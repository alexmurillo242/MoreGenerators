package me.adamsogm.MoreGenerators;

import cpw.mods.fml.common.network.IGuiHandler;
import me.adamsogm.MoreGenerators.TileEntities.TileEntityCrucible;
import me.adamsogm.MoreGenerators.TileEntities.container.ContainerTileEntityCrucible;
import me.adamsogm.MoreGenerators.gui.GuiTileEntityCrucible;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class MoreGeneratorsGuiHandler implements IGuiHandler{

	public static final int TILE_ENTITY_GUI_CRUCIBLE_ID = 0;

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
	    if (ID == TILE_ENTITY_GUI_CRUCIBLE_ID)
	        return new ContainerTileEntityCrucible(player.inventory, (TileEntityCrucible) world.getTileEntity(x, y, z));

	    return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
	    if (ID == TILE_ENTITY_GUI_CRUCIBLE_ID)
	        return new GuiTileEntityCrucible(player.inventory, (TileEntityCrucible) world.getTileEntity(x, y, z));

	    return null;
	}

}
