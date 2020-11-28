
package net.mcreator.unitquegems.block;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.common.ToolType;

import net.minecraft.world.storage.loot.LootContext;
import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.entity.Entity;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import net.mcreator.unitquegems.procedures.PuteOnFireFor1SecondeProcedure;
import net.mcreator.unitquegems.itemgroup.UniqueGemsItemGroup;
import net.mcreator.unitquegems.UnitqueGemsModElements;

import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.Collections;

@UnitqueGemsModElements.ModElement.Tag
public class DirtOfFireBlock extends UnitqueGemsModElements.ModElement {
	@ObjectHolder("unitque_gems:dirt_of_fire")
	public static final Block block = null;
	public DirtOfFireBlock(UnitqueGemsModElements instance) {
		super(instance, 52);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(() -> new BlockItem(block, new Item.Properties().group(UniqueGemsItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}
	public static class CustomBlock extends Block {
		public CustomBlock() {
			super(Block.Properties.create(Material.ROCK).sound(SoundType.GROUND).hardnessAndResistance(2f, 6f).lightValue(0).harvestLevel(2)
					.harvestTool(ToolType.PICKAXE));
			setRegistryName("dirt_of_fire");
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(this, 1));
		}

		@Override
		public void onEntityWalk(World world, BlockPos pos, Entity entity) {
			super.onEntityWalk(world, pos, entity);
			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				PuteOnFireFor1SecondeProcedure.executeProcedure($_dependencies);
			}
		}
	}
}
