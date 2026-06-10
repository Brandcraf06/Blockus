package com.brand.blockus.utils.references;

import com.brand.blockus.Blockus;
import net.minecraft.references.BlockItemId;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.ColorCollection;
import net.minecraft.world.level.block.WeatheringCopperCollection;

public class BlockusIds {
    public static final ColorCollection<BlockItemId> DYED_STONE_BRICKS = createSimpleColored("stone_bricks");
    public static final ColorCollection<BlockItemId> DYED_STONE_BRICK_STAIRS = createSimpleColored("stone_brick_stairs");
    public static final ColorCollection<BlockItemId> DYED_STONE_BRICK_SLAB = createSimpleColored("stone_brick_slab");
    public static final ColorCollection<BlockItemId> DYED_STONE_BRICK_WALL = createSimpleColored("stone_brick_wall");
    public static final ColorCollection<BlockItemId> DYED_SHINGLES = createSimpleColored("shingles");
    public static final ColorCollection<BlockItemId> DYED_SHINGLES_STAIRS = createSimpleColored("shingles_stairs");
    public static final ColorCollection<BlockItemId> DYED_SHINGLES_SLAB = createSimpleColored("shingles_slab");
    public static final ColorCollection<BlockItemId> DYED_REDSTONE_LAMP = createSimpleColored("redstone_lamp");
    public static final ColorCollection<BlockItemId> DYED_LIT_REDSTONE_LAMP = createSimpleColored("redstone_lamp_lit");
    public static final ColorCollection<BlockItemId> NEON = createSimpleColored("neon");
    public static final ColorCollection<BlockItemId> FUTURNEO_BLOCK = createSimpleColored("futurneo_block");
    public static final ColorCollection<BlockItemId> STAINED_BEVELED_GLASS = createSimpleColored("beveled_glass");
    public static final ColorCollection<BlockItemId> STAINED_BEVELED_GLASS_PANE = createSimpleColored("beveled_glass_pane");
    public static final ColorCollection<BlockItemId> GLAZED_TERRACOTTA_PILLAR = createSimpleColored("glazed_terracotta_pillar");
    public static final ColorCollection<BlockItemId> CONCRETE_BRICKS = createSimpleColored("concrete_bricks");
    public static final ColorCollection<BlockItemId> CONCRETE_BRICK_STAIRS = createSimpleColored("concrete_brick_stairs");
    public static final ColorCollection<BlockItemId> CONCRETE_BRICK_SLAB = createSimpleColored("concrete_brick_slab");
    public static final ColorCollection<BlockItemId> CONCRETE_BRICK_WALL = createSimpleColored("concrete_brick_wall");
    public static final ColorCollection<BlockItemId> CHISELED_CONCRETE = createSimpleColoredFromPattern("chiseled_{color}_concrete");
    public static final ColorCollection<BlockItemId> CONCRETE_PILLAR = createSimpleColored("concrete_pillar");
    public static final ColorCollection<BlockItemId> PATTERNED_WOOL = createSimpleColored("patterned_wool");
    public static final ColorCollection<BlockItemId> PATTERNED_WOOL_STAIRS = createSimpleColored("patterned_wool_stairs");
    public static final ColorCollection<BlockItemId> PATTERNED_WOOL_SLAB = createSimpleColored("patterned_wool_slab");
    public static final ColorCollection<BlockItemId> PATTERNED_CARPET = createSimpleColored("patterned_carpet");
    public static final ColorCollection<BlockItemId> GINGHAM_WOOL = createSimpleColored("gingham_wool");
    public static final ColorCollection<BlockItemId> GINGHAM_WOOL_STAIRS = createSimpleColored("gingham_wool_stairs");
    public static final ColorCollection<BlockItemId> GINGHAM_WOOL_SLAB = createSimpleColored("gingham_wool_slab");
    public static final ColorCollection<BlockItemId> GINGHAM_CARPET = createSimpleColored("gingham_carpet");
    public static final ColorCollection<BlockItemId> ASPHALT = createColoredAsphalt("asphalt");
    public static final ColorCollection<BlockItemId> ASPHALT_STAIRS = createColoredAsphalt("asphalt_stairs");
    public static final ColorCollection<BlockItemId> ASPHALT_SLAB = createColoredAsphalt("asphalt_slab");
    public static final ColorCollection<BlockItemId> COLORED_TILES = createSimpleColored("colored_tiles");
    public static final WeatheringCopperCollection<BlockItemId> COPPER_BRICKS = createSimpleCopper("copper_bricks");
    public static final WeatheringCopperCollection<BlockItemId> COPPER_BRICK_STAIRS = createSimpleCopper("copper_brick_stairs");
    public static final WeatheringCopperCollection<BlockItemId> COPPER_BRICK_SLAB = createSimpleCopper("copper_brick_slab");
    public static final WeatheringCopperCollection<BlockItemId> COPPER_BRICK_WALL = createSimpleCopper("copper_brick_wall");
    public static final WeatheringCopperCollection<BlockItemId> COPPER_TUFF_BRICKS = createSimpleCopper("copper_tuff_bricks");
    public static final WeatheringCopperCollection<BlockItemId> COPPER_TUFF_BRICK_STAIRS = createSimpleCopper("copper_tuff_brick_stairs");
    public static final WeatheringCopperCollection<BlockItemId> COPPER_TUFF_BRICK_SLAB = createSimpleCopper("copper_tuff_brick_slab");
    public static final WeatheringCopperCollection<BlockItemId> COPPER_TUFF_BRICK_WALL = createSimpleCopper("copper_tuff_brick_wall");
    public static final WeatheringCopperCollection<BlockItemId> COPPER_LANTERN_BLOCK = createSimpleCopper("copper_lantern_block");
    public static final WeatheringCopperCollection<BlockItemId> COPPER_GATE = createSimpleCopper("copper_gate");


    public static BlockItemId create(String name) {
        Identifier id = Identifier.fromNamespaceAndPath(Blockus.MOD_ID, name);
        return BlockItemId.create(id, id);
    }

    public static ColorCollection<BlockItemId> createSimpleColored(String baseName) {
        return ColorCollection.prefixWithColor(ColorCollection.create(baseName)).map(BlockusIds::create);
    }

    public static ColorCollection<BlockItemId> createSimpleColoredFromPattern(String baseName) {
        return ColorCollection.VALUES.map(color -> baseName.replace("{color}", color.getName())).map(BlockusIds::create);
    }

    public static ColorCollection<BlockItemId> createColoredAsphalt(String baseName) {
        return ColorCollection.zipMap(ColorCollection.VALUES, ColorCollection.create(baseName), (color, id) -> color == DyeColor.BLACK ? id : color + "_" + id).map(BlockusIds::create);
    }

    public static WeatheringCopperCollection<BlockItemId> createSimpleCopper(String baseName) {
        return WeatheringCopperCollection.prefixWithState(WeatheringCopperCollection.create(baseName)).map(BlockusIds::create);
    }
}
