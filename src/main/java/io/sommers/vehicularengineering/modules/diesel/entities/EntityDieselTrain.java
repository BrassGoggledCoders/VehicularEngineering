package io.sommers.vehicularengineering.modules.diesel.entities;

import io.sommers.vehicularengineering.modules.diesel.DieselModule;
import io.sommers.vehicularengineering.trains.entities.EntityTrainBase;
import net.minecraft.item.ItemMinecart;
import net.minecraft.world.World;

import javax.annotation.Nonnull;

public class EntityDieselTrain extends EntityTrainBase {
    public EntityDieselTrain(World world) {
        super(world);
    }

    @Nonnull
    @Override
    public ItemMinecart getItem() {
        return DieselModule.itemDieselTrain;
    }
}
