package com.brand.blockus.blocks;

import java.util.Random;

import com.brand.blockus.Blockus;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

public class LoveBlock extends Block {

	public LoveBlock(String name, float hardness, float resistance) {
		super(FabricBlockSettings.of(Material.STONE).requiresTool().strength(hardness, resistance)); 
		Registry.register(Registry.BLOCK, new Identifier(Blockus.MOD_ID, name), this);
		Registry.register(Registry.ITEM,new Identifier(Blockus.MOD_ID, name), new BlockItem(this, new Item.Settings().maxCount(64).group(Blockus.BLOCKUS_DECORATIONS)));
	}
	@Environment(EnvType.CLIENT)
	public void randomDisplayTick(BlockState blockState_1, World world_1, BlockPos blockPos_1, Random random_1) {
	    if (random_1.nextInt(5) == 0) {
	        for(int int_1 = 0; int_1 < random_1.nextInt(1) + 1; ++int_1) {
	            world_1.addParticle(ParticleTypes.HEART, (double)((float)blockPos_1.getX() + 0.5F), (double)((float)blockPos_1.getY() + 1.0F), (double)((float)blockPos_1.getZ() + 0.5F), (double)(random_1.nextFloat() / 2.0F), 5.0E-5D, (double)(random_1.nextFloat() / 2.0F));
	        }
	    }
	}
  }
