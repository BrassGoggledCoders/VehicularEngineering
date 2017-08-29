package io.sommers.vehicularengineering.powersystem;

import blusunrize.immersiveengineering.api.energy.DieselHandler;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTank;

import java.util.Objects;

public class DieselFluidTank extends FluidTank {
    private int burnTime = 0;

    public DieselFluidTank(int capacity) {
        super(capacity);
    }

    public int getFluidBurnTime() {
        return burnTime;
    }

    @Override
    public int fillInternal(FluidStack resource, boolean doFill) {
        if (Objects.nonNull(this.getFluid()) && Objects.nonNull(resource)) {
            burnTime = DieselHandler.getBurnTime(resource.getFluid());
        }
        return super.fillInternal(resource, doFill);
    }

    @Override
    public boolean canFillFluidType(FluidStack fluid) {
        return fluid != null && DieselHandler.isValidFuel(fluid.getFluid());
    }

    @Override
    public boolean canDrain() {
        return false;
    }
}
