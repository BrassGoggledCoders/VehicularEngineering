package io.sommers.vehicularengineering.modules.tracks.blocks;

import com.teamacronymcoders.base.Capabilities;
import com.teamacronymcoders.base.blocks.IHasItemBlock;
import com.teamacronymcoders.base.client.models.IHasModel;
import com.teamacronymcoders.base.items.itemblocks.ItemBlockGeneric;
import io.sommers.vehicularengineering.utils.BitUtils;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRailPowered;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;

import static io.sommers.vehicularengineering.modules.tracks.blocks.TrackShapes.FLAT_STRAIGHT_SHAPE;

public class BlockTrackBoarding extends BlockTrackBase {
    public static final PropertyBool POWERED = PropertyBool.create("powered");
    public static final PropertyBool NORTH_WEST = PropertyBool.create("north_west");

    private ItemBlock itemBlock;

    public BlockTrackBoarding() {
        super("boarding");
        this.setDefaultState(this.blockState.getBaseState()
                .withProperty(FLAT_STRAIGHT_SHAPE, EnumRailDirection.NORTH_SOUTH).withProperty(POWERED, false)
                .withProperty(NORTH_WEST, true));
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand,
                                    EnumFacing facing, float hitX, float hitY, float hitZ) {
        if (!world.isRemote) {
            ItemStack itemStack = player.getHeldItem(hand);
            if (itemStack.hasCapability(Capabilities.TOOL, null)) {
                state = state.withProperty(NORTH_WEST, !state.getValue(NORTH_WEST));
                world.setBlockState(pos, state, 4);
            }

            return true;
        }
        return false;
    }

    @Override
    public boolean canMakeSlopes(IBlockAccess world, BlockPos pos) {
        return false;
    }

    @Override
    public void onMinecartPass(World world, EntityMinecart cart, BlockPos pos) {
        IBlockState state = world.getBlockState(pos);
        if (state.getValue(POWERED)) {
            float speedIncrease = .5f;
            if (state.getValue(NORTH_WEST)) {
                speedIncrease *= -1;
            }
            if (state.getValue(FLAT_STRAIGHT_SHAPE) == EnumRailDirection.NORTH_SOUTH) {
                cart.motionZ += speedIncrease;
            } else {
                cart.motionX += speedIncrease;
            }
        } else {
            cart.motionX = 0;
            cart.motionY = 0;
            cart.motionZ = 0;
        }
    }

    @Override
    @ParametersAreNonnullByDefault
    public void neighborChanged(IBlockState state, World world, BlockPos pos, Block blockIn, BlockPos fromPos) {
        boolean isStatePowered = state.getValue(POWERED);
        boolean isWorldPowered = world.isBlockPowered(pos);

        if (isWorldPowered != isStatePowered) {
            world.setBlockState(pos, state.withProperty(POWERED, isWorldPowered), 3);
            world.notifyNeighborsOfStateChange(pos.down(), this, true);
        }
    }

    @Override
    @Nonnull
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, FLAT_STRAIGHT_SHAPE, POWERED, NORTH_WEST);
    }

    @Override
    @Nonnull
    public IBlockState getStateFromMeta(int meta) {
        IBlockState state = this.getDefaultState();
        boolean[] stateArray = BitUtils.getBooleanArrayFromInt(meta, 4);
        state = state.withProperty(FLAT_STRAIGHT_SHAPE, stateArray[0] ? EnumRailDirection.NORTH_SOUTH : EnumRailDirection.EAST_WEST);
        state = state.withProperty(POWERED, stateArray[1]);
        state = state.withProperty(NORTH_WEST, stateArray[2]);
        return state;
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        boolean[] stateArray = new boolean[4];
        stateArray[0] = state.getValue(FLAT_STRAIGHT_SHAPE) == EnumRailDirection.NORTH_SOUTH;
        stateArray[1] = state.getValue(POWERED);
        stateArray[2] = state.getValue(NORTH_WEST);

        return BitUtils.getIntFromBooleanArray(stateArray);
    }
}
