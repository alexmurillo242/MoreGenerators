package me.adamsogm.MoreGenerators.blocks;

import java.util.Random;

import me.adamsogm.MoreGenerators.MoreGeneratorsGuiHandler;
import me.adamsogm.MoreGenerators.MoreGeneratorsMod;
import me.adamsogm.MoreGenerators.TileEntities.TileEntityCrucible;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class CrucibleBlock extends BlockHandler implements ITileEntityProvider {

	public CrucibleBlock(Material material, String unlocalizedName, float hardness, String harvestToolClass,
			int harvestLevel, float resistance) {
		super(material, unlocalizedName, hardness, harvestToolClass, harvestLevel, resistance);
		isBlockContainer = true;
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		return new TileEntityCrucible();
	}

	@Override
	public void breakBlock(World world, int x, int y, int z, Block oldblock, int oldMetadata) {
		Random rand = new Random();
		TileEntityCrucible tileentity = (TileEntityCrucible) world.getTileEntity(x, y, z);

		if (tileentity != null) {
			for (int i = 0; i < tileentity.getSizeInventory(); i++) {
				ItemStack itemstack = tileentity.getStackInSlot(i);

				if (itemstack != null) {
					float f = rand.nextFloat() * 0.8F + 0.1F;
					float f1 = rand.nextFloat() * 0.8F + 0.1F;
					float f2 = rand.nextFloat() * 0.8F + 0.1F;

					while (itemstack.stackSize > 0) {
						int j = rand.nextInt(21) + 10;

						if (j > itemstack.stackSize) {
							j = itemstack.stackSize;
						}

						itemstack.stackSize -= j;

						EntityItem item = new EntityItem(world, (double) ((float) x + f), (double) ((float) y + f1),
								(double) ((float) z + f2),
								new ItemStack(itemstack.getItem(), j, itemstack.getItemDamage()));

						if (itemstack.hasTagCompound()) {
							item.getEntityItem().setTagCompound((NBTTagCompound) itemstack.getTagCompound().copy());
						}

						world.spawnEntityInWorld(item);
					}
				}
			}

			world.func_147453_f(x, y, z, oldblock);
		}

		super.breakBlock(world, x, y, z, oldblock, oldMetadata);
	}

	@Override
	public boolean onBlockEventReceived(World world, int x, int y, int z, int p_149696_5_, int p_149696_6_) {
		super.onBlockEventReceived(world, x, y, x, p_149696_5_, p_149696_6_);
		TileEntity tileentity = world.getTileEntity(x, y, z);
		return tileentity != null ? tileentity.receiveClientEvent(p_149696_5_, p_149696_6_) : false;
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z,
			EntityPlayer player, int side, float dX, float dY, float dZ) {
		if(!world.isRemote){
			player.openGui(MoreGeneratorsMod.instance, MoreGeneratorsGuiHandler.TILE_ENTITY_GUI_CRUCIBLE_ID, world, x, y, z);
		}
		return true;
	}

}
