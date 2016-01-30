package me.adamsogm.MoreGenerators.items;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

public class ItemList {
	
	public static ItemHandler wrench;
	public static ItemHandler copperIngot;
	public static ItemHandler ironSheet;
	public static ItemHandler lightFocus;
	public static ItemHandler superiorFocus;
	
	public static void init(){
		wrench = new WrenchItem();
		register(wrench);
		
		copperIngot = new CopperIngotItem();
		register(copperIngot);
		OreDictionary.registerOre("ingotCopper", copperIngot);
		
		ironSheet = new IronSheetItem();
		register(ironSheet);
		
		lightFocus = new LightFocusItem();
		register(lightFocus);
		
		superiorFocus = new SuperiorFocus();
		register(superiorFocus);
	}
	
	public static void register(ItemHandler item){
		GameRegistry.registerItem(item, item.unlocName);
	}
}
