package me.adamsogm.MoreGenerators.items;

import static me.adamsogm.MoreGenerators.MoreGeneratorsMod.moGenTab;

import me.adamsogm.MoreGenerators.MoreGeneratorsMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemHandler extends Item {
	public String unlocName;

	public ItemHandler(String unlocalizedName, boolean customRender){
		super();
		this.unlocName = unlocalizedName;
		setUnlocalizedName(MoreGeneratorsMod.MODID + "_" + unlocalizedName);
		setCreativeTab(moGenTab);
		if (!customRender)
			setTextureName(MoreGeneratorsMod.MODID + ":" + unlocalizedName);
	}
}
