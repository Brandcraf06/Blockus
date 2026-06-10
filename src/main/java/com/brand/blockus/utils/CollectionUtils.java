package com.brand.blockus.utils;

import net.minecraft.world.level.block.ColorCollection;
import net.minecraft.world.level.block.WeatheringCopperCollection;
import org.apache.commons.lang3.function.TriConsumer;

import java.util.Objects;

public class CollectionUtils {
    public static <T, U, V> void zipApply(ColorCollection<T> first, ColorCollection<U> second, ColorCollection<V> third, TriConsumer<T, U, V> consumer) {
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

    public static <T, U, V, W> void zipApply(ColorCollection<T> first, ColorCollection<U> second, ColorCollection<V> third, ColorCollection<W> fourth, QuadConsumer<T, U, V, W> consumer) {
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

    public static <T, U, V> void zipApply(WeatheringCopperCollection<T> first, WeatheringCopperCollection<U> second, WeatheringCopperCollection<V> third, TriConsumer<T, U, V> consumer) {
        consumer.accept(first.weathering().unaffected(), second.weathering().unaffected(), third.weathering().unaffected());
        consumer.accept(first.weathering().exposed(), second.weathering().exposed(), third.weathering().exposed());
        consumer.accept(first.weathering().weathered(), second.weathering().weathered(), third.weathering().weathered());
        consumer.accept(first.weathering().oxidized(), second.weathering().oxidized(), third.weathering().oxidized());
        consumer.accept(first.waxed().unaffected(), second.waxed().unaffected(), third.waxed().unaffected());
        consumer.accept(first.waxed().exposed(), second.waxed().exposed(), third.waxed().exposed());
        consumer.accept(first.waxed().weathered(), second.waxed().weathered(), third.waxed().weathered());
        consumer.accept(first.waxed().oxidized(), second.waxed().oxidized(), third.waxed().oxidized());
    }

    public static <T, U, V, W> void zipApply(WeatheringCopperCollection<T> first, WeatheringCopperCollection<U> second, WeatheringCopperCollection<V> third, WeatheringCopperCollection<W> fourth, QuadConsumer<T, U, V, W> consumer) {
        consumer.accept(first.weathering().unaffected(), second.weathering().unaffected(), third.weathering().unaffected(), fourth.weathering().unaffected());
        consumer.accept(first.weathering().exposed(), second.weathering().exposed(), third.weathering().exposed(), fourth.weathering().exposed());
        consumer.accept(first.weathering().weathered(), second.weathering().weathered(), third.weathering().weathered(), fourth.weathering().weathered());
        consumer.accept(first.weathering().oxidized(), second.weathering().oxidized(), third.weathering().oxidized(), fourth.weathering().oxidized());
        consumer.accept(first.waxed().unaffected(), second.waxed().unaffected(), third.waxed().unaffected(), fourth.waxed().unaffected());
        consumer.accept(first.waxed().exposed(), second.waxed().exposed(), third.waxed().exposed(), fourth.waxed().exposed());
        consumer.accept(first.waxed().weathered(), second.waxed().weathered(), third.waxed().weathered(), fourth.waxed().weathered());
        consumer.accept(first.waxed().oxidized(), second.waxed().oxidized(), third.waxed().oxidized(), fourth.waxed().oxidized());
    }

    @FunctionalInterface
    public interface QuadConsumer<T, U, V, W> {
        void accept(T var1, U var2, V var3, W var4);

        default QuadConsumer<T, U, V, W> andThen(QuadConsumer<? super T, ? super U, ? super V, ? super W> after) {
            Objects.requireNonNull(after);
            return (t, u, v, w) -> {
                this.accept(t, u, v, w);
                after.accept(t, u, v, w);
            };
        }
    }
}
