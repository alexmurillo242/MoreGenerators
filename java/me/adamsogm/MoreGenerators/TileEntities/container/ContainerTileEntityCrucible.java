package me.adamsogm.MoreGenerators.TileEntities.container;

import me.adamsogm.MoreGenerators.TileEntities.TileEntityCrucible;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerTileEntityCrucible extends Container{

	private TileEntityCrucible tec;
	
	public ContainerTileEntityCrucible(IInventory playerInv, TileEntityCrucible tec) {
		this.tec = tec;
		// Tile Entity, Slot 0-3, Slot IDs 0-3
	    addSlotToContainer(new Slot(tec, 0, 43, 17));
	    addSlotToContainer(new Slot(tec, 1, 69, 17));
	    addSlotToContainer(new Slot(tec, 2, 56, 53));
	    addSlotToContainer(new SlotOutput(tec, 3, 116, 35));

	    // Player Inventory, Slot 9-35, Slot IDs 26-29
	    for (int y = 0; y < 3; ++y) {
	        for (int x = 0; x < 9; ++x) {
	            addSlotToContainer(new Slot(playerInv, x + y * 9 + 9, 8 + x * 18, 84 + y * 18));
	        }
	    }

	    // Player Inventory, Slot 0-8, Slot IDs 30-38
	    for (int x = 0; x < 9; ++x) {
	        addSlotToContainer(new Slot(playerInv, x, 8 + x * 18, 142));
	    }
	}

	@Override
	public ItemStack transferStackInSlot(EntityPlayer playerIn, int fromSlot) {
	    ItemStack previous = null;
	    Slot slot = (Slot) this.inventorySlots.get(fromSlot);

	    if (slot != null && slot.getHasStack()) {
	        ItemStack current = slot.getStack();
	        previous = current.copy();

	        if (fromSlot < 4) {
	            // From TE Inventory to Player Inventory
	            if (!this.mergeItemStack(current, 4, 38, true))
	                return null;
	        } else {
	            // From Player Inventory to TE Inventory
	            if (!this.mergeItemStack(current, 0, 2, false))
	                return null;
	        }

	        if (current.stackSize == 0)
	            slot.putStack((ItemStack) null);
	        else
	            slot.onSlotChanged();

	        if (current.stackSize == previous.stackSize)
	            return null;
	        slot.onPickupFromSlot(playerIn, current);
	    }
	    return previous;
	}

	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return tec.isUseableByPlayer(player);
	}

}
