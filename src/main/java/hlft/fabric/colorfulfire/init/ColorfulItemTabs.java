package hlft.fabric.colorfulfire.init;

import hlft.fabric.colorfulfire.ColorfulFire;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

import java.util.Objects;
import java.util.stream.Stream;

public class ColorfulItemTabs {
    public static final ItemGroup MAIN = FabricItemGroupBuilder.create(ColorfulFire.id("main"))
            .icon(() -> new ItemStack(ColorfulItems.AQUAMARINE_FIRE))
            .appendItems((list) -> Stream.of(ColorfulItems.class.getDeclaredFields())
                    .map(field -> {
                        try {
                            return field.get(null);
                        } catch (IllegalAccessException e) {
                            return null;
                        }
                    })
                    .filter(Objects::nonNull)
                    .filter(Item.class::isInstance)
                    .map(o -> (Item) o)
                    .forEach(item -> list.add(new ItemStack(item))))
            .build();

    public static void init() {}

    public static Item.Settings settings() {
        return new Item.Settings().group(MAIN);
    }
}
