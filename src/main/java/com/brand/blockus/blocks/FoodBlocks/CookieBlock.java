package com.brand.blockus.blocks.FoodBlocks;

import com.brand.blockus.BlockusProperties;

import net.minecraft.block.Block;
import net.minecraft.block.BlockPlacementEnvironment;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.stat.Stats;
import net.minecraft.state.StateFactory;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.IWorld;
import net.minecraft.world.ViewableWorld;
import net.minecraft.world.World;

public class CookieBlock extends Block {
	   public static final IntProperty BITES;
	   protected static final VoxelShape[] BITES_TO_SHAPE;

	   protected CookieBlock(Block.Settings block$Settings_1) {
	      super(block$Settings_1);
	      this.setDefaultState((BlockState)((BlockState)this.stateFactory.getDefaultState()).with(BITES, 0));
	   }

	   public VoxelShape getOutlineShape(BlockState blockState_1, BlockView blockView_1, BlockPos blockPos_1, EntityContext entityContext_1) {
	      return BITES_TO_SHAPE[(Integer)blockState_1.get(BITES)];
	   }

	   public boolean activate(BlockState blockState_1, World world_1, BlockPos blockPos_1, PlayerEntity playerEntity_1, Hand hand_1, BlockHitResult blockHitResult_1) {
	      if (!world_1.isClient) {
	         return this.tryEat(world_1, blockPos_1, blockState_1, playerEntity_1);
	      } else {
	         ItemStack itemStack_1 = playerEntity_1.getStackInHand(hand_1);
	         return this.tryEat(world_1, blockPos_1, blockState_1, playerEntity_1) || itemStack_1.isEmpty();
	      }
	   }

	   private boolean tryEat(IWorld iWorld_1, BlockPos blockPos_1, BlockState blockState_1, PlayerEntity playerEntity_1) {
	      if (!playerEntity_1.canConsume(false)) {
	         return false;
	      } else {
	         playerEntity_1.incrementStat(Stats.EAT_CAKE_SLICE);
	         playerEntity_1.getHungerManager().add(2, 0.1F);
	         int int_1 =  (Integer)blockState_1.get(BITES);
	         if (int_1 < 8) {
	            iWorld_1.setBlockState(blockPos_1, (BlockState)blockState_1.with(BITES, int_1 + 1), 3);
	         } else {
	            iWorld_1.clearBlockState(blockPos_1, false);
	         }

	         return true;
	      }
	   }

	   public BlockState getStateForNeighborUpdate(BlockState blockState_1, Direction direction_1, BlockState blockState_2, IWorld iWorld_1, BlockPos blockPos_1, BlockPos blockPos_2) {
	      return direction_1 == Direction.DOWN && !blockState_1.canPlaceAt(iWorld_1, blockPos_1) ? Blocks.AIR.getDefaultState() : super.getStateForNeighborUpdate(blockState_1, direction_1, blockState_2, iWorld_1, blockPos_1, blockPos_2);
	   }

	   public boolean canPlaceAt(BlockState blockState_1, ViewableWorld viewableWorld_1, BlockPos blockPos_1) {
	      return viewableWorld_1.getBlockState(blockPos_1.down()).getMaterial().isSolid();
	   }

	   protected void appendProperties(StateFactory.Builder<Block, BlockState> stateFactory$Builder_1) {
	      stateFactory$Builder_1.add(BITES);
	   }

	   public int getComparatorOutput(BlockState blockState_1, World world_1, BlockPos blockPos_1) {
	      return (9 - (Integer)blockState_1.get(BITES)) * 2;
	   }

	   public boolean hasComparatorOutput(BlockState blockState_1) {
	      return true;
	   }

	   public boolean canPlaceAtSide(BlockState blockState_1, BlockView blockView_1, BlockPos blockPos_1, BlockPlacementEnvironment blockPlacementEnvironment_1) {
	      return false;
	   }

	   static {
	      BITES = BlockusProperties.BITES_9;
	      BITES_TO_SHAPE = new VoxelShape[]
	    		  {Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D), 
	    		   Block.createCuboidShape(2.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D), 
	    		   Block.createCuboidShape(4.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D), 
	    		   Block.createCuboidShape(6.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D),
	    		   Block.createCuboidShape(7.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D),
	    		   Block.createCuboidShape(8.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D), 
	    		   Block.createCuboidShape(10.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D), 
	    		   Block.createCuboidShape(12.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D), 
	    		   Block.createCuboidShape(14.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D)};
	   }
	}
