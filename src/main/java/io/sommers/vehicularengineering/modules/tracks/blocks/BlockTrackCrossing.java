package io.sommers.vehicularengineering.modules.tracks.blocks;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class BlockTrackCrossing extends BlockTrackBase {
    public BlockTrackCrossing() {
        super("crossing");
    }

    @Override
    @Nonnull
    public EnumRailDirection getRailDirection(IBlockAccess world, BlockPos pos, IBlockState state, @Nullable EntityMinecart cart) {
        if (cart != null) {
            EnumFacing cartFacing = cart.getHorizontalFacing();
            if (cartFacing == EnumFacing.NORTH || cartFacing == EnumFacing.SOUTH) {
                return EnumRailDirection.EAST_WEST;
            }
        }
        return EnumRailDirection.NORTH_SOUTH;
    }
}
