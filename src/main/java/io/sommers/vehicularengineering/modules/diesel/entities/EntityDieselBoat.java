package io.sommers.vehicularengineering.modules.diesel.entities;

import io.sommers.vehicularengineering.boats.EntityPoweredBoatBase;
import net.minecraft.item.Item;
import net.minecraft.world.World;

import javax.annotation.Nonnull;

public class EntityDieselBoat extends EntityPoweredBoatBase {
    public EntityDieselBoat(World worldIn) {
        super(worldIn);
    }

    public EntityDieselBoat(World worldIn, double x, double y, double z) {
        super(worldIn, x, y, z);
    }

    @Nonnull
    @Override
    public Item getItemBoat() {
        return null;
    }
}
