package com.brand.blockus.blocks;

import com.brand.blockus.Blockus;

import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tools.FabricToolTags;
import net.minecraft.block.BlockState;
import net.minecraft.block.FallingBlock;
import net.minecraft.block.Material;
import net.minecraft.item.Item;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.item.BlockItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.BlockView;

@SuppressWarnings("deprecation")
public class FallingRedstoneBase extends FallingBlock {
		
	public FallingRedstoneBase(String name, float hardness, float resistance) {
		super(FabricBlockSettings.of(Material.SAND).sounds(BlockSoundGroup.SAND).breakByTool(FabricToolTags.SHOVELS, 0).strength(hardness, resistance).build());
		Registry.register(Registry.BLOCK, new Identifier(Blockus.MOD_ID, name), this);
		Registry.register(Registry.ITEM,new Identifier(Blockus.MOD_ID, name), new BlockItem(this, new Item.Settings().stackSize(64).itemGroup(Blockus.BLOCKUS_REDSTONE)));
	}

	   public boolean emitsRedstonePower(BlockState blockState_1) {
	      return true;
	   }

	   public int getWeakRedstonePower(BlockState blockState_1, BlockView blockView_1, BlockPos blockPos_1, Direction direction_1) {
	      return 15;
	   }
	}
