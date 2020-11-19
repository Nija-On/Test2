package net.mcreator.unitquegems.procedures;

import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.unitquegems.UnitqueGemsModElements;

import java.util.Map;

@UnitqueGemsModElements.ModElement.Tag
public class Resistance1Procedure extends UnitqueGemsModElements.ModElement {
	public Resistance1Procedure(UnitqueGemsModElements instance) {
		super(instance, 4);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure Resistance1!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.RESISTANCE, (int) 1, (int) 1));
	}
}
