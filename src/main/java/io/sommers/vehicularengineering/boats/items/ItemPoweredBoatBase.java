package io.sommers.vehicularengineering.boats.items;

import com.teamacronymcoders.base.items.boats.ItemBoatBase;
import io.sommers.vehicularengineering.boats.entities.EntityPoweredBoatBase;

import java.util.List;

public abstract class ItemPoweredBoatBase<BOAT extends EntityPoweredBoatBase> extends ItemBoatBase<BOAT> {
    private String powerType;

    public ItemPoweredBoatBase(String powerType) {
        super(powerType + "_boat");
        this.powerType = powerType;
    }

    @Override
    public List<String> getModelNames(List<String> modelNames) {
        modelNames.add("vehicles/" + this.powerType + "_boat");
        return modelNames;
    }
}
