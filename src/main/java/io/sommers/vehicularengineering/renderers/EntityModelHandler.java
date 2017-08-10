package io.sommers.vehicularengineering.renderers;

import com.google.common.collect.Lists;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ModelManager;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.ModelBakeEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

@SideOnly(Side.CLIENT)
public class EntityModelHandler {
    private static EntityModelHandler instance;

    private List<EntityModelRenderer> entityModelRenderers;

    public static EntityModelHandler getInstance() {
        if (instance == null) {
            instance = new EntityModelHandler();
        }
        return instance;
    }

    public EntityModelHandler() {
        entityModelRenderers = Lists.newArrayList();
        MinecraftForge.EVENT_BUS.register(this);
    }

    public static void addRenderer(EntityModelRenderer entityEntityModelRenderer) {
        getInstance().entityModelRenderers.add(entityEntityModelRenderer);
    }

    public static void setModelsToRenderers() {
        getInstance().entityModelRenderers.forEach(entityModelRenderer -> {
            IBakedModel model = Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
                    .getItemModel(new ItemStack(entityModelRenderer.getItem()));
            entityModelRenderer.setModel(model);
        });
    }
}
