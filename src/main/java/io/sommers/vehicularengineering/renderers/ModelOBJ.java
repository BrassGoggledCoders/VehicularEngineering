package io.sommers.vehicularengineering.renderers;

import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.pipeline.LightUtil;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class ModelOBJ {
    private ModelResourceLocation modelLocation;
    private IBakedModel model;

    public ModelOBJ(ResourceLocation resourceLocation) {
        this.modelLocation = new ModelResourceLocation(resourceLocation, "normal");
        ModelOBJHandler.addRenderer(this);
    }

    public void render() {
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder worldRenderer = tessellator.getBuffer();
        worldRenderer.begin(GL11.GL_QUADS, DefaultVertexFormats.ITEM);

        for (BakedQuad bakedquad : model.getQuads(null, null, 0)) {
            LightUtil.renderQuadColor(worldRenderer, bakedquad, -1);
        }

        tessellator.draw();
    }

    public ModelResourceLocation getModelLocation() {
        return modelLocation;
    }

    public void setModel(IBakedModel model) {
        this.model = model;
    }
}
