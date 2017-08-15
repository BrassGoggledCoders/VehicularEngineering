package io.sommers.vehicularengineering.proxies;

import io.sommers.vehicularengineering.renderers.ModelOBJHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ClientProxy extends CommonProxy {
    @Override
    public void postInit() {
        ModelOBJHandler.setModelsToRenderers();
    }
}
