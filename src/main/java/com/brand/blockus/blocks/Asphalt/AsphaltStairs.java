package com.brand.blockus.blocks.Asphalt;


import com.brand.blockus.blocks.Base.StairsBase;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class AsphaltStairs extends StairsBase {

    public AsphaltStairs(BlockState state, String name, AbstractBlock copy) {
        super(state, name, copy);
    }

    @Override
    public void onSteppedOn(World world_1, BlockPos blockPos_1, Entity entity_1) {
        if (entity_1.getType() == EntityType.PLAYER) {
            ((LivingEntity) entity_1).addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 10, 4, true, false, false));
        }
    }
}