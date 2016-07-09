package xyz.brassgoggledcoders.immersiverailways.modules.diesel;

import xyz.brassgoggledcoders.boilerplate.module.Module;
import xyz.brassgoggledcoders.boilerplate.module.ModuleBase;
import xyz.brassgoggledcoders.boilerplate.registries.ConfigRegistry;
import xyz.brassgoggledcoders.boilerplate.registries.EntityRegistry;
import xyz.brassgoggledcoders.boilerplate.registries.ItemRegistry;
import xyz.brassgoggledcoders.immersiverailways.ImmersiveRailways;
import xyz.brassgoggledcoders.immersiverailways.modules.diesel.entities.EntityDieselLocomotive;
import xyz.brassgoggledcoders.immersiverailways.modules.diesel.items.ItemDieselLocomotive;

@Module(mod = ImmersiveRailways.MODID)
public class ModuleDiesel extends ModuleBase {
	public static ItemDieselLocomotive ITEM_DIESEL_LOCO = new ItemDieselLocomotive();

	@Override
	public String getName() {
		return "Diesel";
	}

	@Override
	public void registerItems(ConfigRegistry configRegistry, ItemRegistry itemRegistry) {
		itemRegistry.registerItem(ITEM_DIESEL_LOCO);
	}

	@Override
	public void registerEntities(ConfigRegistry configRegistry, EntityRegistry entityRegistry) {
		entityRegistry.registerEntity(EntityDieselLocomotive.class);
	}
}
