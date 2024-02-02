package hlft.fabric.colorfulfire;

import hlft.fabric.colorfulfire.init.ColorfulBlocks;
import hlft.fabric.colorfulfire.init.ColorfulItemTabs;
import hlft.fabric.colorfulfire.init.ColorfulItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ColorfulFire implements ModInitializer {
    public static final String MOD_ID = "colorfulfire";
    public static final String MOD_NAME = "Colorful Fire";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_NAME);

    public static boolean isDevelopmentEnvironment = FabricLoader.getInstance().isDevelopmentEnvironment();

    @Override
    public void onInitialize() {
        if (FabricLoader.getInstance().isModLoaded("soulfired")) {
            ColorfulFireCore.init();
        }

        ColorfulBlocks.init();
        ColorfulItems.init();
        ColorfulItemTabs.init();
        LOGGER.info(MOD_NAME + " has loaded!");
    }

    public static Identifier id(String path) {
        return new Identifier(MOD_ID, path);
    }
}
