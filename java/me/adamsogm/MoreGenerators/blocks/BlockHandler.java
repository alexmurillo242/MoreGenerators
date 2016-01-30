package me.adamsogm.MoreGenerators.blocks;

import static me.adamsogm.MoreGenerators.MoreGeneratorsMod.moGenTab;

import me.adamsogm.MoreGenerators.MoreGeneratorsMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockHandler extends Block {

	public String unlocName;

	/**
	 * Standard block constructor
	 * 
	 * @param material
	 * @param unlocalizedName
	 * @param creativeTab
	 * @param hardness
	 * @param harvestToolClass
	 * @param harvestLevel
	 *            0 wood/gold, 1 stone, 2 iron, 3 diamond
	 * @param resistance
	 */
	protected BlockHandler(Material material, String unlocalizedName, float hardness,
			String harvestToolClass, int harvestLevel, float resistance, boolean customRender) {
		super(material);
		this.unlocName = unlocalizedName;
		setBlockName(MoreGeneratorsMod.MODID + "_" + unlocalizedName);
		setCreativeTab(moGenTab);
		if (!customRender)
			setBlockTextureName(MoreGeneratorsMod.MODID + ":" + unlocalizedName);
		setHardness(hardness);
		setHarvestLevel(harvestToolClass, harvestLevel);
		setResistance(resistance);
	}

}
