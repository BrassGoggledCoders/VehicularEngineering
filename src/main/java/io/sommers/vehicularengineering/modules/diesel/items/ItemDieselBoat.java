package io.sommers.vehicularengineering.modules.diesel.items;

import com.teamacronymcoders.base.items.boats.ItemBoatBase;
import io.sommers.vehicularengineering.modules.diesel.entities.EntityDieselBoat;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemDieselBoat extends ItemBoatBase<EntityDieselBoat> {
    public ItemDieselBoat() {
        super("diesel.boat");
    }

    @Override
    public EntityDieselBoat getBoatToPlace(World world, ItemStack itemStack) {
        return new EntityDieselBoat(world);
    }
}
