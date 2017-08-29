package io.sommers.vehicularengineering.modules.diesel.entities;

import io.sommers.vehicularengineering.modules.diesel.DieselModule;
import io.sommers.vehicularengineering.powersystem.DieselPowerSystem;
import io.sommers.vehicularengineering.powersystem.IPowerSystem;
import io.sommers.vehicularengineering.trains.entities.EntityTrainBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemMinecart;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;
import net.minecraftforge.fluids.capability.IFluidHandler;

import javax.annotation.Nonnull;

public class EntityDieselTrain extends EntityTrainBase {
    private IPowerSystem powerSystem = new DieselPowerSystem();

    public EntityDieselTrain(World world) {
        super(world);
    }

    @Override
    public IPowerSystem getPowerSystem() {
        return powerSystem;
    }

    @Nonnull
    @Override
    public ItemMinecart getItem() {
        return DieselModule.itemDieselTrain;
    }

    @Override
    public boolean processInitialInteract(EntityPlayer player, EnumHand hand)
    {
        if (!this.world.isRemote) {
            IFluidHandler fluidHandler = this.getPowerSystem().getCapability(CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY, null);
            fluidHandler.fill(new FluidStack(FluidRegistry.getFluid("biodiesel"), 1000), true);
        }
        return true;
    }
}
