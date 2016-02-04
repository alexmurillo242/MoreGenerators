package me.adamsogm.MoreGenerators;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import me.adamsogm.MoreGenerators.TileEntities.TileEntityRegistry;
import me.adamsogm.MoreGenerators.blocks.BlockList;
import me.adamsogm.MoreGenerators.items.ItemList;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

@Mod(modid = MoreGeneratorsMod.MODID, version = MoreGeneratorsMod.VERSION)
public class MoreGeneratorsMod {
	
	@Instance
	public static MoreGeneratorsMod instance = new MoreGeneratorsMod();
	
	@SidedProxy(clientSide="me.adamsogm.MoreGenerators.ClientProxy", serverSide="me.adamsogm.MoreGenerators.ServerProxy")
	public static CommonProxy proxy;

	public static CreativeTabs moGenTab = new CreativeTabs("moreGeneratorsTab") {

		@Override
		public Item getTabIconItem() {
			ItemStack iStack = new ItemStack(ItemList.wrench);
			return iStack.getItem();
		}

		@Override
		public int func_151243_f() {
			return 2;
		}
	};

	public static final String MODID = "moregenerators";
	public static final String VERSION = "1.0";
	public static final boolean DEBUGGING = true;

	@EventHandler
	public void postinit(FMLPostInitializationEvent e){
		proxy.postInit(e);
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		proxy.init(event);
	}

	@EventHandler
	public void preinit(FMLPreInitializationEvent event) {
		proxy.preInit(event);
		BlockList.init();
		ItemList.init();
		RecipeManager.init();
		TileEntityRegistry.init();
		AlloyRecipeRegistry.init();
		GameRegistry.registerWorldGenerator(new OreGenerator(), 2);
	}
}
