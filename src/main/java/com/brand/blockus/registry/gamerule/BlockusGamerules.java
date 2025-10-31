package com.brand.blockus.registry.gamerule;

import com.brand.blockus.Blockus;
import net.fabricmc.fabric.api.gamerule.v1.CustomGameRuleCategory;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleFactory;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleRegistry;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.GameRules;

public class BlockusGamerules {

    public static final CustomGameRuleCategory BLOCKUS_CATEGORY = new CustomGameRuleCategory(Blockus.id("blockus"), Component.literal("Blockus").withStyle(style -> style.withBold(true).withColor(ChatFormatting.YELLOW)));
    public static final GameRules.Key<GameRules.BooleanValue> ENABLE_ASPHALT_SPRINT = register("enableAsphaltSprint", GameRuleFactory.createBooleanRule(true));

    private static <T extends GameRules.Value<T>> GameRules.Key<T> register(String name, GameRules.Type<T> type) {
        return GameRuleRegistry.register(name, BLOCKUS_CATEGORY, type);
    }
}
