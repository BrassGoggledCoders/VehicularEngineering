package io.sommers.vehicularengineering.modules.diesel;

import com.teamacronymcoders.base.modulesystem.Module;
import com.teamacronymcoders.base.modulesystem.ModuleBase;

import static io.sommers.vehicularengineering.VehicularEngineering.MODID;

@Module(MODID)
public class DieselModule extends ModuleBase {
    @Override
    public String getName() {
        return "Diesel";
    }
}
