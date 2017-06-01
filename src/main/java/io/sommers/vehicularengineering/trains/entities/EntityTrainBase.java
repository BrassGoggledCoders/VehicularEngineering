package io.sommers.vehicularengineering.trains.entities;

import com.teamacronymcoders.base.entities.EntityMinecartBase;
import net.minecraft.world.World;

public abstract class EntityTrainBase extends EntityMinecartBase {
    public EntityTrainBase(World world) {
        super(world);
    }

    @Override
    public boolean isPoweredCart() {
        return true;
    }
}
