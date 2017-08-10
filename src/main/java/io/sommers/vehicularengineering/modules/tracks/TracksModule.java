package io.sommers.vehicularengineering.modules.tracks;

import com.teamacronymcoders.base.modulesystem.Module;
import com.teamacronymcoders.base.modulesystem.ModuleBase;
import com.teamacronymcoders.base.registrysystem.BlockRegistry;
import com.teamacronymcoders.base.registrysystem.config.ConfigRegistry;
import io.sommers.vehicularengineering.modules.tracks.blocks.BlockTrackBoarding;
import io.sommers.vehicularengineering.modules.tracks.blocks.BlockTrackCrossing;

import static io.sommers.vehicularengineering.VehicularEngineering.MODID;

@Module(MODID)
public class TracksModule extends ModuleBase {
    @Override
    public String getName() {
        return "Tracks";
    }

    @Override
    public void registerBlocks(ConfigRegistry config, BlockRegistry block) {
        block.register(new BlockTrackCrossing());
        block.register(new BlockTrackBoarding());
    }
}
