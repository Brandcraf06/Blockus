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
		registerBlockColor(LargeFlowerPots.POTTED_LARGE_FERN, Blocks.POTTED_FERN);
		registerBlockColor(LargeFlowerPots.POTTED_OAK, Blocks.OAK_LEAVES);
		registerBlockColor(LargeFlowerPots.POTTED_SPRUCE, Blocks.SPRUCE_LEAVES);
		registerBlockColor(LargeFlowerPots.POTTED_BIRCH, Blocks.BIRCH_LEAVES);
		registerBlockColor(LargeFlowerPots.POTTED_JUNGLE, Blocks.JUNGLE_LEAVES);
		registerBlockColor(LargeFlowerPots.POTTED_ACACIA, Blocks.ACACIA_LEAVES);
		registerBlockColor(LargeFlowerPots.POTTED_DARK_OAK, Blocks.DARK_OAK_LEAVES);
		
		BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutoutMipped(),
				Hedge.SMALL_HEDGE,
				Hedge.SPRUCE_SMALL_HEDGE,
				Hedge.BIRCH_SMALL_HEDGE,
				Hedge.JUNGLE_SMALL_HEDGE,
				Hedge.ACACIA_SMALL_HEDGE,
				Hedge.DARK_OAK_SMALL_HEDGE,
				Hedge.WHITE_OAK_SMALL_HEDGE,
				LegacyBlocks.LEGACY_LEAVES,
				WhiteOak.WHITE_OAK_LEAVES,
				WhiteOak.WHITE_OAK_SAPLING,
				WhiteOak.POTTED_WHITE_OAK_SAPLING,
				ObsidianRelated.OBSIDIAN_REINFORCED_DOOR,
				ObsidianRelated.OBSIDIAN_REINFORCED_TRAPDOOR,
				CharredPlanks.CHARRED_DOOR,
				CharredPlanks.CHARRED_TRAPDOOR,
				Other.WOODEN_FRAME,
				Other.IRON_GATE,
				Other.GOLDEN_GATE,
				Other.GOLDEN_CHAIN,
				Other.GOLDEN_BARS,
				LargeFlowerPots.POTTED_ROSE_BUSH,
				LargeFlowerPots.POTTED_LILAC,
				LargeFlowerPots.POTTED_PEONY,
				LargeFlowerPots.POTTED_LARGE_FERN,
				LargeFlowerPots.POTTED_OAK,
				LargeFlowerPots.POTTED_SPRUCE,
				LargeFlowerPots.POTTED_BIRCH,
				LargeFlowerPots.POTTED_JUNGLE,
				LargeFlowerPots.POTTED_ACACIA,
				LargeFlowerPots.POTTED_DARK_OAK,
				LargeFlowerPots.POTTED_WHITE_OAK

		);
		BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getTranslucent(),
				WaterBricks.WATER_BRICKS,
				WaterBricks.WATER_BRICKS_SLAB,
				WaterBricks.WATER_BRICKS_STAIRS,
				WaterBricks.WATER_BRICKS_WALL,
				WaterBricks.CHISELED_WATER_BRICKS,
				
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
				GlassRelated.BLACK_BEVELED_GLASS,
				
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