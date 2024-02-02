package hlft.fabric.colorfulfire.datagen.providers;

import hlft.fabric.colorfulfire.init.ColorfulContext;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Block;
import net.minecraft.data.client.*;
import net.minecraft.item.BlockItem;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.function.Consumer;

public class ModelProvider extends FabricModelProvider {
    public ModelProvider(FabricDataGenerator dataGenerator) {
        super(dataGenerator);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator generator) {
        Consumer<Block> fire = (block) -> {
            List<Identifier> list = generator.getFireFloorModels(block);
            List<Identifier> list2 = generator.getFireSideModels(block);
            generator.blockStateCollector.accept(
                    MultipartBlockStateSupplier.create(block).with(BlockStateModelGenerator.buildBlockStateVariants(list, blockStateVariant -> blockStateVariant)).with(BlockStateModelGenerator.buildBlockStateVariants(list2, blockStateVariant -> blockStateVariant)).with(BlockStateModelGenerator.buildBlockStateVariants(list2, blockStateVariant -> blockStateVariant.put(VariantSettings.Y, VariantSettings.Rotation.R90))).with(BlockStateModelGenerator.buildBlockStateVariants(list2, blockStateVariant -> blockStateVariant.put(VariantSettings.Y, VariantSettings.Rotation.R180))).with(BlockStateModelGenerator.buildBlockStateVariants(list2, blockStateVariant -> blockStateVariant.put(VariantSettings.Y, VariantSettings.Rotation.R270)))
            );
        };

        for (ColorfulContext value : ColorfulContext.values()) {
            fire.accept(value.getBlock());
        }
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        Consumer<BlockItem> fire = ((blockItem) -> Models.GENERATED.upload(
                ModelIds.getItemModelId(blockItem),
                TextureMap.layer0(TextureMap.getSubId(blockItem.getBlock(), "_0")),
                itemModelGenerator.writer
        ));

        for (ColorfulContext value : ColorfulContext.values()) {
            if (value.getBlock().asItem() instanceof BlockItem blockItem)
                fire.accept(blockItem);
        }
    }
}
