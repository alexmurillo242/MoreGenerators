package me.adamsogm.MoreGenerators.blocks;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import me.adamsogm.MoreGenerators.MoreGeneratorsMod;
import me.adamsogm.MoreGenerators.ToolTier;
import me.adamsogm.MoreGenerators.items.ItemList;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.IIcon;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

public class SolarPanelBlock extends BlockHandler implements WrenchableBlock{
	
	private IIcon icons[][];
	
	public static final String UNLOCALIZED_NAME = "basicSolar";
	
	public SolarPanelBlock(){
		super(Material.rock, UNLOCALIZED_NAME, .10f, "pickaxe", 0, 10, true);
	}
	
	@Override
	public void getSubBlocks(Item item, CreativeTabs tab, List list) {
		for (int i = 1; i < 7; i++) {
			list.add(new ItemStack(item, 1, i));
		}
	}
	
	@Override
	public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune) {
		ArrayList<ItemStack> drops = new ArrayList<ItemStack>();
		
		drops.add(new ItemStack(BlockList.machineBlock));
		
		return drops;
	}

	@Override
	public void onWrenched(int wrenchLevel, World world, int x, int y, int z, EntityPlayer player) {
		if(world.getBlock(x, y, z) == BlockList.solarPanel && !world.isRemote && player.isSneaking()){
			Random random = new Random();
			int result = random.nextInt(4);
			switch(result){
			case 0:
			case 1:
				int meta = world.getBlockMetadata(x, y, z);
				world.func_147480_a(x, y, z, false); // Destroy block
				world.spawnEntityInWorld(new EntityItem(world, x, y, z, new ItemStack(BlockList.solarPanel, 1, meta)));
				break;
			case 2:
				meta = world.getBlockMetadata(x, y, z);
				world.func_147480_a(x, y, z, false); // Destroy block
				world.spawnEntityInWorld(new EntityItem(world, x, y, z, new ItemStack(BlockList.machineBlock, 1, meta)));
				break;
			case 3:
				world.func_147480_a(x, y, z, false); // Destroy block
				//world.createExplosion(null, x, y, z, 10, false);
				Explosion explosion = new Explosion(world, player, x, y, z, 10);
				DamageSource ds = new DamageSource(MoreGeneratorsMod.MODID + ".wrenchBoom");
				ds.setExplosionSource(explosion);
				explosion.doExplosionA();
				explosion.doExplosionB(true);
				player.attackEntityFrom(ds, 10);
				break;
			}
		}
	}
	
	@Override
	public IIcon getIcon(int side, int meta) {
		ToolTier tier = ToolTier.getTier(meta);
		if (tier == null) {
			meta = 0;
			tier = ToolTier.getTier(meta);
		} else if(meta < 0 || meta > 6){
			meta = 0;
		}
		return icons[meta][side];
	}

	@Override
	public void registerBlockIcons(IIconRegister r) {
		icons = new IIcon[7][6];

		for (int i = 0; i < icons.length; i++) {
			for(int j = 0; j < icons[i].length; j++){
				switch(j){
				case 1:
					icons[i][j] = r.registerIcon(MoreGeneratorsMod.MODID + ":" + unlocName + "_" + i + "_top");
					break;
				case 0:
					icons[i][j] = r.registerIcon(MoreGeneratorsMod.MODID + ":" + unlocName + "_" + i + "_bottom");
					break;
				case 2:
				case 3:
				case 4:
				case 5:
					icons[i][j] = r.registerIcon(MoreGeneratorsMod.MODID + ":" + unlocName + "_" + i + "_side");
					break;
				}			
			}
		}
	}
}
