package com.brand.blockus.compatibility.content;

import com.brand.blockus.Blockus;
import com.brand.blockus.content.BlocksRegistration;
import fr.hugman.dawn.Registrar;
import fr.hugman.promenade.PromenadeFactory;
import fr.hugman.promenade.registry.content.AmaranthContent;
import fr.hugman.promenade.registry.content.MapleContent;
import fr.hugman.promenade.registry.content.PalmContent;
import fr.hugman.promenade.registry.content.SakuraContent;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.PillarBlock;
import net.minecraft.client.color.world.BiomeColors;
import net.minecraft.client.color.world.FoliageColors;
import net.minecraft.client.color.world.GrassColors;
import net.minecraft.client.render.RenderLayer;

public class BlockusPromenadeBlocks extends BlocksRegistration {
    public static Block POTTED_SAP_MAPLE;
    public static Block POTTED_VERMILION_MAPLE;
    public static Block POTTED_FULVOUS_MAPLE;
    public static Block POTTED_MIKADO_MAPLE;
    public static Block POTTED_BLUSH_SAKURA;
    public static Block POTTED_COTTON_SAKURA;
    public static Block POTTED_PALM;
    public static Block POTTED_DARK_AMARANTH;
    public static Block MAPLE_SMALL_LOGS;
    public static Block SAKURA_SMALL_LOGS;
    public static Block PALM_SMALL_LOGS;
    public static Block DARK_AMARANTH_SMALL_STEMS;
    public static Block SAP_MAPLE_SMALL_HEDGE;
    public static Block VERMILION_MAPLE_SMALL_HEDGE;
    public static Block FULVOUS_MAPLE_SMALL_HEDGE;
    public static Block MIKADO_MAPLE_SMALL_HEDGE;
    public static Block BLUSH_SAKURA_SMALL_HEDGE;
    public static Block COTTON_SAKURA_SMALL_HEDGE;
    public static Block PALM_SMALL_HEDGE;
    public static Block DARK_AMARANTH_SMALL_HEDGE;
    public static Block WHITE_OAK_LEAF_PILE = PromenadeFactory.leafPile();
    public static Block BLUEBERRIES_CRATE;

    public static void init() {

        // Large Flower Pots

        POTTED_SAP_MAPLE = registerNoItem("potted_sap_maple", createPottedDoublePlant(MapleContent.SAP_MAPLE_SAPLING));
        POTTED_VERMILION_MAPLE = registerNoItem("potted_vermilion_maple", createPottedDoublePlant(MapleContent.VERMILION_MAPLE_SAPLING));
        POTTED_FULVOUS_MAPLE = registerNoItem("potted_fulvous_maple", createPottedDoublePlant(MapleContent.FULVOUS_MAPLE_SAPLING));
        POTTED_MIKADO_MAPLE = registerNoItem("potted_mikado_maple", createPottedDoublePlant(MapleContent.MIKADO_MAPLE_SAPLING));

        POTTED_BLUSH_SAKURA = registerNoItem("potted_blush_sakura", createPottedDoublePlant(SakuraContent.BLUSH_SAKURA_SAPLING));
        POTTED_COTTON_SAKURA = registerNoItem("potted_cotton_sakura", createPottedDoublePlant(SakuraContent.COTTON_SAKURA_SAPLING));
        POTTED_PALM = registerNoItem("potted_palm", createPottedDoublePlant(PalmContent.PALM_SAPLING));

        POTTED_DARK_AMARANTH = registerNoItem("potted_huge_dark_amaranth_fungus", createPottedDoublePlant(AmaranthContent.DARK_AMARANTH_FUNGUS));

        // Small Logs
        MAPLE_SMALL_LOGS = register("maple_small_logs", new PillarBlock(FabricBlockSettings.copy(MapleContent.MAPLE_LOG)));
        FlammableBlockRegistry.getDefaultInstance().add(BlockusPromenadeBlocks.MAPLE_SMALL_LOGS, 5, 5);

        SAKURA_SMALL_LOGS = register("sakura_small_logs", new PillarBlock(FabricBlockSettings.copy(SakuraContent.SAKURA_LOG)));
        FlammableBlockRegistry.getDefaultInstance().add(BlockusPromenadeBlocks.SAKURA_SMALL_LOGS, 5, 5);

        PALM_SMALL_LOGS = register("palm_small_logs", new PillarBlock(FabricBlockSettings.copy(PalmContent.PALM_LOG)));
        FlammableBlockRegistry.getDefaultInstance().add(BlockusPromenadeBlocks.PALM_SMALL_LOGS, 5, 5);

        DARK_AMARANTH_SMALL_STEMS = register("dark_amaranth_small_stems", new PillarBlock(FabricBlockSettings.copy(AmaranthContent.DARK_AMARANTH_STEM)));

        // Small Hedges
        SAP_MAPLE_SMALL_HEDGE = registerSmallHedge("sap_maple_small_hedge", MapleContent.SAP_MAPLE_LEAVES);
        FlammableBlockRegistry.getDefaultInstance().add(BlockusPromenadeBlocks.SAP_MAPLE_SMALL_HEDGE, 30, 60);

        VERMILION_MAPLE_SMALL_HEDGE = registerSmallHedge("vermilion_maple_small_hedge", MapleContent.VERMILION_MAPLE_LEAVES);
        FlammableBlockRegistry.getDefaultInstance().add(BlockusPromenadeBlocks.VERMILION_MAPLE_SMALL_HEDGE, 30, 60);

        FULVOUS_MAPLE_SMALL_HEDGE = registerSmallHedge("fulvous_maple_small_hedge", MapleContent.FULVOUS_MAPLE_LEAVES);
        FlammableBlockRegistry.getDefaultInstance().add(BlockusPromenadeBlocks.FULVOUS_MAPLE_SMALL_HEDGE, 30, 60);

        MIKADO_MAPLE_SMALL_HEDGE = registerSmallHedge("mikado_maple_small_hedge", MapleContent.MIKADO_MAPLE_LEAVES);
        FlammableBlockRegistry.getDefaultInstance().add(BlockusPromenadeBlocks.MIKADO_MAPLE_SMALL_HEDGE, 30, 60);

        BLUSH_SAKURA_SMALL_HEDGE = registerSmallHedge("blush_sakura_small_hedge", SakuraContent.BLUSH_SAKURA_BLOSSOMS);
        FlammableBlockRegistry.getDefaultInstance().add(BlockusPromenadeBlocks.BLUSH_SAKURA_SMALL_HEDGE, 30, 60);

        COTTON_SAKURA_SMALL_HEDGE = registerSmallHedge("cotton_sakura_small_hedge", SakuraContent.COTTON_SAKURA_BLOSSOMS);
        FlammableBlockRegistry.getDefaultInstance().add(BlockusPromenadeBlocks.COTTON_SAKURA_SMALL_HEDGE, 30, 60);

        PALM_SMALL_HEDGE = registerSmallHedge("palm_small_hedge", PalmContent.PALM_LEAVES);
        FlammableBlockRegistry.getDefaultInstance().add(BlockusPromenadeBlocks.PALM_SMALL_HEDGE, 30, 60);

        DARK_AMARANTH_SMALL_HEDGE = registerSmallHedge("dark_amaranth_small_hedge", AmaranthContent.DARK_AMARANTH_WART_BLOCK);

        // Leaf Piles
        Registrar.add(Blockus.id("white_oak_leaf_pile"), WHITE_OAK_LEAF_PILE);

        // Crates
        BLUEBERRIES_CRATE = register("blueberries_crate", createCrates());

    }

    @Environment(EnvType.CLIENT)
    public static void initClient() {
        registerBlockColors();
        registerItemColors();

        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutoutMipped(),
            POTTED_SAP_MAPLE,
            POTTED_VERMILION_MAPLE,
            POTTED_FULVOUS_MAPLE,
            POTTED_MIKADO_MAPLE,
            POTTED_BLUSH_SAKURA,
            POTTED_COTTON_SAKURA,
            POTTED_PALM,
            SAP_MAPLE_SMALL_HEDGE,
            VERMILION_MAPLE_SMALL_HEDGE,
            FULVOUS_MAPLE_SMALL_HEDGE,
            MIKADO_MAPLE_SMALL_HEDGE,
            BLUSH_SAKURA_SMALL_HEDGE,
            COTTON_SAKURA_SMALL_HEDGE,
            PALM_SMALL_HEDGE,
            WHITE_OAK_LEAF_PILE
        );
    }

    private static void registerBlockColors() {
        ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) -> {
            return pos != null && world != null ? BiomeColors.getFoliageColor(world, pos) : FoliageColors.getDefaultColor();
        }, PALM_SMALL_HEDGE, POTTED_PALM, SAP_MAPLE_SMALL_HEDGE, POTTED_SAP_MAPLE);
    }

    private static void registerItemColors() {
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> {
            return GrassColors.getColor(1.0D, 0.0D);
        }, PALM_SMALL_HEDGE, POTTED_PALM);
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> {
            return 10931465;
        }, SAP_MAPLE_SMALL_HEDGE, POTTED_SAP_MAPLE);
    }
}
