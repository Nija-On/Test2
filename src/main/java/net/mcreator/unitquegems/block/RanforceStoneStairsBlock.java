
package net.mcreator.unitquegems.block;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.storage.loot.LootContext;
import net.minecraft.world.IBlockReader;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.block.material.Material;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import net.mcreator.unitquegems.itemgroup.UniqueGemsItemGroup;
import net.mcreator.unitquegems.UnitqueGemsModElements;

import java.util.List;
import java.util.Collections;

@UnitqueGemsModElements.ModElement.Tag
public class RanforceStoneStairsBlock extends UnitqueGemsModElements.ModElement {
	@ObjectHolder("unitque_gems:ranforce_stone_stairs")
	public static final Block block = null;
	public RanforceStoneStairsBlock(UnitqueGemsModElements instance) {
		super(instance, 19);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(() -> new BlockItem(block, new Item.Properties().group(UniqueGemsItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}
	public static class CustomBlock extends StairsBlock {
		public CustomBlock() {
			super(new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(15f, 12f)).getDefaultState(),
					Block.Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(15f, 12f).lightValue(0).harvestLevel(3)
							.harvestTool(ToolType.PICKAXE));
			setRegistryName("ranforce_stone_stairs");
		}

		@Override
		@OnlyIn(Dist.CLIENT)
		public void addInformation(ItemStack itemstack, IBlockReader world, List<ITextComponent> list, ITooltipFlag flag) {
			super.addInformation(itemstack, world, list, flag);
			list.add(new StringTextComponent("10 Fois plus r\u00E9sitant aux pioche"));
			list.add(new StringTextComponent("diament n\u00E9s\u00E9saire"));
			list.add(new StringTextComponent("et 2 fois plus r\u00E9sistant au explosion."));
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(this, 0));
		}
	}
}
