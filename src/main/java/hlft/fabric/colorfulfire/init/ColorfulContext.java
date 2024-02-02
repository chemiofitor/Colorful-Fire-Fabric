package hlft.fabric.colorfulfire.init;

import net.minecraft.block.Block;

public enum ColorfulContext {
    AQUAMARINE("Aquamarine", "青", ColorfulBlocks.AQUAMARINE_FIRE),
    INDIGO("Indigo", "靛", ColorfulBlocks.INDIGO_FIRE),
    DARKBLUE("Darkblue", "深蓝", ColorfulBlocks.DARKBLUE_FIRE);

    private final String name;
    private final String nameCh;
    private final Block block;

    ColorfulContext(String name, String nameCh, Block block) {
        this.name = name;
        this.nameCh = nameCh;
        this.block = block;
    }

    public String getName() {
        return name;
    }

    public Block getBlock() {
        return block;
    }

    public String getNameCh() {
        return nameCh;
    }
}
