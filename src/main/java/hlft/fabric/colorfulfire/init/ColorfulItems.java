package hlft.fabric.colorfulfire.init;

import hlft.fabric.colorfulfire.ColorfulFire;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.registry.Registry;

import static hlft.fabric.colorfulfire.init.ColorfulItemTabs.settings;

public class ColorfulItems {
    public static void init() {}

    public static final BlockItem AQUAMARINE_FIRE = register(
            new BlockItem(ColorfulBlocks.AQUAMARINE_FIRE, settings()),
            "aquamarine_fire"
    );

    public static final BlockItem INDIGO_FIRE = register(
            new BlockItem(ColorfulBlocks.INDIGO_FIRE, settings()),
            "indigo_fire"
    );

    public static final BlockItem DARKBLUE_FIRE = register(
            new BlockItem(ColorfulBlocks.DARKBLUE_FIRE, settings()),
            "darkblue_fire"
    );

    public static <T extends Item> T register(T object, String id) {
        return Registry.register(Registry.ITEM, ColorfulFire.id(id), object);
    }
}
