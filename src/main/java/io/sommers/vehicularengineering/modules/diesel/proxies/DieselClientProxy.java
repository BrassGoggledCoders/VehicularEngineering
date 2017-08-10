package io.sommers.vehicularengineering.modules.diesel.proxies;

import com.teamacronymcoders.base.modulesystem.proxies.ModuleProxyBase;
import io.sommers.vehicularengineering.modules.diesel.DieselModule;
import io.sommers.vehicularengineering.modules.diesel.entities.EntityDieselBoat;
import io.sommers.vehicularengineering.modules.diesel.entities.EntityDieselTrain;
import io.sommers.vehicularengineering.renderers.EntityModelRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import static io.sommers.vehicularengineering.VehicularEngineering.MODID;

@SideOnly(Side.CLIENT)
public class DieselClientProxy extends ModuleProxyBase {
    @Override
    public void preInit(FMLPreInitializationEvent event) {
        RenderingRegistry.registerEntityRenderingHandler(EntityDieselBoat.class, render -> new EntityModelRenderer<>(render,
                DieselModule.itemDieselBoat, new ResourceLocation(MODID, "textures/diesel/boat.png")));
        RenderingRegistry.registerEntityRenderingHandler(EntityDieselTrain.class, render -> new EntityModelRenderer<>(render,
                DieselModule.itemDieselTrain,new ResourceLocation(MODID, "textures/diesel/train.png")));
    }
}
