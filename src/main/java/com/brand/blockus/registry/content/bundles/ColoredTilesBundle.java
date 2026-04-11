package com.brand.blockus.registry.content.bundles;

import com.brand.blockus.blocks.base.ColoredTilesBlock;
import com.brand.blockus.utils.helper.BlockFactory;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public record ColoredTilesBundle(
    Block tile1,
    Block tile2,
    Block block
) {

    public static final List<ColoredTilesBundle> LIST = new ArrayList<>();
    public static final Map<Block, Block[]> tilePairs = new LinkedHashMap<>();

    static {
        tilePairs.put(Blocks.CONCRETE.white(), new Block[]{
            Blocks.CONCRETE.lightGray(), Blocks.CONCRETE.gray(), Blocks.CONCRETE.black(), Blocks.CONCRETE.brown(), Blocks.CONCRETE.red(),
            Blocks.CONCRETE.orange(), Blocks.CONCRETE.yellow(), Blocks.CONCRETE.lime(), Blocks.CONCRETE.green(), Blocks.CONCRETE.cyan(),
            Blocks.CONCRETE.lightBlue(), Blocks.CONCRETE.blue(), Blocks.CONCRETE.purple(), Blocks.CONCRETE.magenta(), Blocks.CONCRETE.pink()
        });
        tilePairs.put(Blocks.CONCRETE.black(), new Block[]{
            Blocks.CONCRETE.lightGray(), Blocks.CONCRETE.gray(), Blocks.CONCRETE.brown(), Blocks.CONCRETE.red(),
            Blocks.CONCRETE.orange(), Blocks.CONCRETE.yellow(), Blocks.CONCRETE.lime(), Blocks.CONCRETE.green(),
            Blocks.CONCRETE.cyan(), Blocks.CONCRETE.lightBlue(), Blocks.CONCRETE.blue(), Blocks.CONCRETE.purple(),
            Blocks.CONCRETE.magenta(), Blocks.CONCRETE.pink()
        });
        tilePairs.put(Blocks.CONCRETE.red(), new Block[]{
            Blocks.CONCRETE.lightGray(), Blocks.CONCRETE.gray(), Blocks.CONCRETE.brown(), Blocks.CONCRETE.orange(), Blocks.CONCRETE.yellow(),
            Blocks.CONCRETE.lime(), Blocks.CONCRETE.green(), Blocks.CONCRETE.cyan(), Blocks.CONCRETE.lightBlue(), Blocks.CONCRETE.blue(),
            Blocks.CONCRETE.purple(), Blocks.CONCRETE.magenta(), Blocks.CONCRETE.pink()
        });
        tilePairs.put(Blocks.CONCRETE.blue(), new Block[]{
            Blocks.CONCRETE.lightGray(), Blocks.CONCRETE.gray(), Blocks.CONCRETE.brown(), Blocks.CONCRETE.orange(), Blocks.CONCRETE.yellow(),
            Blocks.CONCRETE.lime(), Blocks.CONCRETE.green(), Blocks.CONCRETE.cyan(), Blocks.CONCRETE.lightBlue(), Blocks.CONCRETE.purple(),
            Blocks.CONCRETE.magenta(), Blocks.CONCRETE.pink()
        });
        tilePairs.put(Blocks.CONCRETE.lightBlue(), new Block[]{
            Blocks.CONCRETE.lightGray(), Blocks.CONCRETE.gray(), Blocks.CONCRETE.brown(), Blocks.CONCRETE.orange(), Blocks.CONCRETE.yellow(),
            Blocks.CONCRETE.lime(), Blocks.CONCRETE.green(), Blocks.CONCRETE.cyan(), Blocks.CONCRETE.purple(),
            Blocks.CONCRETE.magenta(), Blocks.CONCRETE.pink()
        });
        tilePairs.put(Blocks.CONCRETE.green(), new Block[]{
            Blocks.CONCRETE.lightGray(), Blocks.CONCRETE.gray(), Blocks.CONCRETE.brown(), Blocks.CONCRETE.orange(), Blocks.CONCRETE.yellow(),
            Blocks.CONCRETE.lime(), Blocks.CONCRETE.cyan(), Blocks.CONCRETE.purple(), Blocks.CONCRETE.magenta(), Blocks.CONCRETE.pink()
        });
        tilePairs.put(Blocks.CONCRETE.lime(), new Block[]{
            Blocks.CONCRETE.lightGray(), Blocks.CONCRETE.gray(), Blocks.CONCRETE.brown(), Blocks.CONCRETE.orange(), Blocks.CONCRETE.yellow(),
            Blocks.CONCRETE.cyan(), Blocks.CONCRETE.purple(), Blocks.CONCRETE.magenta(), Blocks.CONCRETE.pink()
        });
        tilePairs.put(Blocks.CONCRETE.yellow(), new Block[]{
            Blocks.CONCRETE.lightGray(), Blocks.CONCRETE.gray(), Blocks.CONCRETE.brown(), Blocks.CONCRETE.orange(),
            Blocks.CONCRETE.cyan(), Blocks.CONCRETE.purple(), Blocks.CONCRETE.magenta(), Blocks.CONCRETE.pink()
        });
        tilePairs.put(Blocks.CONCRETE.pink(), new Block[]{
            Blocks.CONCRETE.lightGray(), Blocks.CONCRETE.gray(), Blocks.CONCRETE.brown(), Blocks.CONCRETE.orange(),
            Blocks.CONCRETE.cyan(), Blocks.CONCRETE.purple(), Blocks.CONCRETE.magenta()
        });
        tilePairs.put(Blocks.CONCRETE.purple(), new Block[]{
            Blocks.CONCRETE.lightGray(), Blocks.CONCRETE.gray(), Blocks.CONCRETE.brown(), Blocks.CONCRETE.orange(),
            Blocks.CONCRETE.cyan(), Blocks.CONCRETE.magenta()
        });
        tilePairs.put(Blocks.CONCRETE.magenta(), new Block[]{
            Blocks.CONCRETE.lightGray(), Blocks.CONCRETE.gray(), Blocks.CONCRETE.brown(), Blocks.CONCRETE.orange(), Blocks.CONCRETE.cyan()
        });
        tilePairs.put(Blocks.CONCRETE.orange(), new Block[]{
            Blocks.CONCRETE.lightGray(), Blocks.CONCRETE.gray(), Blocks.CONCRETE.brown(), Blocks.CONCRETE.cyan()
        });
        tilePairs.put(Blocks.CONCRETE.cyan(), new Block[]{
            Blocks.CONCRETE.lightGray(), Blocks.CONCRETE.gray(), Blocks.CONCRETE.brown()
        });
        tilePairs.put(Blocks.CONCRETE.brown(), new Block[]{
            Blocks.CONCRETE.lightGray(), Blocks.CONCRETE.gray()
        });
        tilePairs.put(Blocks.CONCRETE.gray(), new Block[]{
            Blocks.CONCRETE.lightGray()
        });
    }

    static {
        tilePairs.forEach((tile1, tile2List) -> {
            for (Block tile2 : tile2List) {
                ColoredTilesBundle.of(tile1, tile2).register();
            }
        });
    }

    public static List<ColoredTilesBundle> values() {
        return LIST;
    }

    public static ColoredTilesBundle get(Block tile1, Block tile2) {
        for (ColoredTilesBundle bundle : LIST) {
            if (bundle.tile1 == tile1 && bundle.tile2 == tile2) {
                return bundle;
            }
        }
        return null;
    }

    public static Builder of(Block tile1, Block tile2) {
        return new Builder(tile1, tile2);
    }

    public static Block registerCopy(String id, Function<BlockBehaviour.Properties, Block> factory, Block base) {
        return BlockFactory.copy(base).factory(factory).registerColoredTiles(id);
    }

    public static String getColor(Block block) {
        return BuiltInRegistries.BLOCK.getKey(block).getPath().replace("_concrete", "");
    }

    public record Builder(Block tile1, Block tile2) {

        public ColoredTilesBundle register() {
            String type = getColor(tile1) + "_" + getColor(tile2) + "_colored_tiles";

            ColoredTilesBundle bundle = new ColoredTilesBundle(tile1, tile2,
                registerCopy(type, properties -> new ColoredTilesBlock(tile1, tile2, properties), tile2)
            );
            LIST.add(bundle);
            return bundle;
        }
    }
}
