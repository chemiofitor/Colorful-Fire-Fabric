package hlft.fabric.colorfulfire.common.block;

import crystalspider.soulfired.api.Fire;
import crystalspider.soulfired.api.FireManager;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.AbstractFireBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;

public class ColorfulFireBlock extends AbstractFireBlock {
    private final Fire fire;

    public ColorfulFireBlock(Fire fire) {
        super(setting(fire), fire.getDamage());
        this.fire = fire;
    }

    public static AbstractBlock.Settings setting(Fire fire) {
        if (fire.getFireType() == FireManager.SOUL_FIRE_TYPE) {
            return Settings.copy(Blocks.SOUL_FIRE);
        }else {
            return Settings.copy(Blocks.FIRE);
        }
    }

    @Override
    protected boolean isFlammable(BlockState state) {
        return true;
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState();
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        return this.canPlaceAt(state, world, pos) ? this.getDefaultState() : Blocks.AIR.getDefaultState();
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        return true;
    }

    @Override
    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        if (!entity.isFireImmune()) {
            Identifier fireType= fire.getFireType();
            entity.setFireTicks(entity.getFireTicks() + 1);

            FireManager.setOnFire(entity, 8, fireType);
            FireManager.damageInFire(entity, fireType);
        }
    }
}
