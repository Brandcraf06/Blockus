package com.brand.blockus.registry.content.bundles;

import com.brand.blockus.blocks.base.WeatheringCopperWallBlock;
import com.brand.blockus.utils.helper.BlockFactory;
import net.minecraft.world.level.block.*;

import java.util.ArrayList;
import java.util.List;

public record CopperBSSWBundle(
    String type,
    Provider base,
    WeatheringCopperCollection<Block> block,
    WeatheringCopperCollection<Block> stairs,
    WeatheringCopperCollection<Block> slab,
    WeatheringCopperCollection<Block> wall
) {

    public static final List<CopperBSSWBundle> LIST = new ArrayList<>();

    public static List<CopperBSSWBundle> values() {
        return LIST;
    }

    public List<WeatheringCopperCollection<Block>> all() {
        return List.of(block, stairs, slab, wall);
    }

    public interface Provider {
        Block pick(WeatheringCopper.WeatherState state);
    }

    public static CopperBSSWBundle register(String type, Provider base) {
        WeatheringCopperCollection<Block> block = WeatheringCopperCollection.registerBlocks(type, BlockFactory::registerOf, (var0, p) -> new Block(p), WeatheringCopperFullBlock::new, (statex) -> BlockFactory.createCopy(base.pick(statex)));
        CopperBSSWBundle bundle = new CopperBSSWBundle(type, base,
            block,
            WeatheringCopperCollection.registerBlocks(BlockFactory.replaceId(type) + "_stairs", BlockFactory::registerOf, (statex, p) -> new StairBlock(block.pick(statex, true).defaultBlockState(), p), (statex, p) -> new WeatheringCopperStairBlock(statex, block.pick(statex, false).defaultBlockState(), p), (statex) -> BlockFactory.createCopy(block.pick(statex, false))),
            WeatheringCopperCollection.registerBlocks(BlockFactory.replaceId(type) + "_slab", BlockFactory::registerOf, (var0, p) -> new SlabBlock(p), WeatheringCopperSlabBlock::new, (statex) -> BlockFactory.createCopy(block.pick(statex, false))),
            WeatheringCopperCollection.registerBlocks(BlockFactory.replaceId(type) + "_wall", BlockFactory::registerOf, (var0, p) -> new WallBlock(p), WeatheringCopperWallBlock::new, (statex) -> BlockFactory.createCopy(block.pick(statex, false)))
        );
        LIST.add(bundle);
        return bundle;
    }
}
