package com.brand.blockus.blocks;

import com.brand.blockus.Blockus;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class AsphaltSlab extends SlabBase {

	public AsphaltSlab(String name, float hardness, float resistance) {
		super(name, hardness, resistance);
	}

	@Override
	public void onSteppedOn(World world_1, BlockPos blockPos_1, Entity entity_1) {
	if (Blockus.CONFIG.enableAsphaltEffect) {
		if (entity_1.getType() != EntityType.ITEM) {
			((LivingEntity) entity_1).addPotionEffect(new StatusEffectInstance(StatusEffects.SPEED, 4, Blockus.CONFIG.AsphaltSpeedAmplifier, true, false, false));
		}
	}
  }
}
