package com.brand.blockus.blocks.Leaves;

import net.minecraft.block.Block;
import net.minecraft.block.BlockPlacementEnvironment;
import net.minecraft.block.BlockState;
import net.minecraft.block.FenceGateBlock;
import net.minecraft.block.HorizontalConnectingBlock;
import net.minecraft.entity.EntityContext;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.tag.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.IWorld;
import net.minecraft.world.WorldView;

public class HedgeBlock extends HorizontalConnectingBlock {
	   public static final BooleanProperty UP;
	   private final VoxelShape[] UP_OUTLINE_SHAPES;
	   private final VoxelShape[] UP_COLLISION_SHAPES;

	   public HedgeBlock(Block.Settings block$Settings_1) {
	      super(0.0F, 3.0F, 0.0F, 16.0F, 24.0F, block$Settings_1);
	      this.setDefaultState((BlockState)((BlockState)((BlockState)((BlockState)((BlockState)((BlockState)((BlockState)this.stateManager.getDefaultState()).with(UP, true)).with(NORTH, false)).with(EAST, false)).with(SOUTH, false)).with(WEST, false)).with(WATERLOGGED, false));
	      this.UP_OUTLINE_SHAPES = this.createShapes(3.0F, 3.0F, 16.0F, 0.0F, 16.0F);
	      this.UP_COLLISION_SHAPES = this.createShapes(3.0F, 3.0F, 24.0F, 0.0F, 24.0F);
	   }

	   public VoxelShape getOutlineShape(BlockState blockState_1, BlockView blockView_1, BlockPos blockPos_1, EntityContext entityContext_1) {
	      return (Boolean)blockState_1.get(UP) ? this.UP_OUTLINE_SHAPES[this.getShapeIndex(blockState_1)] : super.getOutlineShape(blockState_1, blockView_1, blockPos_1, entityContext_1);
	   }

	   public VoxelShape getCollisionShape(BlockState blockState_1, BlockView blockView_1, BlockPos blockPos_1, EntityContext entityContext_1) {
	      return (Boolean)blockState_1.get(UP) ? this.UP_COLLISION_SHAPES[this.getShapeIndex(blockState_1)] : super.getCollisionShape(blockState_1, blockView_1, blockPos_1, entityContext_1);
	   }

	   public boolean canPlaceAtSide(BlockState blockState_1, BlockView blockView_1, BlockPos blockPos_1, BlockPlacementEnvironment blockPlacementEnvironment_1) {
	      return false;
	   }

	   private boolean shouldConnectTo(BlockState blockState_1, boolean boolean_1, Direction direction_1) {
	      Block block_1 = blockState_1.getBlock();
	      boolean boolean_2 = block_1.matches(BlockTags.WALLS) || block_1 instanceof FenceGateBlock && FenceGateBlock.canWallConnect(blockState_1, direction_1);
	      return !cannotConnect(block_1) && boolean_1 || boolean_2;
	   }

	   public BlockState getPlacementState(ItemPlacementContext itemPlacementContext_1) {
		  WorldView viewableWorld_1 = itemPlacementContext_1.getWorld();
	      BlockPos blockPos_1 = itemPlacementContext_1.getBlockPos();
	      FluidState fluidState_1 = itemPlacementContext_1.getWorld().getFluidState(itemPlacementContext_1.getBlockPos());
	      BlockPos blockPos_2 = blockPos_1.north();
	      BlockPos blockPos_3 = blockPos_1.east();
	      BlockPos blockPos_4 = blockPos_1.south();
	      BlockPos blockPos_5 = blockPos_1.west();
	      BlockState blockState_1 = viewableWorld_1.getBlockState(blockPos_2);
	      BlockState blockState_2 = viewableWorld_1.getBlockState(blockPos_3);
	      BlockState blockState_3 = viewableWorld_1.getBlockState(blockPos_4);
	      BlockState blockState_4 = viewableWorld_1.getBlockState(blockPos_5);
	      boolean boolean_1 = this.shouldConnectTo(blockState_1, blockState_1.isSideSolidFullSquare(viewableWorld_1, blockPos_2, Direction.SOUTH), Direction.SOUTH);
	      boolean boolean_2 = this.shouldConnectTo(blockState_2, blockState_2.isSideSolidFullSquare(viewableWorld_1, blockPos_3, Direction.WEST), Direction.WEST);
	      boolean boolean_3 = this.shouldConnectTo(blockState_3, blockState_3.isSideSolidFullSquare(viewableWorld_1, blockPos_4, Direction.NORTH), Direction.NORTH);
	      boolean boolean_4 = this.shouldConnectTo(blockState_4, blockState_4.isSideSolidFullSquare(viewableWorld_1, blockPos_5, Direction.EAST), Direction.EAST);
	      boolean boolean_5 = (!boolean_1 || boolean_2 || !boolean_3 || boolean_4) && (boolean_1 || !boolean_2 || boolean_3 || !boolean_4);
	      return (BlockState)((BlockState)((BlockState)((BlockState)((BlockState)((BlockState)this.getDefaultState().with(UP, boolean_5 || !viewableWorld_1.isAir(blockPos_1.up()))).with(NORTH, boolean_1)).with(EAST, boolean_2)).with(SOUTH, boolean_3)).with(WEST, boolean_4)).with(WATERLOGGED, fluidState_1.getFluid() == Fluids.WATER);
	   }

	   public BlockState getStateForNeighborUpdate(BlockState blockState_1, Direction direction_1, BlockState blockState_2, IWorld iWorld_1, BlockPos blockPos_1, BlockPos blockPos_2) {
	      if ((Boolean)blockState_1.get(WATERLOGGED)) {
	         iWorld_1.getFluidTickScheduler().schedule(blockPos_1, Fluids.WATER, Fluids.WATER.getTickRate(iWorld_1));
	      }

	      if (direction_1 == Direction.DOWN) {
	         return super.getStateForNeighborUpdate(blockState_1, direction_1, blockState_2, iWorld_1, blockPos_1, blockPos_2);
	      } else {
	         Direction direction_2 = direction_1.getOpposite();
	         boolean boolean_1 = direction_1 == Direction.NORTH ? this.shouldConnectTo(blockState_2, blockState_2.isSideSolidFullSquare(iWorld_1, blockPos_2, direction_2), direction_2) : (Boolean)blockState_1.get(NORTH);
	         boolean boolean_2 = direction_1 == Direction.EAST ? this.shouldConnectTo(blockState_2, blockState_2.isSideSolidFullSquare(iWorld_1, blockPos_2, direction_2), direction_2) : (Boolean)blockState_1.get(EAST);
	         boolean boolean_3 = direction_1 == Direction.SOUTH ? this.shouldConnectTo(blockState_2, blockState_2.isSideSolidFullSquare(iWorld_1, blockPos_2, direction_2), direction_2) : (Boolean)blockState_1.get(SOUTH);
	         boolean boolean_4 = direction_1 == Direction.WEST ? this.shouldConnectTo(blockState_2, blockState_2.isSideSolidFullSquare(iWorld_1, blockPos_2, direction_2), direction_2) : (Boolean)blockState_1.get(WEST);
	         boolean boolean_5 = (!boolean_1 || boolean_2 || !boolean_3 || boolean_4) && (boolean_1 || !boolean_2 || boolean_3 || !boolean_4);
	         return (BlockState)((BlockState)((BlockState)((BlockState)((BlockState)blockState_1.with(UP, boolean_5 || !iWorld_1.isAir(blockPos_1.up()))).with(NORTH, boolean_1)).with(EAST, boolean_2)).with(SOUTH, boolean_3)).with(WEST, boolean_4);
	      }
	   }

	   protected void appendProperties(StateManager.Builder<Block, BlockState> stateFactory$Builder_1) {
	      stateFactory$Builder_1.add(UP, NORTH, EAST, WEST, SOUTH, WATERLOGGED);
	   }

	   static {
	      UP = Properties.UP;
	   }
	}
