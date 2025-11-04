package com.brand.blockus.registry.gamerule;

import com.brand.blockus.Blockus;
import net.fabricmc.fabric.api.gamerule.v1.CustomGameRuleCategory;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleBuilder;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.gamerules.GameRule;

public class BlockusGamerules {

    public static final CustomGameRuleCategory BLOCKUS_CATEGORY = new CustomGameRuleCategory(Blockus.id("blockus"), Component.literal("Blockus").withStyle(style -> style.withBold(true).withColor(ChatFormatting.YELLOW)));
    public static final GameRule<Boolean> ENABLE_ASPHALT_SPRINT = GameRuleBuilder.forBoolean(true).category(BLOCKUS_CATEGORY).buildAndRegister(Blockus.id("enable_asphalt_sprint"));
}

