package net.mcreator.unitquegems.procedures;

import net.minecraft.entity.Entity;

import net.mcreator.unitquegems.UnitqueGemsModElements;

import java.util.Map;

@UnitqueGemsModElements.ModElement.Tag
public class PuteOnFireFor1SecondeProcedure extends UnitqueGemsModElements.ModElement {
	public PuteOnFireFor1SecondeProcedure(UnitqueGemsModElements instance) {
		super(instance, 53);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure PuteOnFireFor1Seconde!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		entity.setFire((int) 1);
	}
}
