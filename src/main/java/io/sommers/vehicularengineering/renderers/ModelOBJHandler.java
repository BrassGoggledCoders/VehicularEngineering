package io.sommers.vehicularengineering.renderers;

import com.google.common.collect.Lists;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraftforge.client.model.IModel;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.model.ModelLoaderRegistry;
import net.minecraftforge.client.model.obj.OBJModel;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.model.TRSRTransformation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

@SideOnly(Side.CLIENT)
public class ModelOBJHandler {
    private static ModelOBJHandler instance;

    private List<ModelOBJ> modelOBJS;

    public static ModelOBJHandler getInstance() {
        if (instance == null) {
            instance = new ModelOBJHandler();
        }
        return instance;
    }

    public ModelOBJHandler() {
        modelOBJS = Lists.newArrayList();
    }

    public static void addRenderer(ModelOBJ modelOBJ) {
        getInstance().modelOBJS.add(modelOBJ);
    }

    public static void setModelsToRenderers() {
        getInstance().modelOBJS.forEach(modelOBJ -> {
            IModel model = ModelLoaderRegistry.getModelOrMissing(modelOBJ.getModelLocation());
            modelOBJ.setModel(model.bake(new OBJModel.OBJState(Lists.newArrayList(OBJModel.Group.ALL),
                    true, new TRSRTransformation(null, null, null, null)),
                    DefaultVertexFormats.ITEM, ModelLoader.defaultTextureGetter()));
        });
    }
}
