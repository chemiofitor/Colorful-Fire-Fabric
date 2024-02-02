package hlft.fabric.colorfulfire.client;

import hlft.fabric.colorfulfire.init.ColorfulBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.block.Block;
import net.minecraft.client.render.RenderLayer;

import java.util.Objects;
import java.util.stream.Stream;

public class ColorfulFireClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        Stream.of(ColorfulBlocks.class.getDeclaredFields())
                .map(field -> {
                    try {
                        return field.get(null);
                    } catch (IllegalAccessException e) {
                        return null;
                    }
                })
                .filter(Objects::nonNull)
                .filter(Block.class::isInstance)
                .map(o -> (Block) o)
                .forEach(block -> BlockRenderLayerMap.INSTANCE.putBlock(block, RenderLayer.getCutout()));
    }
}
