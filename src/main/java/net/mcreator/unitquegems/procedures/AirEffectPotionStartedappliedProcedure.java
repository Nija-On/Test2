package net.mcreator.unitquegems.procedures;

import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.unitquegems.potion.AirEffectPotion;
import net.mcreator.unitquegems.UnitqueGemsModElements;

import java.util.Map;
import java.util.Collection;

@UnitqueGemsModElements.ModElement.Tag
public class AirEffectPotionStartedappliedProcedure extends UnitqueGemsModElements.ModElement {
	public AirEffectPotionStartedappliedProcedure(UnitqueGemsModElements instance) {
		super(instance, 28);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure AirEffectPotionStartedapplied!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof PlayerEntity) {
			((PlayerEntity) entity).abilities.isFlying = (new Object() {
				boolean check(Entity _entity) {
					if (_entity instanceof LivingEntity) {
						Collection<EffectInstance> effects = ((LivingEntity) _entity).getActivePotionEffects();
						for (EffectInstance effect : effects) {
							if (effect.getPotion() == AirEffectPotion.potion)
								return true;
						}
					}
					return false;
				}
			}.check(entity));
			((PlayerEntity) entity).sendPlayerAbilities();
		}
	}
}
