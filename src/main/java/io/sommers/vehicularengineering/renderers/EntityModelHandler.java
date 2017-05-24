package io.sommers.vehicularengineering.renderers;

import com.google.common.collect.Lists;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelManager;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraftforge.client.event.ModelBakeEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

@SideOnly(Side.CLIENT)
public class EntityModelHandler {
    private static EntityModelHandler instance;

    private ModelManager modelManager;
    private List<EntityModelRenderer> entityModelRenderers;

    public static EntityModelHandler getInstance() {
        if (instance == null) {
            instance = new EntityModelHandler();
        }
        return instance;
    }

    public EntityModelHandler() {
        entityModelRenderers = Lists.newArrayList();
    }

    public static void addRenderer(EntityModelRenderer entityEntityModelRenderer) {
        getInstance().entityModelRenderers.add(entityEntityModelRenderer);
    }

    @SubscribeEvent
    public void onModelBakeEvent(ModelBakeEvent event){
        modelManager = event.getModelManager();
    }

    public static void setModelsToRenderers() {
        getInstance().entityModelRenderers.forEach(entityModelRenderer ->
                getInstance().modelManager.getModel(new ModelResourceLocation(entityModelRenderer.getModelLocation().toString())));
    }
}
