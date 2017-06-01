package io.sommers.vehicularengineering.renderers;

import com.google.common.collect.Lists;
import com.teamacronymcoders.base.client.models.IHasModel;
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
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.client.model.pipeline.LightUtil;
import org.lwjgl.opengl.GL11;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class EntityModelRenderer<ENTITY extends Entity> extends Render<ENTITY> {
    private ResourceLocation entityTexture;
    private Item item;
    private IBakedModel model;

    public EntityModelRenderer(RenderManager renderManager, IHasModel item) {
        super(renderManager);
        this.item = item.getItem();
        this.entityTexture = item.getModelResourceLocations(Lists.newArrayList()).get(0);
        EntityModelHandler.addRenderer(this);
    }

    @Override
    public void doRender(@Nonnull ENTITY entity, double dx, double dy, double dz, float vanillaYaw, float partialTick) {
        GlStateManager.pushMatrix();
        float yaw = entity.prevRotationYaw +
                MathHelper.wrapDegrees(entity.rotationYaw - entity.prevRotationYaw) * partialTick;
        GlStateManager.translate(dx, dy, dz);
        GlStateManager.rotate(-yaw, 0F, 1F, 0F);
        this.bindEntityTexture(entity);
        renderModel(model);
        GlStateManager.popMatrix();
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

    public Item getItem() {
        return this.item;
    }

    public void setModel(IBakedModel model) {
        this.model = model;
    }
}
