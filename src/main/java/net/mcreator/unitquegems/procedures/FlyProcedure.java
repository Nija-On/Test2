package net.mcreator.unitquegems.procedures;

import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.unitquegems.potion.AirEffectPotion;
import net.mcreator.unitquegems.UnitqueGemsModElements;

import java.util.Map;

@UnitqueGemsModElements.ModElement.Tag
public class FlyProcedure extends UnitqueGemsModElements.ModElement {
	public FlyProcedure(UnitqueGemsModElements instance) {
		super(instance, 45);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure Fly!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(AirEffectPotion.potion, (int) 20, (int) 0, (false), (false)));
	}
}
