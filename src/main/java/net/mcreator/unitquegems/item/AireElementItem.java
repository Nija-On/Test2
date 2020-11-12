
package net.mcreator.unitquegems.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.block.BlockState;

import net.mcreator.unitquegems.itemgroup.UniqueGemsItemGroup;
import net.mcreator.unitquegems.UnitqueGemsModElements;

import java.util.List;

@UnitqueGemsModElements.ModElement.Tag
public class AireElementItem extends UnitqueGemsModElements.ModElement {
	@ObjectHolder("unitque_gems:aire_element")
	public static final Item block = null;
	public AireElementItem(UnitqueGemsModElements instance) {
		super(instance, 26);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(UniqueGemsItemGroup.tab).maxStackSize(1));
			setRegistryName("aire_element");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}

		@Override
		public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
			super.addInformation(itemstack, world, list, flag);
			list.add(new StringTextComponent("Pouvoir de l'air"));
		}
	}
}