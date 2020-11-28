package net.mcreator.unitquegems.procedures;

import net.minecraft.util.DamageSource;
import net.minecraft.entity.Entity;

import net.mcreator.unitquegems.UnitqueGemsModElements;

import java.util.Map;

@UnitqueGemsModElements.ModElement.Tag
public class BleuFiereProcedure extends UnitqueGemsModElements.ModElement {
	public BleuFiereProcedure(UnitqueGemsModElements instance) {
		super(instance, 56);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure BleuFiere!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		entity.setFire((int) 40);
		for (int index0 = 0; index0 < (int) (15); index0++) {
			entity.attackEntityFrom(DamageSource.ON_FIRE, (float) 1);
		}
	}
}
