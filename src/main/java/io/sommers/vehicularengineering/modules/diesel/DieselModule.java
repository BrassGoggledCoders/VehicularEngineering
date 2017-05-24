package io.sommers.vehicularengineering.modules.diesel;

import com.teamacronymcoders.base.modulesystem.Module;
import com.teamacronymcoders.base.modulesystem.ModuleBase;
import com.teamacronymcoders.base.registrysystem.EntityRegistry;
import com.teamacronymcoders.base.registrysystem.ItemRegistry;
import com.teamacronymcoders.base.registrysystem.config.ConfigRegistry;
import io.sommers.vehicularengineering.modules.diesel.entities.EntityDieselBoat;
import io.sommers.vehicularengineering.modules.diesel.items.ItemDieselBoat;

import static io.sommers.vehicularengineering.VehicularEngineering.MODID;

@Module(MODID)
public class DieselModule extends ModuleBase {
    public static ItemDieselBoat itemDieselBoat;

    @Override
    public String getName() {
        return "Diesel";
    }

    public String getClientProxyPath() {
        return "io.sommers.vehicularengineering.modules.diesel.proxies.DieselClientProxy";
    }

    @Override
    public void registerItems(ConfigRegistry configRegistry, ItemRegistry itemRegistry) {
        itemRegistry.register(itemDieselBoat = new ItemDieselBoat());
    }

    @Override
    public void registerEntities(ConfigRegistry configRegistry, EntityRegistry entityRegistry) {
        entityRegistry.register(EntityDieselBoat.class);
    }
}
