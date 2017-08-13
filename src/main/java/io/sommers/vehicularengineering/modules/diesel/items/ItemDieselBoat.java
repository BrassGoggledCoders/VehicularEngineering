package io.sommers.vehicularengineering.modules.diesel.items;

import io.sommers.vehicularengineering.boats.items.ItemPoweredBoatBase;
import io.sommers.vehicularengineering.modules.diesel.entities.EntityDieselBoat;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemDieselBoat extends ItemPoweredBoatBase<EntityDieselBoat> {
    public ItemDieselBoat() {
        super("diesel");
    }

    @Override
    public EntityDieselBoat getBoatToPlace(World world, ItemStack itemStack) {
        return new EntityDieselBoat(world);
    }
}
