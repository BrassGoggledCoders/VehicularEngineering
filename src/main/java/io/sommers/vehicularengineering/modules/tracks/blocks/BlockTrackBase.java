package io.sommers.vehicularengineering.modules.tracks.blocks;

import com.teamacronymcoders.base.IBaseMod;
import com.teamacronymcoders.base.blocks.IHasItemBlock;
import com.teamacronymcoders.base.client.models.IHasModel;
import com.teamacronymcoders.base.items.itemblocks.ItemBlockGeneric;
import net.minecraft.block.BlockRailBase;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

import javax.annotation.Nonnull;
import java.util.List;

import static io.sommers.vehicularengineering.modules.tracks.blocks.TrackShapes.FLAT_STRAIGHT_SHAPE;

public abstract class BlockTrackBase extends BlockRailBase implements IHasModel, IHasItemBlock {
    private String name;
    private ItemBlock itemBlock;
    private IBaseMod mod;

    protected BlockTrackBase(String name) {
        this(name, false);
    }

    protected BlockTrackBase(String name, boolean powered) {
        super(powered);
        name += "_rail";
        this.name = name;
        this.setUnlocalizedName(name);
    }

    @Override
    @Nonnull
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, FLAT_STRAIGHT_SHAPE);
    }

    @Override
    @Nonnull
    @SuppressWarnings("deprecation")
    public IBlockState getStateFromMeta(int meta) {
        IBlockState state = this.getDefaultState();
        if (meta != 0) {
            state = state.withProperty(FLAT_STRAIGHT_SHAPE, EnumRailDirection.EAST_WEST);
        }
        return state;
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return state.getValue(FLAT_STRAIGHT_SHAPE) == EnumRailDirection.NORTH_SOUTH ? 0 : 1;
    }

    @Override
    public boolean canMakeSlopes(IBlockAccess world, BlockPos pos) {
        return false;
    }

    @Override
    public boolean isFlexibleRail(IBlockAccess world, BlockPos pos) {
        return false;
    }

    @Override
    @Nonnull
    public IProperty<EnumRailDirection> getShapeProperty() {
        return FLAT_STRAIGHT_SHAPE;
    }

    @Override
    public List<String> getModelNames(List<String> names) {
        names.add(name);
        return names;
    }

    @Override
    public Item getItem() {
        return this.getItemBlock();
    }

    @Override
    public ItemBlock getItemBlock() {
        if (this.itemBlock == null) {
            this.itemBlock = new ItemBlockGeneric<>(this);
        }
        return this.itemBlock;
    }

    @Override
    public IBaseMod getMod() {
        return this.mod;
    }

    @Override
    public void setMod(IBaseMod mod) {
        this.mod = mod;
    }
}
