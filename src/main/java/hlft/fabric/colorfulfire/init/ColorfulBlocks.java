package hlft.fabric.colorfulfire.init;

import hlft.fabric.colorfulfire.ColorfulFire;
import hlft.fabric.colorfulfire.common.block.ColorfulFireBlock;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.util.registry.Registry;

import java.util.function.Supplier;

public class ColorfulBlocks {
    public static void init() {}

    public static final Block AQUAMARINE_FIRE = register(
             fire(() -> new ColorfulFireBlock(ColorfulFires.AQUAMARINE_FIRE)),
            "aquamarine_fire"
    );

    public static final Block INDIGO_FIRE = register(
            fire(() -> new ColorfulFireBlock(ColorfulFires.INDIGO_FIRE)),
            "indigo_fire"
    );

    public static final Block DARKBLUE_FIRE = register(
            fire(() -> new ColorfulFireBlock(ColorfulFires.DARKBLUE_FIRE)),
            "darkblue_fire"
    );

    public static <T extends ColorfulFireBlock> Supplier<? extends Block> fire(Supplier<T> supplier) {
        return ColorfulFire.isDevelopmentEnvironment ? () -> new Block(AbstractBlock.Settings.of(Material.AIR)) : supplier;
    }

    public static <T extends Block> T register(Supplier<T> supplier, String id) {
        return Registry.register(Registry.BLOCK, ColorfulFire.id(id), supplier.get());
    }
}
