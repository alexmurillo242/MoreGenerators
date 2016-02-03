package me.adamsogm.MoreGenerators.items;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

public class ItemList {

	public static ItemHandler wrench, 
		copperIngot, 
		copperNugget, 
		titaniumIngot,
		titaniumNugget,
		tungstenIngot,
		tungstenNugget,
		ironSheet,
		lightFocus,
		superiorFocus,
		standardCircuit,
		solder,
		tinNugget,
		tinIngot,
		leadNugget,
		leadIngot,
		antimonyNugget,
		antimonyIngot,
		leadlessSolder,
		advancedCircuit,
		copperSheet,
		titaniumSheet,
		tungstenHeatSink,
		netherPlating,
		steelIngot,
		steelSheet,
		bronzeIngot,
		bronzeSheet,
		nickelIngot,
		nickelNugget,
		netherCore;

	public static void init() {
		wrench = new WrenchItem();
		register(wrench);

		copperIngot = new ItemHandler("copperIngot");
		register(copperIngot, "ingotCopper");

		titaniumIngot = new ItemHandler("titaniumIngot");
		register(titaniumIngot, "ingotTitanium");

		tungstenIngot = new ItemHandler("tungstenIngot");
		register(tungstenIngot, "ingotTungsten");

		ironSheet = new ItemHandler("ironSheet");
		register(ironSheet);

		lightFocus = new ItemHandler("lightFocus");
		register(lightFocus);

		superiorFocus = new ItemHandler("superiorFocus");
		register(superiorFocus);

		standardCircuit = new ItemHandler("standardCircuit");
		register(standardCircuit);

		solder = new ItemHandler("solder");
		register(solder, "materialSolder");

		tinNugget = new ItemHandler("tinNugget");
		register(tinNugget, "nuggetTin");

		leadNugget = new ItemHandler("leadNugget");
		register(leadNugget, "nuggetLead");

		antimonyNugget = new ItemHandler("antimonyNugget");
		register(antimonyNugget, "nuggetAntimony");

		antimonyIngot = new ItemHandler("antimonyIngot");
		register(antimonyIngot, "ingotAntimony");

		leadIngot = new ItemHandler("leadIngot");
		register(leadIngot, "ingotLead");

		tinIngot = new ItemHandler("tinIngot");
		register(tinIngot, "ingotTin");

		copperNugget = new ItemHandler("copperNugget");
		register(copperNugget, "nuggetCopper");

		titaniumNugget = new ItemHandler("titaniumNugget");
		register(titaniumNugget, "nuggetTitanium");

		tungstenNugget = new ItemHandler("tungstenNugget");
		register(tungstenNugget, "nuggetTungsten");

		leadlessSolder = new ItemHandler("leadlessSolder");
		register(leadlessSolder, "materialSolder");

		advancedCircuit = new ItemHandler("advancedCircuit");
		register(advancedCircuit);

		copperSheet = new ItemHandler("copperSheet");
		register(copperSheet);

		titaniumSheet = new ItemHandler("titaniumSheet");
		register(titaniumSheet);

		tungstenHeatSink = new ItemHandler("tungstenHeatSink");
		register(tungstenHeatSink);

		netherPlating = new ItemHandler("netherPlating");
		register(netherPlating);
		
		steelIngot = new ItemHandler("steelIngot");
		register(steelIngot, "ingotSteel");
		
		steelSheet = new ItemHandler("steelSheet");
		register(steelSheet);
		
		bronzeIngot = new ItemHandler("bronzeIngot");
		register(bronzeIngot, "ingotBronze");
		
		bronzeSheet = new ItemHandler("bronzeSheet");
		register(bronzeSheet);
		
		nickelIngot = new ItemHandler("nickelIngot");
		register(nickelIngot, "ingotNickel");
		
		nickelIngot = new ItemHandler("nickelNugget");
		register(nickelIngot, "nuggetNickel");
		
		netherCore = new ItemHandler("netherCore");
		register(netherCore);
	}

	public static void register(ItemHandler item) {
		GameRegistry.registerItem(item, item.unlocName);
	}

	public static void register(ItemHandler item, String oreDictName) {
		register(item);
		OreDictionary.registerOre(oreDictName, item);
	}
}
