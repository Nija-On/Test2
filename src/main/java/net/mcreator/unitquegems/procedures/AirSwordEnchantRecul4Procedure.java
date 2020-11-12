package net.mcreator.unitquegems.procedures;

import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.enchantment.Enchantments;

import net.mcreator.unitquegems.potion.AirEffectLevel2Potion;
import net.mcreator.unitquegems.UnitqueGemsModElements;

import java.util.Map;
import java.util.Collection;

@UnitqueGemsModElements.ModElement.Tag
public class AirSwordEnchantRecul4Procedure extends UnitqueGemsModElements.ModElement {
	public AirSwordEnchantRecul4Procedure(UnitqueGemsModElements instance) {
		super(instance, 32);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure AirSwordEnchantRecul4!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			System.err.println("Failed to load dependency itemstack for procedure AirSwordEnchantRecul4!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		if ((!(((itemstack)).isEnchanted()))) {
			((itemstack)).addEnchantment(Enchantments.PROTECTION, (int) 4);
		}
		if ((new Object() {
			boolean check(LivingEntity _entity) {
				if (_entity instanceof LivingEntity) {
					Collection<EffectInstance> effects = _entity.getActivePotionEffects();
					for (EffectInstance effect : effects) {
						if (effect.getPotion() == AirEffectLevel2Potion.potion)
							return true;
					}
				}
				return false;
			}
		}.check((LivingEntity) entity))) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.HASTE, (int) 2, (int) 4));
		}
	}
}
