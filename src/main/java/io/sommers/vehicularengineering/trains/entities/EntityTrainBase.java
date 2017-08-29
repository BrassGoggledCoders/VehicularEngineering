package io.sommers.vehicularengineering.trains.entities;

import com.teamacronymcoders.base.entities.EntityMinecartBase;
import io.sommers.vehicularengineering.VehicularEngineering;
import io.sommers.vehicularengineering.powersystem.IPowerSystem;
import net.minecraft.entity.MoverType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public abstract class EntityTrainBase extends EntityMinecartBase {
    private double speed;
    private boolean movingForward;
    private int power;

    public EntityTrainBase(World world) {
        super(world);
    }

    public boolean isMovingForward() {
        return movingForward;
    }

    public int getFacing() {
        return 0;
    }

    @Override
    public boolean isPoweredCart() {
        return true;
    }

    public abstract IPowerSystem getPowerSystem();

    @Override
    public void onUpdate() {
        super.onUpdate();

        if (this.power > 0) {
            --this.power;
        } else {
            this.power = this.getPowerSystem().getPower();
        }
    }

    @Override
    public void moveMinecartOnRail(BlockPos pos) {
        double mX = this.motionX;
        double mZ = this.motionZ;

        if (this.power > 0) {
            mX *= 2D;
            mZ *= 2D;
            VehicularEngineering.instance.getLogger().warning("mX: " + mX);
        }

        double max = this.getMaxSpeed();
        mX = MathHelper.clamp(mX, -max, max);
        mZ = MathHelper.clamp(mZ, -max, max);
        this.move(MoverType.SELF, mX, 0.0D, mZ);
    }

}
