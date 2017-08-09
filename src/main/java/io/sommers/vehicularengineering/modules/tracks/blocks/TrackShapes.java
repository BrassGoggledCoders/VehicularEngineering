package io.sommers.vehicularengineering.modules.tracks.blocks;

import net.minecraft.block.BlockRailBase.EnumRailDirection;

import com.google.common.base.Predicate;
import net.minecraft.block.properties.PropertyEnum;

public class TrackShapes {
    public static final PropertyEnum<EnumRailDirection> FLAT_STRAIGHT_SHAPE =
            PropertyEnum.create("shape", EnumRailDirection.class, TrackShapes.FLAT_STRAIGHT);

    public static final Predicate<EnumRailDirection> FLAT_STRAIGHT = enumRailDirection ->
            enumRailDirection == EnumRailDirection.EAST_WEST || enumRailDirection == EnumRailDirection.NORTH_SOUTH;
}
