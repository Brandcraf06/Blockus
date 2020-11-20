package com.brand.blockus.blocks;


import com.brand.blockus.Blockus;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.block.MaterialColor;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

public class NetherStarsBlock extends Block {

    public NetherStarsBlock(String name, float hardness, float resistance) {
        super(FabricBlockSettings.of(Material.STONE, MaterialColor.QUARTZ).requiresTool().breakByTool(FabricToolTags.PICKAXES, 1).strength(hardness, resistance));
        Registry.register(Registry.BLOCK, new Identifier(Blockus.MOD_ID, name), this);
        Registry.register(Registry.ITEM, new Identifier(Blockus.MOD_ID, name), new BlockItem(this, new Item.Settings().maxCount(64).group(Blockus.BLOCKUS_BUILDING_BLOCKS).rarity(Rarity.EPIC)));
    }

    @Override
    public void onSteppedOn(World world_1, BlockPos blockPos_1, Entity entity_1) {
        if (entity_1.getType() == EntityType.PLAYER) {
            ((LivingEntity) entity_1).addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 1, 4, true, false, false));
            ((LivingEntity) entity_1).addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 100, 3, true, false, true));
            ((LivingEntity) entity_1).addStatusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 1200, 4, true, false, true));
        }
    }
}
