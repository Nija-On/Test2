
package net.mcreator.unitquegems.block;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.storage.loot.LootContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import net.mcreator.unitquegems.itemgroup.UniqueGemsItemGroup;
import net.mcreator.unitquegems.UnitqueGemsModElements;

import java.util.List;
import java.util.Collections;

@UnitqueGemsModElements.ModElement.Tag
public class BlazeRodBlocBlock extends UnitqueGemsModElements.ModElement {
	@ObjectHolder("unitque_gems:blaze_rod_bloc")
	public static final Block block = null;
	public BlazeRodBlocBlock(UnitqueGemsModElements instance) {
		super(instance, 46);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(() -> new BlockItem(block, new Item.Properties().group(UniqueGemsItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}
	public static class CustomBlock extends Block {
		public CustomBlock() {
			super(Block.Properties.create(Material.FIRE).sound(SoundType.GROUND).hardnessAndResistance(1f, 10f).lightValue(0));
			setRegistryName("blaze_rod_bloc");
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(this, 1));
		}
	}
}
