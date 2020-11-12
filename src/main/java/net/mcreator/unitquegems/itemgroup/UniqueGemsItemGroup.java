
package net.mcreator.unitquegems.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.unitquegems.item.ElementTerrePureGemsItem;
import net.mcreator.unitquegems.UnitqueGemsModElements;

@UnitqueGemsModElements.ModElement.Tag
public class UniqueGemsItemGroup extends UnitqueGemsModElements.ModElement {
	public UniqueGemsItemGroup(UnitqueGemsModElements instance) {
		super(instance, 5);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabunique_gems") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(ElementTerrePureGemsItem.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return true;
			}
		}.setBackgroundImageName("item_search.png");
	}
	public static ItemGroup tab;
}
