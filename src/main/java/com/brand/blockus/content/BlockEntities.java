package com.brand.blockus.content;

import com.brand.blockus.Blockus;
import com.brand.blockus.blocks.blockentity.WoodenBarrelBlockEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class BlockEntities {

    public static final BlockEntityType<WoodenBarrelBlockEntity> WOODEN_BARREL = registerBe("wooden_barrel", FabricBlockEntityTypeBuilder.create(WoodenBarrelBlockEntity::new, BlockusBlocks.OAK_BARREL, BlockusBlocks.BIRCH_BARREL, BlockusBlocks.JUNGLE_BARREL, BlockusBlocks.ACACIA_BARREL, BlockusBlocks.CRIMSON_BARREL, BlockusBlocks.WARPED_BARREL, BlockusBlocks.DARK_OAK_BARREL, BlockusBlocks.WHITE_OAK_BARREL, BlockusBlocks.BAMBOO_BARREL, BlockusBlocks.CHARRED_BARREL));

    private static <T extends BlockEntity> BlockEntityType<T> registerBe(String id, FabricBlockEntityTypeBuilder<T> builder) {
        return Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(Blockus.MOD_ID, id), builder.build(null));
    }
}
