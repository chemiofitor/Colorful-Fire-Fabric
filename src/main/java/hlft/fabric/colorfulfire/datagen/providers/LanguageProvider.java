package hlft.fabric.colorfulfire.datagen.providers;

import hlft.fabric.colorfulfire.init.ColorfulContext;
import hlft.fabric.colorfulfire.init.ColorfulItemTabs;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.block.Block;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.function.BiConsumer;

public class LanguageProvider {
    public static class English extends FabricLanguageProvider {
        public English(FabricDataGenerator dataGenerator) {
            super(dataGenerator);
        }

        @Override
        public void generateTranslations(TranslationBuilder builder) {
            BiConsumer<Block, String> fire = (block, name) -> {
                Identifier identifier = Registry.BLOCK.getId(block);
                builder.add(block, name + " Fire");

                String fireAspectKey = "enchantment." + identifier.getNamespace() + "." + name.toLowerCase() + "_fire_aspect";
                String flameKey = "enchantment." + identifier.getNamespace() + "." + name.toLowerCase() + "_flame";
                builder.add(fireAspectKey, name + " Fire Aspect");
                builder.add(flameKey, name + " Flame");
                builder.add(
                        fireAspectKey + ".desc",
                        "Causes additional " + name.toLowerCase() + " fire damage when used to attack a mob."
                        );
                builder.add(
                        flameKey + ".desc",
                        "Arrows fired from the bow will deal additional " + name.toLowerCase() + " fire damage."
                );

                String inFireKey = "death.attack.in_" + identifier.getNamespace() + "_" + name.toLowerCase() + "_fire";

                builder.add(inFireKey, "%1$s went up in " + name.toLowerCase() + " fire");
                builder.add(inFireKey + ".player",
                        "%1$s walked into " + name.toLowerCase() + " fire whilst fighting %2$s");
            };

            builder.add(ColorfulItemTabs.MAIN, "Colorful Fire");


            for (ColorfulContext value : ColorfulContext.values()) {
                fire.accept(value.getBlock(), value.getName());
            }

        }
    }

    public static class Chinese extends FabricLanguageProvider {
        public Chinese(FabricDataGenerator dataGenerator) {
            super(dataGenerator, "zh_cn");
        }

        @Override
        public void generateTranslations(TranslationBuilder builder) {
            BiConsumer<Block, String> fire = (block, rawString) -> {
                String[] list = rawString.split(":");
                Identifier identifier = Registry.BLOCK.getId(block);
                builder.add(block, list[0] + "之焰");

                String fireAspectKey = "enchantment." + identifier.getNamespace() + "." + list[1].toLowerCase() + "_fire_aspect";
                String flameKey = "enchantment." + identifier.getNamespace() + "." + list[1].toLowerCase() + "_flame";
                builder.add(fireAspectKey, list[0] + "之焰附加");
                builder.add(flameKey, list[0] + "之火矢");
                builder.add(
                        fireAspectKey + ".desc",
                        "击中生物使之附着" + list[0] + "之焰"
                );
                builder.add(
                        flameKey + ".desc",
                        "箭矢击中生物使之附着" + list[0] + "之焰"
                );

                String inFireKey = "death.attack.in_" + identifier.getNamespace() + "_" + list[1].toLowerCase() + "_fire";

                builder.add(inFireKey, "%1$s被" + list[0] + "之焰烧死了");
                builder.add(inFireKey + ".player",
                        "%1$s在与%2$s战斗时不慎走入了" + list[0] + "之焰中");
            };

            builder.add(ColorfulItemTabs.MAIN, "七彩焰");

            for (ColorfulContext value : ColorfulContext.values()) {
                fire.accept(value.getBlock(), value.getNameCh() + ":" + value.getName());
            }
        }
    }
}
