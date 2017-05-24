package io.sommers.vehicularengineering.proxies;

import io.sommers.vehicularengineering.renderers.EntityModelHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ClientProxy extends CommonProxy {
    @Override
    public void init() {
        EntityModelHandler.setModelsToRenderers();
    }
}
