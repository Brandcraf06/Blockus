package com.brand.blockus.compatibility.content;

import com.brand.blockus.Blockus;
import com.brand.blockus.content.BlocksRegistration;
import com.brand.blockus.content.BlockusBlocks;
import com.hugman.promenade.init.AmaranthBundle;
import com.hugman.promenade.init.AutumnBundle;
import com.hugman.promenade.init.CherryBundle;
import com.hugman.promenade.init.PalmBundle;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.block.Block;
import net.minecraft.client.color.world.BiomeColors;
import net.minecraft.client.color.world.FoliageColors;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.registry.Registry;

public class BlockusPromenadeItems {

    public static Item CHERRY_OAK_SMALL_LOGS;
    public static Item PALM_SMALL_LOGS;
    public static Item DARK_AMARANTH_SMALL_STEMS;

    public static void init() {
        CHERRY_OAK_SMALL_LOGS = register(BlockusPromenadeBlocks.CHERRY_OAK_SMALL_LOGS, Blockus.BLOCKUS_BUILDING_BLOCKS);
        PALM_SMALL_LOGS = register(BlockusPromenadeBlocks.PALM_SMALL_LOGS, Blockus.BLOCKUS_BUILDING_BLOCKS);
        DARK_AMARANTH_SMALL_STEMS = register(BlockusPromenadeBlocks.DARK_AMARANTH_SMALL_STEMS, Blockus.BLOCKUS_BUILDING_BLOCKS);
    }
    public static Item register(Block block, ItemGroup group) {
        return Registry.register(Registry.ITEM, Registry.BLOCK.getId(block), new BlockItem(block, new Item.Settings().maxCount(64).group(group)));
    }
}
