package com.brand.blockus.registry.gamerule;

import com.brand.blockus.Blockus;
import net.fabricmc.fabric.api.gamerule.v1.CustomGameRuleCategory;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleFactory;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleRegistry;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.GameRules;

public class BlockusGamerules {

    public static final CustomGameRuleCategory BLOCKUS_CATEGORY = new CustomGameRuleCategory(Blockus.id("blockus"), Text.literal("Blockus").styled(style -> style.withBold(true).withColor(Formatting.YELLOW)));
    public static final GameRules.Key<GameRules.BooleanRule> ENABLE_ASPHALT_SPRINT = register("enableAsphaltSprint", GameRuleFactory.createBooleanRule(true));

    private static <T extends GameRules.Rule<T>> GameRules.Key<T> register(String name, GameRules.Type<T> type) {
        return GameRuleRegistry.register(name, BLOCKUS_CATEGORY, type);
    }
}
