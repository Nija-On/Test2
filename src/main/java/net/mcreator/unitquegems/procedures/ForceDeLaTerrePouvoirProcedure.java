package net.mcreator.unitquegems.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.World;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.unitquegems.item.ArmuredeTerreItem;
import net.mcreator.unitquegems.UnitqueGemsModElements;

import java.util.Map;
import java.util.HashMap;

@UnitqueGemsModElements.ModElement.Tag
public class ForceDeLaTerrePouvoirProcedure extends UnitqueGemsModElements.ModElement {
	public ForceDeLaTerrePouvoirProcedure(UnitqueGemsModElements instance) {
		super(instance, 12);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure ForceDeLaTerrePouvoir!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double ForceDeLaTerrePouvoir = 0;
		ForceDeLaTerrePouvoir = (double) 0;
		if ((((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.armorInventory.get(0) : ItemStack.EMPTY)
				.getItem() == new ItemStack(ArmuredeTerreItem.boots, (int) (1)).getItem())) {
			ForceDeLaTerrePouvoir = (double) ((ForceDeLaTerrePouvoir) + 1);
		}
		if ((((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.armorInventory.get(1) : ItemStack.EMPTY)
				.getItem() == new ItemStack(ArmuredeTerreItem.legs, (int) (1)).getItem())) {
			ForceDeLaTerrePouvoir = (double) ((ForceDeLaTerrePouvoir) + 1);
		}
		if ((((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.armorInventory.get(2) : ItemStack.EMPTY)
				.getItem() == new ItemStack(ArmuredeTerreItem.body, (int) (1)).getItem())) {
			ForceDeLaTerrePouvoir = (double) ((ForceDeLaTerrePouvoir) + 1);
		}
		if ((((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.armorInventory.get(3) : ItemStack.EMPTY)
				.getItem() == new ItemStack(ArmuredeTerreItem.helmet, (int) (1)).getItem())) {
			ForceDeLaTerrePouvoir = (double) ((ForceDeLaTerrePouvoir) + 1);
		}
		if (((ForceDeLaTerrePouvoir) == 1)) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.RESISTANCE, (int) 1, (int) 0));
		}
		if (((ForceDeLaTerrePouvoir) == 2)) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.RESISTANCE, (int) 1, (int) 1));
		}
		if (((ForceDeLaTerrePouvoir) == 3)) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.RESISTANCE, (int) 1, (int) 2));
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SLOWNESS, (int) 1, (int) 0));
		}
		if (((ForceDeLaTerrePouvoir) == 4)) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.RESISTANCE, (int) 1, (int) 3));
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SLOWNESS, (int) 1, (int) 0));
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
