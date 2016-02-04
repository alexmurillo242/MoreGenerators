package me.adamsogm.MoreGenerators.TileEntities;

import cpw.mods.fml.common.registry.LanguageRegistry;
import me.adamsogm.MoreGenerators.AlloyRecipe;
import me.adamsogm.MoreGenerators.AlloyRecipeRegistry;
import me.adamsogm.MoreGenerators.MoreGeneratorsMod;
import net.minecraft.block.BlockFurnace;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityFurnace;

public class TileEntityCrucible extends TileEntity implements IInventory {

//	private static final int COOK_TIME = 200;
	private ItemStack[] inventory;
	private String customName;
	private int burnTime;
	private int cookTime;
	private int currentItemBurnTime;

	public TileEntityCrucible() {
		inventory = new ItemStack[this.getSizeInventory()];
	}

	public String getCustomName() {
		return customName;
	}

	public void setCustomName(String customName) {
		this.customName = customName;
	}

	@Override
	public int getSizeInventory() {
		return 4;
	}

	@Override
	public ItemStack getStackInSlot(int index) {
		if (index < 0 || index >= this.getSizeInventory())
			return null;
		return this.inventory[index];
	}

	@Override
	public ItemStack decrStackSize(int index, int count) {
		if (this.getStackInSlot(index) != null) {
			ItemStack itemstack;

			if (this.getStackInSlot(index).stackSize <= count) {
				itemstack = this.getStackInSlot(index);
				this.setInventorySlotContents(index, null);
				this.markDirty();
				return itemstack;
			} else {
				itemstack = this.getStackInSlot(index).splitStack(count);

				if (this.getStackInSlot(index).stackSize <= 0) {
					this.setInventorySlotContents(index, null);
				} else {
					// Just to show that changes happened
					this.setInventorySlotContents(index, this.getStackInSlot(index));
				}

				this.markDirty();
				return itemstack;
			}
		} else {
			return null;
		}
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int index) {
		ItemStack stack = this.getStackInSlot(index);
		this.setInventorySlotContents(index, null);
		return stack;
	}

	@Override
	public void setInventorySlotContents(int slot, ItemStack stack) {
		this.inventory[slot] = stack;

		if (stack != null && stack.stackSize > this.getInventoryStackLimit()) {
			stack.stackSize = this.getInventoryStackLimit();
		}
	}

	@Override
	public String getInventoryName() {
		return this.hasCustomInventoryName() ? this.customName
				: LanguageRegistry.instance()
						.getStringLocalization("container." + MoreGeneratorsMod.MODID + "_crucibleContainer");
	}

	@Override
	public boolean hasCustomInventoryName() {
		return this.customName != null && !this.customName.equals("");
	}

	@Override
	public int getInventoryStackLimit() {
		return 64;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer player) {
		return true;
	}

	@Override
	public void openInventory() {
	}

	@Override
	public void closeInventory() {
	}

	@Override
	public boolean isItemValidForSlot(int slot, ItemStack item) {
		if (item != null)
			return slot == 3 ? false : (slot == 2 ? TileEntityFurnace.isItemFuel(item) : true);
		else
			return false;
	}

	public int getCookProgressScaled(int scale) {
		System.out.println("Cook progress " + cookTime);
		return cookTime * scale / 200;
	}

	/**
	 * Returns an integer between 0 and the passed value representing how much
	 * burn time is left on the current fuel item, where 0 means that the item
	 * is exhausted and the passed value means that the item is fresh
	 */
	public int getBurnTimeRemainingScaled(int scale) {
		System.out.println("Burn time " + burnTime);
		if (this.currentItemBurnTime == 0) {
			this.currentItemBurnTime = 200;
		}

		return burnTime * scale / this.currentItemBurnTime;
	}

	public void updateEntity() {
		boolean flag = this.burnTime > 0;
		boolean flag1 = false;

		if (this.burnTime > 0) {
			--this.burnTime;
		}

		if (!this.worldObj.isRemote) {
			if (this.burnTime != 0 || this.inventory[2] != null && this.inventory[0] != null && this.inventory[1] != null) {
				if (this.burnTime == 0 && this.hasValidRecipe()) {
					this.currentItemBurnTime = this.burnTime = TileEntityFurnace.getItemBurnTime(this.inventory[2]);

					if (this.burnTime > 0) {
						flag1 = true;

						if (this.inventory[2] != null) {
							--this.inventory[2].stackSize;

							if (this.inventory[2].stackSize == 0) {
								this.inventory[2] = inventory[2].getItem()
										.getContainerItem(inventory[2]);
							}
						}
					}
				}

				if (this.isBurning() && this.hasValidRecipe()) {
					++this.cookTime;

					if (this.cookTime == 200) {
						this.cookTime = 0;
						this.smeltItem();
						flag1 = true;
					}
				} else {
					this.cookTime = 0;
				}
			}

			if (flag != this.burnTime > 0) {
				flag1 = true;
				BlockFurnace.updateFurnaceBlockState(this.burnTime > 0, this.worldObj, this.xCoord, this.yCoord,
						this.zCoord);
			}
		}

		if (flag1) {
			this.markDirty();
		}
	}

	// @Override
	// public void updateEntity() {
	// System.out.println("Update entity cook time: " + cookTime);
	// if (burnTime > 0)
	// burnTime--;
	// if (!this.worldObj.isRemote) {
	// if (hasValidRecipe()) {
	// if (burnTime == 0) {
	// cookTime = COOK_TIME;
	// burnTime = currentItemBurnTime =
	// TileEntityFurnace.getItemBurnTime(getStackInSlot(2));
	// decrStackSize(2, 1);
	// } else if (cookTime == 0) {
	// AlloyRecipe recipe = getRecipe();
	// decrStackSize(0,
	// recipe.getComponent(getStackInSlot(0).getItem()).stackSize);
	// decrStackSize(1,
	// recipe.getComponent(getStackInSlot(1).getItem()).stackSize);
	// if (getStackInSlot(3) != null) {
	// setInventorySlotContents(3, new ItemStack(recipe.getResult().getItem(),
	// getStackInSlot(3).stackSize + recipe.getResult().stackSize));
	// } else {
	// setInventorySlotContents(3,
	// new ItemStack(recipe.getResult().getItem(),
	// recipe.getResult().stackSize));
	// }
	// if (hasValidRecipe()) {
	// cookTime = COOK_TIME;
	// }
	// } else {
	// cookTime--;
	// }
	// }
	// }
	// this.markDirty();
	// }

	private void smeltItem() {
		AlloyRecipe recipe = getRecipe();
		decrStackSize(0, recipe.getComponent(getStackInSlot(0).getItem()).stackSize);
		decrStackSize(1, recipe.getComponent(getStackInSlot(1).getItem()).stackSize);
		if (getStackInSlot(3) != null) {
			setInventorySlotContents(3, new ItemStack(recipe.getResult().getItem(),
					getStackInSlot(3).stackSize + recipe.getResult().stackSize));
		} else {
			setInventorySlotContents(3, new ItemStack(recipe.getResult().getItem(), recipe.getResult().stackSize));
		}
	}

	private boolean hasValidRecipe() {
		return AlloyRecipeRegistry.isValidInput(getStackInSlot(0), getStackInSlot(1))
				&& isItemValidForSlot(2, getStackInSlot(2));
	}

	private AlloyRecipe getRecipe() {
		return AlloyRecipeRegistry.getAlloyRecipeFrom(getStackInSlot(0), getStackInSlot(1));
	}

	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);

		nbt.setShort("BurnTime", (short) this.burnTime);
		nbt.setShort("CookTime", (short) this.cookTime);

		NBTTagList list = new NBTTagList();
		for (int i = 0; i < this.getSizeInventory(); ++i) {
			if (this.getStackInSlot(i) != null) {
				NBTTagCompound stackTag = new NBTTagCompound();
				stackTag.setByte("Slot", (byte) i);
				this.getStackInSlot(i).writeToNBT(stackTag);
				list.appendTag(stackTag);
			}
		}
		nbt.setTag("Items", list);

		if (this.hasCustomInventoryName()) {
			nbt.setString("CustomName", this.getCustomName());
		}
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
		NBTTagList list = nbt.getTagList("Items", 10);
		for (int i = 0; i < list.tagCount(); ++i) {
			NBTTagCompound stackTag = list.getCompoundTagAt(i);
			int slot = stackTag.getByte("Slot") & 255;
			this.setInventorySlotContents(slot, ItemStack.loadItemStackFromNBT(stackTag));
		}

		this.burnTime = nbt.getShort("BurnTime");
		this.cookTime = nbt.getShort("CookTime");
		this.currentItemBurnTime = TileEntityFurnace.getItemBurnTime(this.inventory[1]);

		if (nbt.hasKey("CustomName", 8)) {
			this.setCustomName(nbt.getString("CustomName"));
		}
	}

	public boolean isBurning() {
		return burnTime > 0;
	}

}
