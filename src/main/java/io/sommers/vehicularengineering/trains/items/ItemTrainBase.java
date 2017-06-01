package io.sommers.vehicularengineering.trains.items;

import com.teamacronymcoders.base.items.minecarts.ItemMinecartBase;

import java.util.List;

public abstract class ItemTrainBase extends ItemMinecartBase {
    private String typeName;
    public ItemTrainBase(String typeName) {
        super("train." + typeName);
        this.typeName = typeName;
    }

    @Override
    public List<String> getModelNames(List<String> modelNames) {
        modelNames.add(this.typeName + "/train.obj");
        return modelNames;
    }
}
