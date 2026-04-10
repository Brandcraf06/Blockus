package com.brand.blockus.utils;

import net.minecraft.world.level.block.ColorCollection;
import net.minecraft.world.level.block.WeatheringCopperCollection;
import org.apache.commons.lang3.function.TriConsumer;

public class ColorCollectionUtils {
    public static <T, U, V> void zipApply(final TriConsumer<T, U, V> consumer, final ColorCollection<T> first, final ColorCollection<U> second, final ColorCollection<V> third) {
        consumer.accept(first.white(), second.white(), third.white());
        consumer.accept(first.orange(), second.orange(), third.orange());
        consumer.accept(first.magenta(), second.magenta(), third.magenta());
        consumer.accept(first.lightBlue(), second.lightBlue(), third.lightBlue());
        consumer.accept(first.yellow(), second.yellow(), third.yellow());
        consumer.accept(first.lime(), second.lime(), third.lime());
        consumer.accept(first.pink(), second.pink(), third.pink());
        consumer.accept(first.gray(), second.gray(), third.gray());
        consumer.accept(first.lightGray(), second.lightGray(), third.lightGray());
        consumer.accept(first.cyan(), second.cyan(), third.cyan());
        consumer.accept(first.purple(), second.purple(), third.purple());
        consumer.accept(first.blue(), second.blue(), third.blue());
        consumer.accept(first.brown(), second.brown(), third.brown());
        consumer.accept(first.green(), second.green(), third.green());
        consumer.accept(first.red(), second.red(), third.red());
        consumer.accept(first.black(), second.black(), third.black());
    }

    public static <T, U, V, W> void zipApply(final WeatheringCopperCollection.QuadConsumer<T, U, V, W> consumer, final ColorCollection<T> first, final ColorCollection<U> second, final ColorCollection<V> third, final ColorCollection<W> fourth) {
        consumer.accept(first.white(), second.white(), third.white(), fourth.white());
        consumer.accept(first.orange(), second.orange(), third.orange(), fourth.orange());
        consumer.accept(first.magenta(), second.magenta(), third.magenta(), fourth.magenta());
        consumer.accept(first.lightBlue(), second.lightBlue(), third.lightBlue(), fourth.lightBlue());
        consumer.accept(first.yellow(), second.yellow(), third.yellow(), fourth.yellow());
        consumer.accept(first.lime(), second.lime(), third.lime(), fourth.lime());
        consumer.accept(first.pink(), second.pink(), third.pink(), fourth.pink());
        consumer.accept(first.gray(), second.gray(), third.gray(), fourth.gray());
        consumer.accept(first.lightGray(), second.lightGray(), third.lightGray(), fourth.lightGray());
        consumer.accept(first.cyan(), second.cyan(), third.cyan(), fourth.cyan());
        consumer.accept(first.purple(), second.purple(), third.purple(), fourth.purple());
        consumer.accept(first.blue(), second.blue(), third.blue(), fourth.blue());
        consumer.accept(first.brown(), second.brown(), third.brown(), fourth.brown());
        consumer.accept(first.green(), second.green(), third.green(), fourth.green());
        consumer.accept(first.red(), second.red(), third.red(), fourth.red());
        consumer.accept(first.black(), second.black(), third.black(), fourth.black());
    }
}
