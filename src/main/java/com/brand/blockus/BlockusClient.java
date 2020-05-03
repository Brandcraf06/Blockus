package com.brand.blockus;

import com.brand.blockus.content.*;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.color.block.BlockColorProvider;
import net.minecraft.client.color.item.ItemColorProvider;
import net.minecraft.client.render.RenderLayer;

public class BlockusClient implements ClientModInitializer {

	@Override
public void onInitializeClient() {
		
		registerBlockColor(Hedge.SMALL_HEDGE, Blocks.OAK_LEAVES);
		registerBlockColor(Hedge.SPRUCE_SMALL_HEDGE, Blocks.SPRUCE_LEAVES);
		registerBlockColor(Hedge.BIRCH_SMALL_HEDGE, Blocks.BIRCH_LEAVES);
		registerBlockColor(Hedge.JUNGLE_SMALL_HEDGE, Blocks.JUNGLE_LEAVES);
		registerBlockColor(Hedge.ACACIA_SMALL_HEDGE, Blocks.ACACIA_LEAVES);
		registerBlockColor(Hedge.DARK_OAK_SMALL_HEDGE, Blocks.DARK_OAK_LEAVES);
		registerBlockColor(WaterBricks.WATER_BRICKS, Blocks.WATER);
		registerBlockColor(WaterBricks.WATER_BRICKS_STAIRS, Blocks.WATER);
		registerBlockColor(WaterBricks.WATER_BRICKS_SLAB, Blocks.WATER);
		registerBlockColor(WaterBricks.WATER_BRICKS_WALL, Blocks.WATER);
		registerBlockColor(WaterBricks.CHISELED_WATER_BRICKS, Blocks.WATER);

		BlockRenderLayerMap.INSTANCE.putBlock(Hedge.SMALL_HEDGE, RenderLayer.getCutoutMipped());
		BlockRenderLayerMap.INSTANCE.putBlock(Hedge.SPRUCE_SMALL_HEDGE, RenderLayer.getCutoutMipped());
		BlockRenderLayerMap.INSTANCE.putBlock(Hedge.BIRCH_SMALL_HEDGE, RenderLayer.getCutoutMipped());
		BlockRenderLayerMap.INSTANCE.putBlock(Hedge.JUNGLE_SMALL_HEDGE, RenderLayer.getCutoutMipped());
		BlockRenderLayerMap.INSTANCE.putBlock(Hedge.ACACIA_SMALL_HEDGE, RenderLayer.getCutoutMipped());
		BlockRenderLayerMap.INSTANCE.putBlock(Hedge.DARK_OAK_SMALL_HEDGE, RenderLayer.getCutoutMipped());
		BlockRenderLayerMap.INSTANCE.putBlock(Hedge.WHITE_OAK_SMALL_HEDGE, RenderLayer.getCutoutMipped());
		BlockRenderLayerMap.INSTANCE.putBlock(LegacyBlocks.LEGACY_LEAVES, RenderLayer.getCutoutMipped());
		BlockRenderLayerMap.INSTANCE.putBlock(WhiteOak.WHITE_OAK_LEAVES, RenderLayer.getCutoutMipped());
		BlockRenderLayerMap.INSTANCE.putBlock(WhiteOak.WHITE_OAK_SAPLING, RenderLayer.getCutoutMipped());
		BlockRenderLayerMap.INSTANCE.putBlock(WhiteOak.POTTED_WHITE_OAK_SAPLING, RenderLayer.getCutoutMipped());
		BlockRenderLayerMap.INSTANCE.putBlock(ObsidianRelated.OBSIDIAN_REINFORCED_DOOR, RenderLayer.getCutoutMipped());
		BlockRenderLayerMap.INSTANCE.putBlock(ObsidianRelated.OBSIDIAN_REINFORCED_TRAPDOOR, RenderLayer.getCutoutMipped());
		BlockRenderLayerMap.INSTANCE.putBlock(CharredPlanks.CHARRED_DOOR, RenderLayer.getCutoutMipped());
		BlockRenderLayerMap.INSTANCE.putBlock(CharredPlanks.CHARRED_TRAPDOOR, RenderLayer.getCutoutMipped());
		BlockRenderLayerMap.INSTANCE.putBlock(Other.WOODEN_FRAME, RenderLayer.getCutoutMipped());
		BlockRenderLayerMap.INSTANCE.putBlock(Other.IRON_GATE, RenderLayer.getCutoutMipped());
		BlockRenderLayerMap.INSTANCE.putBlock(Other.GOLDEN_CHAIN, RenderLayer.getCutoutMipped());
		
		BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getTranslucent(),
				WaterBricks.WATER_BRICKS,
				WaterBricks.WATER_BRICKS_SLAB,
				WaterBricks.WATER_BRICKS_STAIRS,
				WaterBricks.WATER_BRICKS_WALL,
				WaterBricks.CHISELED_WATER_BRICKS
		);

		BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getTranslucent(),
				GlassRelated.BEVELED_GLASS,
				GlassRelated.WHITE_BEVELED_GLASS,
				GlassRelated.ORANGE_BEVELED_GLASS,
				GlassRelated.MAGENTA_BEVELED_GLASS,
				GlassRelated.LIGHT_BLUE_BEVELED_GLASS,
				GlassRelated.YELLOW_BEVELED_GLASS,
				GlassRelated.LIME_BEVELED_GLASS,
				GlassRelated.PINK_BEVELED_GLASS,
				GlassRelated.LIGHT_GRAY_BEVELED_GLASS,
				GlassRelated.GRAY_BEVELED_GLASS,
				GlassRelated.CYAN_BEVELED_GLASS,
				GlassRelated.PURPLE_BEVELED_GLASS,
				GlassRelated.BLUE_BEVELED_GLASS,
				GlassRelated.BROWN_BEVELED_GLASS,
				GlassRelated.GREEN_BEVELED_GLASS,
				GlassRelated.RED_BEVELED_GLASS,
				GlassRelated.BLACK_BEVELED_GLASS
		);

		BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getTranslucent(),
				GlassRelated.BEVELED_GLASS_PANE,
				GlassRelated.WHITE_BEVELED_GLASS_PANE,
				GlassRelated.ORANGE_BEVELED_GLASS_PANE,
				GlassRelated.MAGENTA_BEVELED_GLASS_PANE,
				GlassRelated.LIGHT_BLUE_BEVELED_GLASS_PANE,
				GlassRelated.YELLOW_BEVELED_GLASS_PANE,
				GlassRelated.LIME_BEVELED_GLASS_PANE,
				GlassRelated.PINK_BEVELED_GLASS_PANE,
				GlassRelated.LIGHT_GRAY_BEVELED_GLASS_PANE,
				GlassRelated.GRAY_BEVELED_GLASS_PANE,
				GlassRelated.CYAN_BEVELED_GLASS_PANE,
				GlassRelated.PURPLE_BEVELED_GLASS_PANE,
				GlassRelated.BLUE_BEVELED_GLASS_PANE,
				GlassRelated.BROWN_BEVELED_GLASS_PANE,
				GlassRelated.GREEN_BEVELED_GLASS_PANE,
				GlassRelated.RED_BEVELED_GLASS_PANE,
				GlassRelated.BLACK_BEVELED_GLASS_PANE
		);

		
}
	
	public void registerBlockColor(Block block, Block templateBlock) {
		ColorProviderRegistry.BLOCK.register((block1, pos, world, layer) -> {
			BlockColorProvider provider = ColorProviderRegistry.BLOCK.get(templateBlock);
			return provider == null ? -1 : provider.getColor(block1, pos, world, layer);
		}, block);

		ColorProviderRegistry.ITEM.register((item, layer) -> {
			ItemColorProvider provider = ColorProviderRegistry.ITEM.get(templateBlock);
			return provider == null ? -1 : provider.getColor(item, layer);
		}, block.asItem());
	}

}