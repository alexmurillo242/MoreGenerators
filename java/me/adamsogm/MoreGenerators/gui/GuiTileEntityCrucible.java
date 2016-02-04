package me.adamsogm.MoreGenerators.gui;

import cpw.mods.fml.common.registry.LanguageRegistry;
import me.adamsogm.MoreGenerators.MoreGeneratorsMod;
import me.adamsogm.MoreGenerators.TileEntities.TileEntityCrucible;
import me.adamsogm.MoreGenerators.TileEntities.container.ContainerTileEntityCrucible;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;

public class GuiTileEntityCrucible extends GuiContainer {

	private IInventory playerInv;
	private TileEntityCrucible te;

	public GuiTileEntityCrucible(IInventory playerInv, TileEntityCrucible te) {
		super(new ContainerTileEntityCrucible(playerInv, te));

		this.playerInv = playerInv;
		this.te = te;

		this.xSize = 176;
		this.ySize = 166;
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTick, int mouseX, int mouseY) {
		this.mc.getTextureManager()
				.bindTexture(new ResourceLocation(MoreGeneratorsMod.MODID + ":textures/gui/crucible.png"));
		int k = (this.width - this.xSize) / 2;
		int l = (this.height - this.ySize) / 2;
		this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
		if (this.te.isBurning()) {
			int i1 = this.te.getBurnTimeRemainingScaled(13);
			this.drawTexturedModalRect(k + 56, l + 36 + 12 - i1, 176, 12 - i1, 14, i1 + 1);
			i1 = this.te.getCookProgressScaled(24);
			this.drawTexturedModalRect(k + 79, l + 34, 176, 14, i1 + 1, 16);
		}
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
		String s = this.te.getInventoryName();
		this.fontRendererObj.drawString(s, 88 - this.fontRendererObj.getStringWidth(s) / 2, 6, 4210752); // #404040
		this.fontRendererObj.drawString(
				LanguageRegistry.instance().getStringLocalization(this.playerInv.getInventoryName()), 8, 72, 4210752); // #404040
	}

}
