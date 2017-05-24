package io.sommers.vehicularengineering.renderers;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.VertexBuffer;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.client.model.pipeline.LightUtil;
import org.lwjgl.opengl.GL11;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class EntityModelRenderer<ENTITY extends Entity> extends Render<ENTITY> {
    private ResourceLocation entityTexture;
    private ResourceLocation modelLocation;
    private IBakedModel model;

    public EntityModelRenderer(RenderManager renderManager, ResourceLocation modelLocation, ResourceLocation entityTexture) {
        super(renderManager);
        this.modelLocation = modelLocation;
        this.entityTexture = entityTexture;
        EntityModelHandler.addRenderer(this);
    }

    @Override
    public void doRender(@Nonnull ENTITY entity, double dx, double dy, double dz, float vanillaYaw, float partialTick) {
        float yaw = entity.prevRotationYaw +
                MathHelper.wrapDegrees(entity.rotationYaw - entity.prevRotationYaw) * partialTick;
        GlStateManager.translate(dx, dy, dz);
        GlStateManager.rotate(-yaw, 0F, 1F, 0F);
        bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
        renderModel(model);
    }

    private void renderModel(IBakedModel model) {
        Tessellator tessellator = Tessellator.getInstance();
        VertexBuffer worldRenderer = tessellator.getBuffer();
        worldRenderer.begin(GL11.GL_QUADS, DefaultVertexFormats.ITEM);

        for (BakedQuad bakedquad : model.getQuads(null, null, 0)) {
            LightUtil.renderQuadColor(worldRenderer, bakedquad, -1);
        }

        tessellator.draw();
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(@Nonnull ENTITY entity) {
        return this.entityTexture;
    }

    public ResourceLocation getTextureLocation() {
        return this.entityTexture;
    }

    public ResourceLocation getModelLocation() {
        return this.modelLocation;
    }

    public void setModel(IBakedModel model) {
        this.model = model;
    }
}
