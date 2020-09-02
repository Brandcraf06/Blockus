package com.brand.blockus.blocks.Asphalt;

import com.brand.blockus.Blockus;
import com.brand.blockus.blocks.BlockItem.SpeedBlockItem;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.SlabBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

public class AsphaltSlab extends SlabBlock {

	public AsphaltSlab(String name, AbstractBlock copy) {
		super(FabricBlockSettings.copy(copy));
		Registry.register(Registry.BLOCK, new Identifier(Blockus.MOD_ID, name), this);
		Registry.register(Registry.ITEM,new Identifier(Blockus.MOD_ID, name), new SpeedBlockItem(this, new Item.Settings().maxCount(64).group(Blockus.BLOCKUS_BUILDING_BLOCKS)));
	}

	@Override
	public void onSteppedOn(World world_1, BlockPos blockPos_1, Entity target) {
		if (target instanceof LivingEntity) {
	    ((LivingEntity) target).addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 5, 2, true, false, false));
		}
	}
}
