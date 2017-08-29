package io.sommers.vehicularengineering.powersystem;

import net.minecraftforge.common.capabilities.ICapabilityProvider;

public interface IPowerSystem extends ICapabilityProvider {
    boolean hasPower();

    int getPower();
}
