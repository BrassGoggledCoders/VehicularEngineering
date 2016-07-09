package xyz.brassgoggledcoders.immersiverailways.modules.diesel.entities;

import net.minecraft.world.World;
import xyz.brassgoggledcoders.boilerplate.entity.minecarts.EntityMinecartBase;
import xyz.brassgoggledcoders.boilerplate.items.minecarts.ItemMinecartBase;
import xyz.brassgoggledcoders.immersiverailways.modules.diesel.ModuleDiesel;

import javax.annotation.Nonnull;

public class EntityDieselLocomotive extends EntityMinecartBase {
	public EntityDieselLocomotive(World world) {
		super(world);
	}

	@Override
	@Nonnull
	public ItemMinecartBase getItem() {
		return ModuleDiesel.ITEM_DIESEL_LOCO;
	}
}
