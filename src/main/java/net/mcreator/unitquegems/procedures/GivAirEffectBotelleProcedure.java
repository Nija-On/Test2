package net.mcreator.unitquegems.procedures;

import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.unitquegems.potion.AirEffectPotion;
import net.mcreator.unitquegems.UnitqueGemsModElements;

import java.util.Map;

@UnitqueGemsModElements.ModElement.Tag
public class GivAirEffectBotelleProcedure extends UnitqueGemsModElements.ModElement {
	public GivAirEffectBotelleProcedure(UnitqueGemsModElements instance) {
		super(instance, 29);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure GivAirEffectBotelle!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(AirEffectPotion.potion, (int) 1200, (int) 0));
	}
}
