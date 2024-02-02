package hlft.fabric.colorfulfire.datagen;

import hlft.fabric.colorfulfire.datagen.providers.LanguageProvider;
import hlft.fabric.colorfulfire.datagen.providers.ModelProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class ColorFireDataGen implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator generator) {
        generator.addProvider(LanguageProvider.English::new);
        generator.addProvider(LanguageProvider.Chinese::new);
        generator.addProvider(ModelProvider::new);
    }
}
