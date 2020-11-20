package com.brand.blockus.blocks.Paper;


import com.brand.blockus.Blockus;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

public class PaperLight extends Block {
    public static final VoxelShape LAMP = Block.createCuboidShape(3.0D, 0.0D, 3.0D, 13.0D, 16.0D, 13.0D);


    public PaperLight(String name, float hardness, float resistance) {
        super(FabricBlockSettings.of(Material.WOOL, MaterialColor.QUARTZ).sounds(BlockSoundGroup.GRASS).luminance(15).strength(hardness, resistance));
        Registry.register(Registry.BLOCK, new Identifier(Blockus.MOD_ID, name), this);
        Registry.register(Registry.ITEM, new Identifier(Blockus.MOD_ID, name), new BlockItem(this, new Item.Settings().maxCount(64).group(Blockus.BLOCKUS_BUILDING_BLOCKS)));
    }

    @Override
    public VoxelShape getCollisionShape(BlockState blockState_1, BlockView blockView_1, BlockPos blockPos_1, ShapeContext entityContext_1) {
        return LAMP;
    }

    @Override
    public VoxelShape getOutlineShape(BlockState blockState_1, BlockView blockView_1, BlockPos blockPos_1, ShapeContext entityContext_1) {
        return LAMP;
    }

}