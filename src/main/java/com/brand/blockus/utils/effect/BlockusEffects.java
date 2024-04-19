package com.brand.blockus.utils.effect;

import com.brand.blockus.Blockus;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;

public class BlockusEffects {
    public static final RegistryEntry<StatusEffect> ASPHALT_SPRINT = register("asphalt_sprint", new AsphaltStatusEffect().addAttributeModifier(EntityAttributes.GENERIC_MOVEMENT_SPEED, "ab0e24b0-f62d-4cf8-8d35-62989caa5b5f", 0.40D, EntityAttributeModifier.Operation.ADD_MULTIPLIED_TOTAL));

    public static RegistryEntry<StatusEffect> register(String id, StatusEffect effect) {
        return Registry.registerReference(Registries.STATUS_EFFECT, Blockus.id(id), effect);
    }
}
