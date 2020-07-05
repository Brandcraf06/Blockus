package com.brand.blockus.blocks.Wood;

import com.brand.blockus.Blockus;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.block.MaterialColor;
import net.minecraft.block.PillarBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.BlockView;

public class LogBlockBase extends PillarBlock {
    private final MaterialColor materialColor;
    private final MaterialColor materialColor2;

    public LogBlockBase(MaterialColor materialColor, MaterialColor materialColor2, String name, float hardness, float resistance) {
        super(FabricBlockSettings.of(Material.WOOD).sounds(BlockSoundGroup.WOOD).breakByTool(FabricToolTags.AXES, 0).strength(hardness, resistance));
        Registry.register(Registry.BLOCK, new Identifier(Blockus.MOD_ID, name), this);
        Registry.register(Registry.ITEM, new Identifier(Blockus.MOD_ID, name), new BlockItem(this, new Item.Settings().maxCount(64).group(Blockus.BLOCKUS_BUILDING_BLOCKS)));
        this.materialColor = materialColor;
        this.materialColor2 = materialColor2;
    }

    public MaterialColor getMapColor(BlockState state, BlockView world, BlockPos pos) {
        return state.get(AXIS) == Direction.Axis.Y ? this.materialColor : this.materialColor2;
    }
}

