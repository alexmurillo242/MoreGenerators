package me.adamsogm.MoreGenerators;

import java.util.ArrayList;

import me.adamsogm.MoreGenerators.items.ItemList;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class AlloyRecipeRegistry {
	private static ArrayList<AlloyRecipe> recipes = new ArrayList<>();
	
	public static void registerRecipe(AlloyRecipe recipe){
		recipes.add(recipe);
	}
	
	public static AlloyRecipe getAlloyRecipeFrom(ItemStack stack1, ItemStack stack2){
		for(AlloyRecipe recipe: recipes){
			if(recipe.canProduceFrom(stack1, stack2)){
				return recipe;
			}
		}
		return null;
	}
	
	public static boolean isValidInput(ItemStack stack1, ItemStack stack2){
		return getAlloyRecipeFrom(stack1, stack2) != null;
	}
	
	public static void init(){
		registerRecipe(new AlloyRecipe(new ItemStack(Items.coal, 4), new ItemStack(Items.iron_ingot, 1), new ItemStack(ItemList.steelIngot, 1)));
	}
}
