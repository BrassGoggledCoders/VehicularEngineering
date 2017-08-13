package io.sommers.vehicularengineering.boats.entities;

import net.minecraft.entity.item.EntityBoat;
import net.minecraft.item.Item;
import net.minecraft.world.World;

import javax.annotation.Nonnull;

public abstract class EntityPoweredBoatBase extends EntityBoat {
    public EntityPoweredBoatBase(World worldIn) {
        super(worldIn);
    }

    public EntityPoweredBoatBase(World worldIn, double x, double y, double z) {
        super(worldIn, x, y, z);
    }

    @Override
    @Nonnull
    public abstract Item getItemBoat();
}
