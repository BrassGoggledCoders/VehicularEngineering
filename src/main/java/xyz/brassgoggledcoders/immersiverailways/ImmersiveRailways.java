package xyz.brassgoggledcoders.immersiverailways;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import xyz.brassgoggledcoders.boilerplate.BoilerplateModBase;

@Mod(modid = ImmersiveRailways.MODID, name = ImmersiveRailways.NAME, version = ImmersiveRailways.VERSION)
public class ImmersiveRailways extends BoilerplateModBase {
	public static final String MODID = "immersiverailways";
	public static final String NAME = "Immersive Railways";
	public static final String VERSION = "@VERSION@";

	@Instance(ImmersiveRailways.MODID)
	public static ImmersiveRailways INSTANCE;

	public ImmersiveRailways() {
		super(MODID, NAME, VERSION, CreativeTabs.TRANSPORTATION);
	}

	@Override
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		super.preInit(event);
	}

	@Override
	@EventHandler
	public void init(FMLInitializationEvent event) {
		super.init(event);
	}

	@Override
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		super.postInit(event);
	}

	@Override
	public boolean addOBJDomain() {
		return true;
	}

	@Override
	public Object getInstance() {
		return INSTANCE;
	}
}
