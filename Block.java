package net.minecraft.block;

import it.unimi.dsi.fastutil.objects.Object2ByteLinkedOpenHashMap;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.stream.Stream;
import javax.annotation.Nullable;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.client.item.TooltipOptions;
import net.minecraft.container.NameableContainerProvider;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ExperienceOrbEntity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.VerticalEntityPosition;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemProvider;
import net.minecraft.item.ItemStack;
import net.minecraft.item.block.BlockItem;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.stat.Stats;
import net.minecraft.state.StateFactory;
import net.minecraft.tag.BlockTags;
import net.minecraft.tag.FluidTags;
import net.minecraft.tag.Tag;
import net.minecraft.text.TextComponent;
import net.minecraft.text.TranslatableTextComponent;
import net.minecraft.util.BooleanBiFunction;
import net.minecraft.util.DefaultedList;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Hand;
import net.minecraft.util.IdList;
import net.minecraft.util.Identifier;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.SystemUtil;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.ExtendedBlockView;
import net.minecraft.world.IWorld;
import net.minecraft.world.ViewableWorld;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;
import net.minecraft.world.loot.LootSupplier;
import net.minecraft.world.loot.LootTables;
import net.minecraft.world.loot.context.LootContext;
import net.minecraft.world.loot.context.LootContextTypes;
import net.minecraft.world.loot.context.Parameters;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Block implements ItemProvider {
   protected static final Logger LOGGER = LogManager.getLogger();
   public static final IdList<BlockState> STATE_IDS = new IdList();
   private static final Direction[] FACINGS;
   protected final int lightLevel;
   protected final float hardness;
   protected final float resistance;
   protected final boolean randomTicks;
   protected final BlockSoundGroup soundGroup;
   protected final Material material;
   protected final MaterialColor materialColor;
   private final float friction;
   protected final StateFactory<Block, BlockState> stateFactory;
   private BlockState defaultState;
   protected final boolean collidable;
   private final boolean dynamicBounds;
   @Nullable
   private Identifier dropTableId;
   @Nullable
   private String translationKey;
   @Nullable
   private Item cachedItem;
   private static final ThreadLocal<Object2ByteLinkedOpenHashMap<Block.NeighborGroup>> FACE_CULL_MAP;

   public static int getRawIdFromState(@Nullable BlockState blockState_1) {
      if (blockState_1 == null) {
         return 0;
      } else {
         int int_1 = STATE_IDS.getId(blockState_1);
         return int_1 == -1 ? 0 : int_1;
      }
   }

   public static BlockState getStateFromRawId(int int_1) {
      BlockState blockState_1 = (BlockState)STATE_IDS.getInt(int_1);
      return blockState_1 == null ? Blocks.AIR.getDefaultState() : blockState_1;
   }

   public static Block getBlockFromItem(@Nullable Item item_1) {
      return item_1 instanceof BlockItem ? ((BlockItem)item_1).getBlock() : Blocks.AIR;
   }

   public static BlockState pushEntitiesUpBeforeBlockChange(BlockState blockState_1, BlockState blockState_2, World world_1, BlockPos blockPos_1) {
      VoxelShape voxelShape_1 = VoxelShapes.combine(blockState_1.getCollisionShape(world_1, blockPos_1), blockState_2.getCollisionShape(world_1, blockPos_1), BooleanBiFunction.ONLY_SECOND).offset((double)blockPos_1.getX(), (double)blockPos_1.getY(), (double)blockPos_1.getZ());
      List<Entity> list_1 = world_1.getVisibleEntities((Entity)null, voxelShape_1.getBoundingBox());
      Iterator var6 = list_1.iterator();

      while(var6.hasNext()) {
         Entity entity_1 = (Entity)var6.next();
         double double_1 = VoxelShapes.calculateMaxOffset(Direction.Axis.Y, entity_1.getBoundingBox().offset(0.0D, 1.0D, 0.0D), Stream.of(voxelShape_1), -1.0D);
         entity_1.method_5859(entity_1.x, entity_1.y + 1.0D + double_1, entity_1.z);
      }

      return blockState_2;
   }

   public static VoxelShape createCuboidShape(double double_1, double double_2, double double_3, double double_4, double double_5, double double_6) {
      return VoxelShapes.cube(double_1 / 16.0D, double_2 / 16.0D, double_3 / 16.0D, double_4 / 16.0D, double_5 / 16.0D, double_6 / 16.0D);
   }

   @Deprecated
   public boolean allowsSpawning(BlockState blockState_1, Entity entity_1) {
      return true;
   }

   @Deprecated
   public boolean isAir(BlockState blockState_1) {
      return false;
   }

   @Deprecated
   public int getLuminance(BlockState blockState_1) {
      return this.lightLevel;
   }

   @Deprecated
   public Material getMaterial(BlockState blockState_1) {
      return this.material;
   }

   @Deprecated
   public MaterialColor getMapColor(BlockState blockState_1, BlockView blockView_1, BlockPos blockPos_1) {
      return this.materialColor;
   }

   @Deprecated
   public void updateNeighborStates(BlockState blockState_1, IWorld iWorld_1, BlockPos blockPos_1, int int_1) {
      BlockPos.PooledMutable blockPos$PooledMutable_1 = BlockPos.PooledMutable.get();
      Throwable var6 = null;

      try {
         Direction[] var7 = FACINGS;
         int var8 = var7.length;

         for(int var9 = 0; var9 < var8; ++var9) {
            Direction direction_1 = var7[var9];
            blockPos$PooledMutable_1.set((Vec3i)blockPos_1).setOffset(direction_1);
            BlockState blockState_2 = iWorld_1.getBlockState(blockPos$PooledMutable_1);
            BlockState blockState_3 = blockState_2.getStateForNeighborUpdate(direction_1.getOpposite(), blockState_1, iWorld_1, blockPos$PooledMutable_1, blockPos_1);
            replaceBlock(blockState_2, blockState_3, iWorld_1, blockPos$PooledMutable_1, int_1);
         }
      } catch (Throwable var20) {
         var6 = var20;
         throw var20;
      } finally {
         if (blockPos$PooledMutable_1 != null) {
            if (var6 != null) {
               try {
                  blockPos$PooledMutable_1.close();
               } catch (Throwable var19) {
                  var6.addSuppressed(var19);
               }
            } else {
               blockPos$PooledMutable_1.close();
            }
         }

      }

   }

   public boolean matches(Tag<Block> tag_1) {
      return tag_1.contains(this);
   }

   public static BlockState getRenderingState(BlockState blockState_1, IWorld iWorld_1, BlockPos blockPos_1) {
      BlockState blockState_2 = blockState_1;
      BlockPos.Mutable blockPos$Mutable_1 = new BlockPos.Mutable();
      Direction[] var5 = FACINGS;
      int var6 = var5.length;

      for(int var7 = 0; var7 < var6; ++var7) {
         Direction direction_1 = var5[var7];
         blockPos$Mutable_1.set((Vec3i)blockPos_1).setOffset(direction_1);
         blockState_2 = blockState_2.getStateForNeighborUpdate(direction_1, iWorld_1.getBlockState(blockPos$Mutable_1), iWorld_1, blockPos_1, blockPos$Mutable_1);
      }

      return blockState_2;
   }

   public static void replaceBlock(BlockState blockState_1, BlockState blockState_2, IWorld iWorld_1, BlockPos blockPos_1, int int_1) {
      if (blockState_2 != blockState_1) {
         if (blockState_2.isAir()) {
            if (!iWorld_1.isClient()) {
               iWorld_1.breakBlock(blockPos_1, (int_1 & 32) == 0);
            }
         } else {
            iWorld_1.setBlockState(blockPos_1, blockState_2, int_1 & -33);
         }
      }

   }

   @Deprecated
   public void method_9517(BlockState blockState_1, IWorld iWorld_1, BlockPos blockPos_1, int int_1) {
   }

   @Deprecated
   public BlockState getStateForNeighborUpdate(BlockState blockState_1, Direction direction_1, BlockState blockState_2, IWorld iWorld_1, BlockPos blockPos_1, BlockPos blockPos_2) {
      return blockState_1;
   }

   @Deprecated
   public BlockState rotate(BlockState blockState_1, Rotation rotation_1) {
      return blockState_1;
   }

   @Deprecated
   public BlockState mirror(BlockState blockState_1, Mirror mirror_1) {
      return blockState_1;
   }

   public Block(Block.Settings block$Settings_1) {
      StateFactory.Builder<Block, BlockState> stateFactory$Builder_1 = new StateFactory.Builder(this);
      this.appendProperties(stateFactory$Builder_1);
      this.material = block$Settings_1.material;
      this.materialColor = block$Settings_1.materialColor;
      this.collidable = block$Settings_1.collidable;
      this.soundGroup = block$Settings_1.soundGroup;
      this.lightLevel = block$Settings_1.luminance;
      this.resistance = block$Settings_1.resistance;
      this.hardness = block$Settings_1.hardness;
      this.randomTicks = block$Settings_1.randomTicks;
      this.friction = block$Settings_1.friction;
      this.dynamicBounds = block$Settings_1.dynamicBounds;
      this.dropTableId = block$Settings_1.dropTableId;
      this.stateFactory = stateFactory$Builder_1.build(BlockState::new);
      this.setDefaultState((BlockState)this.stateFactory.getDefaultState());
   }

   protected static boolean method_9553(Block block_1) {
      return block_1 instanceof ShulkerBoxBlock || block_1 instanceof LeavesBlock || block_1.matches(BlockTags.TRAPDOORS) || block_1 instanceof StainedGlassBlock || block_1 == Blocks.BEACON || block_1 == Blocks.CAULDRON || block_1 == Blocks.GLASS || block_1 == Blocks.GLOWSTONE || block_1 == Blocks.ICE || block_1 == Blocks.SEA_LANTERN || block_1 == Blocks.CONDUIT;
   }

   public static boolean method_9581(Block block_1) {
      return method_9553(block_1) || block_1 == Blocks.PISTON || block_1 == Blocks.STICKY_PISTON || block_1 == Blocks.PISTON_HEAD;
   }

   @Deprecated
   public final boolean method_16361(BlockState blockState_1, BlockView blockView_1, BlockPos blockPos_1) {
      return isShapeFullCube(blockState_1.getCollisionShape(blockView_1, blockPos_1));
   }

   @Deprecated
   public boolean isSimpleFullBlock(BlockState blockState_1, BlockView blockView_1, BlockPos blockPos_1) {
      return blockState_1.getMaterial().method_15804() && blockState_1.method_11604(blockView_1, blockPos_1) && !blockState_1.emitsRedstonePower();
   }

   @Deprecated
   public boolean canSuffocate(BlockState blockState_1, BlockView blockView_1, BlockPos blockPos_1) {
      return this.material.suffocates() && blockState_1.method_11604(blockView_1, blockPos_1);
   }

   public final boolean method_9555(BlockState blockState_1, BlockView blockView_1, BlockPos blockPos_1) {
      return blockState_1.method_11603(blockView_1, blockPos_1);
   }

   @Deprecated
   public boolean hasSolidTopSurface(BlockState blockState_1, BlockView blockView_1, BlockPos blockPos_1) {
      return blockState_1.getMaterial().method_15804() && blockState_1.method_11604(blockView_1, blockPos_1);
   }

   @Deprecated
   @Environment(EnvType.CLIENT)
   public boolean hasBlockEntityBreakingRender(BlockState blockState_1) {
      return false;
   }

   @Deprecated
   public boolean canPlaceAtSide(BlockState blockState_1, BlockView blockView_1, BlockPos blockPos_1, BlockPlacementEnvironment blockPlacementEnvironment_1) {
      switch(blockPlacementEnvironment_1) {
      case LAND:
         return !isShapeFullCube(blockState_1.getCollisionShape(blockView_1, blockPos_1));
      case WATER:
         return blockView_1.getFluidState(blockPos_1).matches(FluidTags.WATER);
      case AIR:
         return !isShapeFullCube(blockState_1.getCollisionShape(blockView_1, blockPos_1));
      default:
         return false;
      }
   }

   @Deprecated
   public BlockRenderType getRenderType(BlockState blockState_1) {
      return BlockRenderType.MODEL;
   }

   @Deprecated
   public boolean canReplace(BlockState blockState_1, ItemPlacementContext itemPlacementContext_1) {
      return this.material.isReplaceable() && itemPlacementContext_1.getItemStack().getItem() != this.getItem();
   }

   @Deprecated
   public float getHardness(BlockState blockState_1, BlockView blockView_1, BlockPos blockPos_1) {
      return this.hardness;
   }

   public boolean hasRandomTicks(BlockState blockState_1) {
      return this.randomTicks;
   }

   public boolean hasBlockEntity() {
      return this instanceof BlockEntityProvider;
   }

   @Deprecated
   public boolean shouldPostProcess(BlockState blockState_1, BlockView blockView_1, BlockPos blockPos_1) {
      return false;
   }

   @Deprecated
   @Environment(EnvType.CLIENT)
   public int getBlockBrightness(BlockState blockState_1, ExtendedBlockView extendedBlockView_1, BlockPos blockPos_1) {
      return extendedBlockView_1.getLightmapIndex(blockPos_1, blockState_1.getLuminance());
   }

   @Environment(EnvType.CLIENT)
   public static boolean shouldDrawSide(BlockState blockState_1, BlockView blockView_1, BlockPos blockPos_1, Direction direction_1) {
      BlockPos blockPos_2 = blockPos_1.offset(direction_1);
      BlockState blockState_2 = blockView_1.getBlockState(blockPos_2);
      if (blockState_1.skipRenderingSide(blockState_2, direction_1)) {
         return false;
      } else if (blockState_2.isFullBoundsCubeForCulling()) {
         Block.NeighborGroup block$NeighborGroup_1 = new Block.NeighborGroup(blockState_1, blockState_2, direction_1);
         Object2ByteLinkedOpenHashMap<Block.NeighborGroup> object2ByteLinkedOpenHashMap_1 = (Object2ByteLinkedOpenHashMap)FACE_CULL_MAP.get();
         byte byte_1 = object2ByteLinkedOpenHashMap_1.getAndMoveToFirst(block$NeighborGroup_1);
         if (byte_1 != 127) {
            return byte_1 != 0;
         } else {
            VoxelShape voxelShape_1 = blockState_1.getCullShape(blockView_1, blockPos_1, direction_1);
            VoxelShape voxelShape_2 = blockState_2.getCullShape(blockView_1, blockPos_2, direction_1.getOpposite());
            boolean boolean_1 = VoxelShapes.compareShapes(voxelShape_1, voxelShape_2, BooleanBiFunction.ONLY_FIRST);
            if (object2ByteLinkedOpenHashMap_1.size() == 200) {
               object2ByteLinkedOpenHashMap_1.removeLastByte();
            }

            object2ByteLinkedOpenHashMap_1.putAndMoveToFirst(block$NeighborGroup_1, (byte)(boolean_1 ? 1 : 0));
            return boolean_1;
         }
      } else {
         return true;
      }
   }

   @Deprecated
   public boolean isFullBoundsCubeForCulling(BlockState blockState_1) {
      return this.collidable && this.getRenderLayer() == BlockRenderLayer.SOLID;
   }

   @Deprecated
   @Environment(EnvType.CLIENT)
   public boolean skipRenderingSide(BlockState blockState_1, BlockState blockState_2, Direction direction_1) {
      return false;
   }

   @Deprecated
   public VoxelShape getOutlineShape(BlockState blockState_1, BlockView blockView_1, BlockPos blockPos_1, VerticalEntityPosition verticalEntityPosition_1) {
      return VoxelShapes.fullCube();
   }

   @Deprecated
   public VoxelShape getCollisionShape(BlockState blockState_1, BlockView blockView_1, BlockPos blockPos_1, VerticalEntityPosition verticalEntityPosition_1) {
      return this.collidable ? blockState_1.getOutlineShape(blockView_1, blockPos_1) : VoxelShapes.empty();
   }

   @Deprecated
   public VoxelShape method_9571(BlockState blockState_1, BlockView blockView_1, BlockPos blockPos_1) {
      return blockState_1.getOutlineShape(blockView_1, blockPos_1);
   }

   @Deprecated
   public VoxelShape getRayTraceShape(BlockState blockState_1, BlockView blockView_1, BlockPos blockPos_1) {
      return VoxelShapes.empty();
   }

   public static boolean isFaceFullSquare(VoxelShape voxelShape_1, Direction direction_1) {
      VoxelShape voxelShape_2 = voxelShape_1.getFace(direction_1);
      return isShapeFullCube(voxelShape_2);
   }

   public static boolean isShapeFullCube(VoxelShape voxelShape_1) {
      return !VoxelShapes.compareShapes(VoxelShapes.fullCube(), voxelShape_1, BooleanBiFunction.NOT_SAME);
   }

   @Deprecated
   public final boolean isFullOpaque(BlockState blockState_1, BlockView blockView_1, BlockPos blockPos_1) {
      return blockState_1.isFullBoundsCubeForCulling() ? isShapeFullCube(blockState_1.method_11615(blockView_1, blockPos_1)) : false;
   }

   public boolean isTranslucent(BlockState blockState_1, BlockView blockView_1, BlockPos blockPos_1) {
      return !isShapeFullCube(blockState_1.getOutlineShape(blockView_1, blockPos_1)) && blockState_1.getFluidState().isEmpty();
   }

   @Deprecated
   public int getLightSubtracted(BlockState blockState_1, BlockView blockView_1, BlockPos blockPos_1) {
      if (blockState_1.isFullOpaque(blockView_1, blockPos_1)) {
         return blockView_1.getMaxLightLevel();
      } else {
         return blockState_1.isTranslucent(blockView_1, blockPos_1) ? 0 : 1;
      }
   }

   @Deprecated
   public boolean method_9526(BlockState blockState_1) {
      return false;
   }

   @Deprecated
   public final boolean usesNeighborLightValues(BlockState blockState_1, BlockView blockView_1, BlockPos blockPos_1) {
      return !blockState_1.isFullOpaque(blockView_1, blockPos_1) && blockState_1.getLightSubtracted(blockView_1, blockPos_1) == blockView_1.getMaxLightLevel();
   }

   @Deprecated
   public void onRandomTick(BlockState blockState_1, World world_1, BlockPos blockPos_1, Random random_1) {
      this.onScheduledTick(blockState_1, world_1, blockPos_1, random_1);
   }

   @Deprecated
   public void onScheduledTick(BlockState blockState_1, World world_1, BlockPos blockPos_1, Random random_1) {
   }

   @Environment(EnvType.CLIENT)
   public void randomDisplayTick(BlockState blockState_1, World world_1, BlockPos blockPos_1, Random random_1) {
   }

   public void onBroken(IWorld iWorld_1, BlockPos blockPos_1, BlockState blockState_1) {
   }

   @Deprecated
   public void neighborUpdate(BlockState blockState_1, World world_1, BlockPos blockPos_1, Block block_1, BlockPos blockPos_2) {
   }

   public int getTickRate(ViewableWorld viewableWorld_1) {
      return 10;
   }

   @Nullable
   @Deprecated
   public NameableContainerProvider createContainerProvider(BlockState blockState_1, World world_1, BlockPos blockPos_1) {
      return null;
   }

   @Deprecated
   public void onBlockAdded(BlockState blockState_1, World world_1, BlockPos blockPos_1, BlockState blockState_2) {
   }

   @Deprecated
   public void onBlockRemoved(BlockState blockState_1, World world_1, BlockPos blockPos_1, BlockState blockState_2, boolean boolean_1) {
   }

   @Deprecated
   public float calcBlockBreakingDelta(BlockState blockState_1, PlayerEntity playerEntity_1, BlockView blockView_1, BlockPos blockPos_1) {
      float float_1 = blockState_1.getHardness(blockView_1, blockPos_1);
      if (float_1 == -1.0F) {
         return 0.0F;
      } else {
         int int_1 = playerEntity_1.isUsingEffectiveTool(blockState_1) ? 30 : 100;
         return playerEntity_1.getBlockBreakingSpeed(blockState_1) / float_1 / (float)int_1;
      }
   }

   @Deprecated
   public void onStacksDropped(BlockState blockState_1, World world_1, BlockPos blockPos_1, ItemStack itemStack_1) {
   }

   public Identifier getDropTableId() {
      if (this.dropTableId == null) {
         Identifier identifier_1 = Registry.BLOCK.getId(this);
         this.dropTableId = new Identifier(identifier_1.getNamespace(), "blocks/" + identifier_1.getPath());
      }

      return this.dropTableId;
   }

   @Deprecated
   public List<ItemStack> getDroppedStacks(BlockState blockState_1, LootContext.Builder lootContext$Builder_1) {
      Identifier identifier_1 = this.getDropTableId();
      if (identifier_1 == LootTables.EMPTY) {
         return Collections.emptyList();
      } else {
         LootContext lootContext_1 = lootContext$Builder_1.put(Parameters.BLOCK_STATE, blockState_1).build(LootContextTypes.BLOCK);
         ServerWorld serverWorld_1 = lootContext_1.getWorld();
         LootSupplier lootSupplier_1 = serverWorld_1.getServer().getLootManager().getSupplier(identifier_1);
         return lootSupplier_1.getDrops(lootContext_1);
      }
   }

   public static List<ItemStack> getDroppedStacks(BlockState blockState_1, ServerWorld serverWorld_1, BlockPos blockPos_1, @Nullable BlockEntity blockEntity_1) {
      LootContext.Builder lootContext$Builder_1 = (new LootContext.Builder(serverWorld_1)).setRandom(serverWorld_1.random).put(Parameters.POSITION, blockPos_1).put(Parameters.TOOL, ItemStack.EMPTY).putNullable(Parameters.BLOCK_ENTITY, blockEntity_1);
      return blockState_1.getDroppedStacks(lootContext$Builder_1);
   }

   public static List<ItemStack> getDroppedStacks(BlockState blockState_1, ServerWorld serverWorld_1, BlockPos blockPos_1, @Nullable BlockEntity blockEntity_1, Entity entity_1, ItemStack itemStack_1) {
      LootContext.Builder lootContext$Builder_1 = (new LootContext.Builder(serverWorld_1)).setRandom(serverWorld_1.random).put(Parameters.POSITION, blockPos_1).put(Parameters.TOOL, itemStack_1).put(Parameters.THIS_ENTITY, entity_1).putNullable(Parameters.BLOCK_ENTITY, blockEntity_1);
      return blockState_1.getDroppedStacks(lootContext$Builder_1);
   }

   public static void dropStacks(BlockState blockState_1, LootContext.Builder lootContext$Builder_1) {
      ServerWorld serverWorld_1 = lootContext$Builder_1.getWorld();
      BlockPos blockPos_1 = (BlockPos)lootContext$Builder_1.get(Parameters.POSITION);
      blockState_1.getDroppedStacks(lootContext$Builder_1).forEach((itemStack_1) -> {
         dropStack(serverWorld_1, blockPos_1, itemStack_1);
      });
      blockState_1.onStacksDropped(serverWorld_1, blockPos_1, ItemStack.EMPTY);
   }

   public static void dropStacks(BlockState blockState_1, World world_1, BlockPos blockPos_1) {
      if (world_1 instanceof ServerWorld) {
         getDroppedStacks(blockState_1, (ServerWorld)world_1, blockPos_1, (BlockEntity)null).forEach((itemStack_1) -> {
            dropStack(world_1, blockPos_1, itemStack_1);
         });
      }

      blockState_1.onStacksDropped(world_1, blockPos_1, ItemStack.EMPTY);
   }

   public static void dropStacks(BlockState blockState_1, World world_1, BlockPos blockPos_1, @Nullable BlockEntity blockEntity_1) {
      if (world_1 instanceof ServerWorld) {
         getDroppedStacks(blockState_1, (ServerWorld)world_1, blockPos_1, blockEntity_1).forEach((itemStack_1) -> {
            dropStack(world_1, blockPos_1, itemStack_1);
         });
      }

      blockState_1.onStacksDropped(world_1, blockPos_1, ItemStack.EMPTY);
   }

   public static void dropStacks(BlockState blockState_1, World world_1, BlockPos blockPos_1, @Nullable BlockEntity blockEntity_1, Entity entity_1, ItemStack itemStack_1) {
      if (world_1 instanceof ServerWorld) {
         getDroppedStacks(blockState_1, (ServerWorld)world_1, blockPos_1, blockEntity_1, entity_1, itemStack_1).forEach((itemStack_1x) -> {
            dropStack(world_1, blockPos_1, itemStack_1x);
         });
      }

      blockState_1.onStacksDropped(world_1, blockPos_1, itemStack_1);
   }

   public static void dropStack(World world_1, BlockPos blockPos_1, ItemStack itemStack_1) {
      if (!world_1.isClient && !itemStack_1.isEmpty() && world_1.getGameRules().getBoolean("doTileDrops")) {
         float float_1 = 0.5F;
         double double_1 = (double)(world_1.random.nextFloat() * 0.5F) + 0.25D;
         double double_2 = (double)(world_1.random.nextFloat() * 0.5F) + 0.25D;
         double double_3 = (double)(world_1.random.nextFloat() * 0.5F) + 0.25D;
         ItemEntity itemEntity_1 = new ItemEntity(world_1, (double)blockPos_1.getX() + double_1, (double)blockPos_1.getY() + double_2, (double)blockPos_1.getZ() + double_3, itemStack_1);
         itemEntity_1.setToDefaultPickupDelay();
         world_1.spawnEntity(itemEntity_1);
      }
   }

   protected void dropExperience(World world_1, BlockPos blockPos_1, int int_1) {
      if (!world_1.isClient && world_1.getGameRules().getBoolean("doTileDrops")) {
         while(int_1 > 0) {
            int int_2 = ExperienceOrbEntity.roundToOrbSize(int_1);
            int_1 -= int_2;
            world_1.spawnEntity(new ExperienceOrbEntity(world_1, (double)blockPos_1.getX() + 0.5D, (double)blockPos_1.getY() + 0.5D, (double)blockPos_1.getZ() + 0.5D, int_2));
         }
      }

   }

   public float getBlastResistance() {
      return this.resistance;
   }

   public void onDestroyedByExplosion(World world_1, BlockPos blockPos_1, Explosion explosion_1) {
   }

   public BlockRenderLayer getRenderLayer() {
      return BlockRenderLayer.SOLID;
   }

   @Deprecated
   public boolean canPlaceAt(BlockState blockState_1, ViewableWorld viewableWorld_1, BlockPos blockPos_1) {
      return true;
   }

   @Deprecated
   public boolean activate(BlockState blockState_1, World world_1, BlockPos blockPos_1, PlayerEntity playerEntity_1, Hand hand_1, BlockHitResult blockHitResult_1) {
      return false;
   }

   public void onSteppedOn(World world_1, BlockPos blockPos_1, Entity entity_1) {
   }

   @Nullable
   public BlockState getPlacementState(ItemPlacementContext itemPlacementContext_1) {
      return this.getDefaultState();
   }

   @Deprecated
   public void onBlockBreakStart(BlockState blockState_1, World world_1, BlockPos blockPos_1, PlayerEntity playerEntity_1) {
   }

   @Deprecated
   public int getWeakRedstonePower(BlockState blockState_1, BlockView blockView_1, BlockPos blockPos_1, Direction direction_1) {
      return 0;
   }

   @Deprecated
   public boolean emitsRedstonePower(BlockState blockState_1) {
      return false;
   }

   @Deprecated
   public void onEntityCollision(BlockState blockState_1, World world_1, BlockPos blockPos_1, Entity entity_1) {
   }

   @Deprecated
   public int getStrongRedstonePower(BlockState blockState_1, BlockView blockView_1, BlockPos blockPos_1, Direction direction_1) {
      return 0;
   }

   public void afterBreak(World world_1, PlayerEntity playerEntity_1, BlockPos blockPos_1, BlockState blockState_1, @Nullable BlockEntity blockEntity_1, ItemStack itemStack_1) {
      playerEntity_1.incrementStat(Stats.MINED.getOrCreateStat(this));
      playerEntity_1.addExhaustion(0.005F);
      dropStacks(blockState_1, world_1, blockPos_1, blockEntity_1, playerEntity_1, itemStack_1);
   }

   public void onPlaced(World world_1, BlockPos blockPos_1, BlockState blockState_1, @Nullable LivingEntity livingEntity_1, ItemStack itemStack_1) {
   }

   public boolean canMobSpawnInside() {
      return !this.material.method_15799() && !this.material.isLiquid();
   }

   @Environment(EnvType.CLIENT)
   public TextComponent getTextComponent() {
      return new TranslatableTextComponent(this.getTranslationKey(), new Object[0]);
   }

   public String getTranslationKey() {
      if (this.translationKey == null) {
         this.translationKey = SystemUtil.createTranslationKey("block", Registry.BLOCK.getId(this));
      }

      return this.translationKey;
   }

   @Deprecated
   public boolean onBlockAction(BlockState blockState_1, World world_1, BlockPos blockPos_1, int int_1, int int_2) {
      return false;
   }

   @Deprecated
   public PistonBehavior getPistonBehavior(BlockState blockState_1) {
      return this.material.getPistonBehavior();
   }

   @Deprecated
   @Environment(EnvType.CLIENT)
   public float getAmbientOcclusionLightLevel(BlockState blockState_1, BlockView blockView_1, BlockPos blockPos_1) {
      return blockState_1.method_11603(blockView_1, blockPos_1) ? 0.2F : 1.0F;
   }

   public void onLandedUpon(World world_1, BlockPos blockPos_1, Entity entity_1, float float_1) {
      entity_1.handleFallDamage(float_1, 1.0F);
   }

   public void onEntityLand(BlockView blockView_1, Entity entity_1) {
      entity_1.velocityY = 0.0D;
   }

   @Environment(EnvType.CLIENT)
   public ItemStack getPickStack(BlockView blockView_1, BlockPos blockPos_1, BlockState blockState_1) {
      return new ItemStack(this);
   }

   public void addStacksForDisplay(ItemGroup itemGroup_1, DefaultedList<ItemStack> defaultedList_1) {
      defaultedList_1.add(new ItemStack(this));
   }

   @Deprecated
   public FluidState getFluidState(BlockState blockState_1) {
      return Fluids.EMPTY.getDefaultState();
   }

   public float getFrictionCoefficient() {
      return this.friction;
   }

   @Deprecated
   @Environment(EnvType.CLIENT)
   public long getRenderingSeed(BlockState blockState_1, BlockPos blockPos_1) {
      return MathHelper.hashCode(blockPos_1);
   }

   public void onBreak(World world_1, BlockPos blockPos_1, BlockState blockState_1, PlayerEntity playerEntity_1) {
      world_1.fireWorldEvent(playerEntity_1, 2001, blockPos_1, getRawIdFromState(blockState_1));
   }

   public void onRainTick(World world_1, BlockPos blockPos_1) {
   }

   public boolean shouldDropItemsOnExplosion(Explosion explosion_1) {
      return true;
   }

   @Deprecated
   public boolean hasComparatorOutput(BlockState blockState_1) {
      return false;
   }

   @Deprecated
   public int getComparatorOutput(BlockState blockState_1, World world_1, BlockPos blockPos_1) {
      return 0;
   }

   protected void appendProperties(StateFactory.Builder<Block, BlockState> stateFactory$Builder_1) {
   }

   public StateFactory<Block, BlockState> getStateFactory() {
      return this.stateFactory;
   }

   protected final void setDefaultState(BlockState blockState_1) {
      this.defaultState = blockState_1;
   }

   public final BlockState getDefaultState() {
      return this.defaultState;
   }

   public Block.OffsetType getOffsetType() {
      return Block.OffsetType.NONE;
   }

   @Deprecated
   public Vec3d getOffsetPos(BlockState blockState_1, BlockView blockView_1, BlockPos blockPos_1) {
      Block.OffsetType block$OffsetType_1 = this.getOffsetType();
      if (block$OffsetType_1 == Block.OffsetType.NONE) {
         return Vec3d.ZERO;
      } else {
         long long_1 = MathHelper.hashCode(blockPos_1.getX(), 0, blockPos_1.getZ());
         return new Vec3d(((double)((float)(long_1 & 15L) / 15.0F) - 0.5D) * 0.5D, block$OffsetType_1 == Block.OffsetType.XYZ ? ((double)((float)(long_1 >> 4 & 15L) / 15.0F) - 1.0D) * 0.2D : 0.0D, ((double)((float)(long_1 >> 8 & 15L) / 15.0F) - 0.5D) * 0.5D);
      }
   }

   public BlockSoundGroup getSoundGroup(BlockState blockState_1) {
      return this.soundGroup;
   }

   public Item getItem() {
      if (this.cachedItem == null) {
         this.cachedItem = Item.getItemFromBlock(this);
      }

      return this.cachedItem;
   }

   public boolean hasDynamicBounds() {
      return this.dynamicBounds;
   }

   public String toString() {
      return "Block{" + Registry.BLOCK.getId(this) + "}";
   }

   @Environment(EnvType.CLIENT)
   public void buildTooltip(ItemStack itemStack_1, @Nullable BlockView blockView_1, List<TextComponent> list_1, TooltipOptions tooltipOptions_1) {
   }

   public static boolean isNaturalStone(Block block_1) {
      return block_1 == Blocks.STONE || block_1 == Blocks.GRANITE || block_1 == Blocks.DIORITE || block_1 == Blocks.ANDESITE;
   }

   public static boolean isNaturalDirt(Block block_1) {
      return block_1 == Blocks.DIRT || block_1 == Blocks.COARSE_DIRT || block_1 == Blocks.PODZOL;
   }

   static {
      FACINGS = new Direction[]{Direction.WEST, Direction.EAST, Direction.NORTH, Direction.SOUTH, Direction.DOWN, Direction.UP};
      FACE_CULL_MAP = ThreadLocal.withInitial(() -> {
         Object2ByteLinkedOpenHashMap<Block.NeighborGroup> object2ByteLinkedOpenHashMap_1 = new Object2ByteLinkedOpenHashMap<Block.NeighborGroup>(200) {
            protected void rehash(int int_1) {
            }
         };
         object2ByteLinkedOpenHashMap_1.defaultReturnValue((byte)127);
         return object2ByteLinkedOpenHashMap_1;
      });
   }

   public static enum OffsetType {
      NONE,
      XZ,
      XYZ;
   }

   public static class Settings {
      private Material material;
      private MaterialColor materialColor;
      private boolean collidable = true;
      private BlockSoundGroup soundGroup;
      private int luminance;
      private float resistance;
      private float hardness;
      private boolean randomTicks;
      private float friction;
      private Identifier dropTableId;
      private boolean dynamicBounds;

      private Settings(Material material_1, MaterialColor materialColor_1) {
         this.soundGroup = BlockSoundGroup.STONE;
         this.friction = 0.6F;
         this.material = material_1;
         this.materialColor = materialColor_1;
      }

      public static Block.Settings of(Material material_1) {
         return of(material_1, material_1.getColor());
      }

      public static Block.Settings of(Material material_1, DyeColor dyeColor_1) {
         return of(material_1, dyeColor_1.getMaterialColor());
      }

      public static Block.Settings of(Material material_1, MaterialColor materialColor_1) {
         return new Block.Settings(material_1, materialColor_1);
      }

      public static Block.Settings copy(Block block_1) {
         Block.Settings block$Settings_1 = new Block.Settings(block_1.material, block_1.materialColor);
         block$Settings_1.material = block_1.material;
         block$Settings_1.hardness = block_1.hardness;
         block$Settings_1.resistance = block_1.resistance;
         block$Settings_1.collidable = block_1.collidable;
         block$Settings_1.randomTicks = block_1.randomTicks;
         block$Settings_1.luminance = block_1.lightLevel;
         block$Settings_1.materialColor = block_1.materialColor;
         block$Settings_1.soundGroup = block_1.soundGroup;
         block$Settings_1.friction = block_1.getFrictionCoefficient();
         block$Settings_1.dynamicBounds = block_1.dynamicBounds;
         return block$Settings_1;
      }

      public Block.Settings noCollision() {
         this.collidable = false;
         return this;
      }

      public Block.Settings friction(float float_1) {
         this.friction = float_1;
         return this;
      }

      protected Block.Settings sounds(BlockSoundGroup blockSoundGroup_1) {
         this.soundGroup = blockSoundGroup_1;
         return this;
      }

      protected Block.Settings lightLevel(int int_1) {
         this.luminance = int_1;
         return this;
      }

      public Block.Settings strength(float float_1, float float_2) {
         this.hardness = float_1;
         this.resistance = Math.max(0.0F, float_2);
         return this;
      }

      protected Block.Settings breakInstantly() {
         return this.strength(0.0F);
      }

      protected Block.Settings strength(float float_1) {
         this.strength(float_1, float_1);
         return this;
      }

      protected Block.Settings ticksRandomly() {
         this.randomTicks = true;
         return this;
      }

      protected Block.Settings hasDynamicBounds() {
         this.dynamicBounds = true;
         return this;
      }

      protected Block.Settings dropsNothing() {
         this.dropTableId = LootTables.EMPTY;
         return this;
      }

      public Block.Settings dropsLike(Block block_1) {
         this.dropTableId = block_1.getDropTableId();
         return this;
      }
   }

   public static final class NeighborGroup {
      private final BlockState self;
      private final BlockState other;
      private final Direction facing;

      public NeighborGroup(BlockState blockState_1, BlockState blockState_2, Direction direction_1) {
         this.self = blockState_1;
         this.other = blockState_2;
         this.facing = direction_1;
      }

      public boolean equals(Object object_1) {
         if (this == object_1) {
            return true;
         } else if (!(object_1 instanceof Block.NeighborGroup)) {
            return false;
         } else {
            Block.NeighborGroup block$NeighborGroup_1 = (Block.NeighborGroup)object_1;
            return this.self == block$NeighborGroup_1.self && this.other == block$NeighborGroup_1.other && this.facing == block$NeighborGroup_1.facing;
         }
      }

      public int hashCode() {
         return Objects.hash(new Object[]{this.self, this.other, this.facing});
      }
   }
}
