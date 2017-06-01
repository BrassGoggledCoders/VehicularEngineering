package io.sommers.vehicularengineering.modules.diesel.items;

import com.teamacronymcoders.base.entities.EntityMinecartBase;
import io.sommers.vehicularengineering.modules.diesel.entities.EntityDieselTrain;
import io.sommers.vehicularengineering.trains.items.ItemTrainBase;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import javax.annotation.Nonnull;

public class ItemDieselTrain extends ItemTrainBase {
    public ItemDieselTrain() {
        super("diesel");
    }

    @Nonnull
    @Override
    public EntityMinecartBase getEntityFromItem(World world, ItemStack itemStack) {
        return new EntityDieselTrain(world);
    }
}
