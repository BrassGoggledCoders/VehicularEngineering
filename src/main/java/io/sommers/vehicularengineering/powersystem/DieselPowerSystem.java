package io.sommers.vehicularengineering.powersystem;

import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.fluids.FluidStack;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import java.util.Objects;

import static net.minecraftforge.fluids.capability.CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY;

public class DieselPowerSystem implements IPowerSystem {
    private DieselFluidTank dieselFluidTank = new DieselFluidTank(8000);

    @Override
    public boolean hasPower() {
        return dieselFluidTank.getFluidAmount() > 0;
    }

    @Override
    public int getPower() {
        int power = 0;
        FluidStack drained = dieselFluidTank.drainInternal(100, true);
        if (Objects.nonNull(drained)) {
            if (Objects.nonNull(drained.getFluid())) {
                int time = dieselFluidTank.getFluidBurnTime();
                float percent = drained.amount / 100f;
                power = (int) (time * percent);
            }
        }
        return power;
    }

    @Override
    public boolean hasCapability(@Nonnull Capability<?> capability, @Nullable EnumFacing facing) {
        return capability == FLUID_HANDLER_CAPABILITY;
    }

    @Nullable
    @Override
    public <T> T getCapability(@Nonnull Capability<T> capability, @Nullable EnumFacing facing) {
        return capability == FLUID_HANDLER_CAPABILITY ? FLUID_HANDLER_CAPABILITY.cast(dieselFluidTank) : null;
    }
}
