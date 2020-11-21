package com.brand.blockus.blocks.FoodBlocks;

import com.brand.blockus.Blockus;
import com.brand.blockus.BlockusProperties;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;

public class CookieBlock extends Block {
    public static final IntProperty BITES;
    protected static final VoxelShape[] BITES_TO_SHAPE;

    public CookieBlock(String name, float hardness, float resistance, MaterialColor color) {
        super(FabricBlockSettings.of(Material.SOLID_ORGANIC, color).sounds(BlockSoundGroup.GRASS).strength(hardness, resistance));
        Registry.register(Registry.BLOCK, new Identifier(Blockus.MOD_ID, name), this);
        Registry.register(Registry.ITEM, new Identifier(Blockus.MOD_ID, name), new BlockItem(this, new Item.Settings().maxCount(64).group(Blockus.BLOCKUS_BUILDING_BLOCKS)));
        this.setDefaultState(this.stateManager.getDefaultState().with(BITES, 0));
    }

    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return BITES_TO_SHAPE[state.get(BITES)];
    }

    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (world.isClient) {
            ItemStack itemStack = player.getStackInHand(hand);
            if (this.tryEat(world, pos, state, player).isAccepted()) {
                return ActionResult.SUCCESS;
            }

            if (itemStack.isEmpty()) {
                return ActionResult.CONSUME;
            }
        }

        return this.tryEat(world, pos, state, player);
    }

    private ActionResult tryEat(WorldAccess world, BlockPos pos, BlockState state, PlayerEntity player) {
        if (!player.canConsume(false)) {
            return ActionResult.PASS;
        } else {
            player.getHungerManager().add(2, 0.1F);
            int i = state.get(BITES);
            if (i < 8) {
                world.setBlockState(pos, state.with(BITES, i + 1), 3);
            } else {
                world.removeBlock(pos, false);
            }

            return ActionResult.SUCCESS;
        }
    }

    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState newState, WorldAccess world, BlockPos pos, BlockPos posFrom) {
        return direction == Direction.DOWN && !state.canPlaceAt(world, pos) ? Blocks.AIR.getDefaultState() : super.getStateForNeighborUpdate(state, direction, newState, world, pos, posFrom);
    }

    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        return world.getBlockState(pos.down()).getMaterial().isSolid();
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(BITES);
    }

    public int getComparatorOutput(BlockState state, World world, BlockPos pos) {
        return (9 - state.get(BITES)) * 2;
    }

    public boolean hasComparatorOutput(BlockState blockState_1) {
        return true;
    }

    public boolean canPathfindThrough(BlockState state, BlockView world, BlockPos pos, NavigationType type) {
        return false;
    }

    static {
        BITES = BlockusProperties.BITES_9;
        BITES_TO_SHAPE = new VoxelShape[]
                {
                        Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D),
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
