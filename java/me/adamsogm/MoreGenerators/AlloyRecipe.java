package me.adamsogm.MoreGenerators;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class AlloyRecipe {
	private ItemStack component1;
	private ItemStack component2;
	private ItemStack result;

	public AlloyRecipe(ItemStack component1, ItemStack component2, ItemStack result) {
		super();
		this.component1 = component1;
		this.component2 = component2;
		this.result = result;
	}

	public boolean canProduceFrom(ItemStack stack1, ItemStack stack2) {
		if (stack1 != null && stack2 != null) {
			if (stack1.getItem() == component1.getItem() && stack2.getItem() == component2.getItem()) {
				if (stack1.stackSize >= component1.stackSize && stack2.stackSize >= component2.stackSize) {
					return true;
				} else {
					return false;
				}
			} else if (stack1.getItem() == component2.getItem()) {
				if (stack1.stackSize >= component2.stackSize && stack2.stackSize >= component1.stackSize) {
					return true;
				} else {
					return false;
				}
			} else {
				return false;
			}
		}else{
			return false;
		}
	}

	public ItemStack getComponent1() {
		return component1;
	}

	public ItemStack getComponent2() {
		return component2;
	}

	public ItemStack getComponent(Item item) {
		if (component1.getItem() == item) {
			return component1;
		} else if (component2.getItem() == item) {
			return component2;
		} else {
			return null;
		}
	}

	public ItemStack getResult() {
		return result;
	}
}