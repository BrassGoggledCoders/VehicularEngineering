package xyz.brassgoggledcoders.immersiverailways.modules.diesel.items;

import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import xyz.brassgoggledcoders.boilerplate.entity.minecarts.EntityMinecartBase;
import xyz.brassgoggledcoders.boilerplate.items.minecarts.ItemMinecartBase;
import xyz.brassgoggledcoders.immersiverailways.modules.diesel.entities.EntityDieselLocomotive;

import javax.annotation.Nonnull;

public class ItemDieselLocomotive extends ItemMinecartBase {
	public ItemDieselLocomotive() {
		super("locomotive.diesel");
	}

	@Override
	@Nonnull
	public EntityMinecartBase getEntityFromItem(World world, ItemStack itemStack) {
		return new EntityDieselLocomotive(world);
	}

	@Override
	public String[] getResourceLocations() {
		return new String[] {"locomotive_diesel"};
	}
}
