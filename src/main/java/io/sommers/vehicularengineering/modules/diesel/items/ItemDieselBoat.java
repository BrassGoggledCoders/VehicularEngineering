package io.sommers.vehicularengineering.modules.diesel.items;

import com.teamacronymcoders.base.items.boats.ItemBoatBase;
import io.sommers.vehicularengineering.modules.diesel.entities.EntityDieselBoat;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.List;

public class ItemDieselBoat extends ItemBoatBase<EntityDieselBoat> {
    public ItemDieselBoat() {
        super("diesel.boat");
    }

    @Override
    public EntityDieselBoat getBoatToPlace(World world, ItemStack itemStack) {
        return new EntityDieselBoat(world);
    }

    @Override
    public List<String> getModelNames(List<String> modelNames) {
        modelNames.add("diesel/boat.obj");
        return modelNames;
    }
}
