package net.mcreator.unitquegems.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.World;
import net.minecraft.potion.EffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.unitquegems.potion.AirEffectLevel2Potion;
import net.mcreator.unitquegems.item.AireArmorItem;
import net.mcreator.unitquegems.UnitqueGemsModElements;

import java.util.Map;
import java.util.HashMap;

@UnitqueGemsModElements.ModElement.Tag
public class AireArmorEffectProcedure extends UnitqueGemsModElements.ModElement {
	public AireArmorEffectProcedure(UnitqueGemsModElements instance) {
		super(instance, 43);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure AireArmorEffect!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double NombreDePieceArmure = 0;
		NombreDePieceArmure = (double) 0;
		if ((((((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.armorInventory.get(3) : ItemStack.EMPTY)
				.getItem() == new ItemStack(AireArmorItem.helmet, (int) (1)).getItem())
				&& (((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.armorInventory.get(2) : ItemStack.EMPTY)
						.getItem() == new ItemStack(AireArmorItem.body, (int) (1)).getItem()))
				&& ((((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.armorInventory.get(1) : ItemStack.EMPTY)
						.getItem() == new ItemStack(AireArmorItem.legs, (int) (1)).getItem())
						&& (((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.armorInventory.get(0) : ItemStack.EMPTY)
								.getItem() == new ItemStack(AireArmorItem.boots, (int) (1)).getItem())))) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(AirEffectLevel2Potion.potion, (int) 2, (int) 0));
		}
	}

	@SubscribeEvent
	public void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			Entity entity = event.player;
			World world = entity.world;
			double i = entity.getPosX();
			double j = entity.getPosY();
			double k = entity.getPosZ();
			Map<String, Object> dependencies = new HashMap<>();
			dependencies.put("x", i);
			dependencies.put("y", j);
			dependencies.put("z", k);
			dependencies.put("world", world);
			dependencies.put("entity", entity);
			dependencies.put("event", event);
			this.executeProcedure(dependencies);
		}
	}
}
