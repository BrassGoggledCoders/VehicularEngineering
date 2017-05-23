package io.sommers.vehicularengineering;

import com.teamacronymcoders.base.BaseModFoundation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;

import static io.sommers.vehicularengineering.VehicularEngineering.*;

@Mod(modid = MODID, name = MODNAME, version = VERSION, dependencies = DEPENDS)
public class VehicularEngineering extends BaseModFoundation<VehicularEngineering> {
    public static final String MODID = "vehicularengineering";
    public static final String MODNAME = "Vehicular Engineering";
    public static final String VERSION = "@VERSION@";
    public static final String DEPENDS = "required-after:base@[0.0.0,);";

    @Mod.Instance(MODID)
    public static VehicularEngineering instance;

    public VehicularEngineering() {
        super(MODID, MODNAME, VERSION, CreativeTabs.TRANSPORTATION);
    }

    @EventHandler
    @Override
    public void preInit(FMLPreInitializationEvent event) {
        super.preInit(event);
    }

    @EventHandler
    @Override
    public void init(FMLInitializationEvent event) {
        super.init(event);
    }

    @EventHandler
    @Override
    public void postInit(FMLPostInitializationEvent event) {
        super.postInit(event);
    }

    @Override
    public boolean addOBJDomain() {
        return true;
    }

    @Override
    public VehicularEngineering getInstance() {
        return this;
    }
}
