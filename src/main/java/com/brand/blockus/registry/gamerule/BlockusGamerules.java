package com.brand.blockus.registry.gamerule;

import com.brand.blockus.Blockus;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleBuilder;
import net.minecraft.world.level.gamerules.GameRule;
import net.minecraft.world.level.gamerules.GameRuleCategory;

public class BlockusGamerules {

    public static final GameRuleCategory BLOCKUS_CATEGORY = new GameRuleCategory(Blockus.id("blockus"));
    public static final GameRule<Boolean> ENABLE_ASPHALT_SPRINT = GameRuleBuilder.forBoolean(true).category(BLOCKUS_CATEGORY).buildAndRegister(Blockus.id("enable_asphalt_sprint"));
}

