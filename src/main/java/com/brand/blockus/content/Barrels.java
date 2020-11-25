package com.brand.blockus.content;

import com.brand.blockus.Blockus;
import com.brand.blockus.blocks.base.BarrelBlockBase;
import com.brand.blockus.blocks.blockentity.WoodenBarrelBlockEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Barrels {

    public static final BarrelBlockBase OAK_BARREL = new BarrelBlockBase("oak_barrel", 2.0f, 3.0f, Blocks.OAK_PLANKS.getDefaultMapColor());
    public static final BarrelBlockBase BIRCH_BARREL = new BarrelBlockBase("birch_barrel", 2.0f, 3.0f, Blocks.BIRCH_PLANKS.getDefaultMapColor());
    public static final BarrelBlockBase JUNGLE_BARREL = new BarrelBlockBase("jungle_barrel", 2.0f, 3.0f, Blocks.JUNGLE_PLANKS.getDefaultMapColor());
    public static final BarrelBlockBase ACACIA_BARREL = new BarrelBlockBase("acacia_barrel", 2.0f, 3.0f, Blocks.ACACIA_PLANKS.getDefaultMapColor());
    public static final BarrelBlockBase DARK_OAK_BARREL = new BarrelBlockBase("dark_oak_barrel", 2.0f, 3.0f, Blocks.DARK_OAK_PLANKS.getDefaultMapColor());
    public static final BarrelBlockBase CRIMSON_BARREL = new BarrelBlockBase("crimson_barrel", 2.0f, 3.0f, Blocks.CRIMSON_PLANKS.getDefaultMapColor());
    public static final BarrelBlockBase WARPED_BARREL = new BarrelBlockBase("warped_barrel", 2.0f, 3.0f, Blocks.WARPED_PLANKS.getDefaultMapColor());
    public static final BarrelBlockBase WHITE_OAK_BARREL = new BarrelBlockBase("white_oak_barrel", 2.0f, 3.0f, BlockusBlocks.WHITE_OAK_PLANKS.getDefaultMapColor());
    public static final BarrelBlockBase BAMBOO_BARREL = new BarrelBlockBase("bamboo_barrel", 2.0f, 3.0f, BlockusBlocks.BAMBOO_PLANKS.getDefaultMapColor());
    public static final BarrelBlockBase CHARRED_BARREL = new BarrelBlockBase("charred_barrel", 2.0f, 3.0f, BlockusBlocks.CHARRED_PLANKS.getDefaultMapColor());

    public static final BlockEntityType<WoodenBarrelBlockEntity> WOODEN_BARREL = registerBe("wooden_barrel", FabricBlockEntityTypeBuilder.create(WoodenBarrelBlockEntity::new, OAK_BARREL, BIRCH_BARREL, JUNGLE_BARREL, ACACIA_BARREL, CRIMSON_BARREL, WARPED_BARREL, DARK_OAK_BARREL, WHITE_OAK_BARREL, BAMBOO_BARREL, CHARRED_BARREL));

    private static <T extends BlockEntity> BlockEntityType<T> registerBe(String name, FabricBlockEntityTypeBuilder<T> builder) {
        return Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(Blockus.MOD_ID, name), builder.build(null));
    }

}
