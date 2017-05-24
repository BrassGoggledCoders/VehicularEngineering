package io.sommers.vehicularengineering.modules.diesel.renders;

import io.sommers.vehicularengineering.modules.diesel.entities.EntityDieselBoat;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderDieselBoat extends Render<EntityDieselBoat> {
    protected RenderDieselBoat(RenderManager renderManager) {
        super(renderManager);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityDieselBoat entity) {
        return null;
    }
}
