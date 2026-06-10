package com.brand.blockus.registry.content.bundles;

import com.brand.blockus.blocks.base.WeatheringCopperWallBlock;
import com.brand.blockus.utils.blocks.CopperBlockItemCollection;
import com.brand.blockus.utils.helper.BlockFactory;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import org.apache.commons.lang3.function.TriFunction;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public record CopperBSSWBundle(Provider base, CopperBlockItemCollection block, CopperBlockItemCollection stairs,
                               CopperBlockItemCollection slab, CopperBlockItemCollection wall) {

    public static final List<CopperBSSWBundle> LIST = new ArrayList<>();

    public static List<CopperBSSWBundle> values() {
        return LIST;
    }

    public List<CopperBlockItemCollection> all() {
        return List.of(block, stairs, slab, wall);
    }

    public interface Provider {
        Block pick(WeatheringCopper.WeatherState state);
    }

    public static <Id> CopperBSSWBundle register(WeatheringCopperCollection<Id> ids, WeatheringCopperCollection<Id> idsStairs, WeatheringCopperCollection<Id> idsSlab, WeatheringCopperCollection<Id> idsWall, TriFunction<Id, Function<BlockBehaviour.Properties, Block>, BlockBehaviour.Properties, Block> register, Provider base) {
        CopperBlockItemCollection block = BlockFactory.registerCopperBlocks(ids, register, (var0, p) -> new Block(p), WeatheringCopperFullBlock::new, (statex) -> BlockFactory.createCopy(base.pick(statex)));
        CopperBSSWBundle bundle = new CopperBSSWBundle(base,
            block,
            BlockFactory.registerCopperBlocks(idsStairs, register, (statex, p) -> new StairBlock(block.blocks().waxed().pick(statex).defaultBlockState(), p), (statex, p) -> new WeatheringCopperStairBlock(statex, block.blocks().weathering().pick(statex).defaultBlockState(), p), (statex) -> BlockFactory.createCopy(block.blocks().weathering().pick(statex))),
            BlockFactory.registerCopperBlocks(idsSlab, register, (var0, p) -> new SlabBlock(p), WeatheringCopperSlabBlock::new, (statex) -> BlockFactory.createCopy(block.blocks().weathering().pick(statex))),
            BlockFactory.registerCopperBlocks(idsWall, register, (var0, p) -> new WallBlock(p), WeatheringCopperWallBlock::new, (statex) -> BlockFactory.createCopy(block.blocks().weathering().pick(statex)))
        );
        LIST.add(bundle);
        return bundle;
    }
}
