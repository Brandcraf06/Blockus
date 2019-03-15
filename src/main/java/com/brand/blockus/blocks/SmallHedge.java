package com.brand.blockus.blocks;

import com.brand.blockus.Blockus;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.minecraft.block.BlockRenderLayer;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.block.WallBlock;
import net.minecraft.entity.VerticalEntityPosition;
import net.minecraft.item.Item;
import net.minecraft.item.block.BlockItem;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

public class SmallHedge extends WallBlock {
	
	private final VoxelShape[] UP_OUTLINE_SHAPES = this.createShapes(3.0F, 3.0F, 16.0F, 0.0F, 16.0F);
	private final VoxelShape[] UP_COLLISION_SHAPES = this.createShapes(3.0F, 3.0F, 16.0F, 0.0F, 16.0F);

	public SmallHedge(String name, float hardness, float resistance) {
		super(FabricBlockSettings.of(Material.LEAVES).sounds(BlockSoundGroup.GRASS).strength(hardness, resistance).build());
		Registry.register(Registry.BLOCK, new Identifier(Blockus.MOD_ID, name), this);
		Registry.register(Registry.ITEM,new Identifier(Blockus.MOD_ID, name), new BlockItem(this, new Item.Settings().stackSize(64).itemGroup(Blockus.BLOCKUS_DECORATIONS)));
	}

	public BlockRenderLayer getRenderLayer() {
	    return MinecraftClient.isFancyGraphicsEnabled() ? BlockRenderLayer.TRANSLUCENT : BlockRenderLayer.SOLID;
	}
	
	@Override
	public VoxelShape getOutlineShape(BlockState blockState_1, BlockView blockView_1, BlockPos blockPos_1, VerticalEntityPosition verticalEntityPosition_1) {
	      return this.UP_OUTLINE_SHAPES[this.getShapeIndex(blockState_1)] ;
	   }
	@Override
    public VoxelShape getCollisionShape(BlockState blockState_1, BlockView blockView_1, BlockPos blockPos_1, VerticalEntityPosition verticalEntityPosition_1) {
	      return this.UP_COLLISION_SHAPES[this.getShapeIndex(blockState_1)] ;
	}
}
