package com.brand.blockus.registry.effect;

import com.brand.blockus.Blockus;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;

public class BlockusEffects {
    public static final Holder<MobEffect> ASPHALT_SPRINT = register("asphalt_sprint", new AsphaltStatusEffect().addAttributeModifier(Attributes.MOVEMENT_SPEED, Identifier.withDefaultNamespace("effect.speed"), 0.40D, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL));

    public static Holder<MobEffect> register(String id, MobEffect effect) {
        return Registry.registerForHolder(BuiltInRegistries.MOB_EFFECT, Blockus.id(id), effect);
    }
}
