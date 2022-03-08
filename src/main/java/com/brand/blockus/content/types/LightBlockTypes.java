package com.brand.blockus.content.types;

import com.brand.blockus.Blockus;
import com.brand.blockus.blocks.base.StairsBase;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public enum LightBlockTypes {

    LAVA_BRICKS("lava_bricks", Blocks.STONE_BRICKS, 15),
    LAVA_POLISHED_BLACKSTONE_BRICKS("lava_polished_blackstone_bricks", Blocks.POLISHED_BLACKSTONE_BRICKS, 15),
    MAGMA_BRICKS("magma_bricks", Blocks.MAGMA_BLOCK, 15),
    SMALL_MAGMA_BRICKS("small_magma_bricks", Blocks.MAGMA_BLOCK, 15),
    BLAZE_BRICKS("blaze_bricks", Blocks.NETHER_BRICKS, 15);

    public final Block block;
    public final SlabBlock slab;
    public final StairsBase stairs;
    public final WallBlock wall;
    public final BlockItem item;
    public final BlockItem item_slab;
    public final BlockItem item_stairs;
    public final BlockItem item_wall;
    public final Block base;

    private LightBlockTypes(String type, Block base, int luminance) {
        String replace = type.replace("lava_polished_blackstone_bricks", "lava_polished_blackstone").replace("bricks", "brick");

        Identifier id = new Identifier(Blockus.MOD_ID, type);
        Identifier id_slab = new Identifier(Blockus.MOD_ID,replace + "_slab");
        Identifier id_stairs = new Identifier(Blockus.MOD_ID, replace + "_stairs");
        Identifier id_wall = new Identifier(Blockus.MOD_ID,replace + "_wall");
        this.base = base;

        Block.Settings blockSettings = FabricBlockSettings.copyOf(base).luminance(luminance);
        this.block = new Block(blockSettings);
        this.slab = new SlabBlock(blockSettings);
        this.stairs = new StairsBase(block.getDefaultState(), blockSettings);
        this.wall = new WallBlock(blockSettings);


        Item.Settings itemSettings = new Item.Settings().group(Blockus.BLOCKUS_BUILDING_BLOCKS);
        this.item = new BlockItem(this.block, itemSettings);
        this.item_slab = new BlockItem(this.slab, itemSettings);
        this.item_stairs = new BlockItem(this.stairs, itemSettings);
        Item.Settings wallitemSettings = new Item.Settings().group(Blockus.BLOCKUS_DECORATIONS);
        this.item_wall = new BlockItem(this.wall, wallitemSettings);

        Registry.register(Registry.BLOCK, id, this.block);
        Registry.register(Registry.BLOCK, id_slab, this.slab);
        Registry.register(Registry.BLOCK, id_stairs, this.stairs);
        Registry.register(Registry.BLOCK, id_wall, this.wall);
        Registry.register(Registry.ITEM, id, this.item);
        Registry.register(Registry.ITEM, id_slab, this.item_slab);
        Registry.register(Registry.ITEM, id_stairs, this.item_stairs);
        Registry.register(Registry.ITEM, id_wall, this.item_wall);

    }

    public static LightBlockTypes initialize() {
        return null;
    }
}
