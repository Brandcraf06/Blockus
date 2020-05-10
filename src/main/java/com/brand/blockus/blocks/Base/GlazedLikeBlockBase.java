package com.brand.blockus.blocks.Base;

import com.brand.blockus.Blockus;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.StateManager;
import net.minecraft.tag.Tag;
import net.minecraft.item.BlockItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class GlazedLikeBlockBase extends HorizontalFacingBlock {

		public GlazedLikeBlockBase(String name, float hardness, float resistance, Material material, BlockSoundGroup sound, Tag<Item> tag, int mininglevel) {
			super(FabricBlockSettings.of(material).sounds(sound).breakByTool(tag, mininglevel).strength(hardness, resistance));
			Registry.register(Registry.BLOCK, new Identifier(Blockus.MOD_ID, name), this);
			Registry.register(Registry.ITEM,new Identifier(Blockus.MOD_ID, name), new BlockItem(this, new Item.Settings().maxCount(64).group(Blockus.BLOCKUS_BUILDING_BLOCKS)));
		}

		   protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
		      builder.add(FACING);
		   }

		   public BlockState getPlacementState(ItemPlacementContext ctx) {
		      return (BlockState)this.getDefaultState().with(FACING, ctx.getPlayerFacing().getOpposite());
		   }

		}