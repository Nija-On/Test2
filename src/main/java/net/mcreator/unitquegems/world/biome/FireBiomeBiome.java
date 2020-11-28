
package net.mcreator.unitquegems.world.biome;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.IPlacementConfig;
import net.minecraft.world.gen.placement.FrequencyConfig;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.feature.SeaGrassConfig;
import net.minecraft.world.gen.feature.MultipleRandomFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.biome.Biome;

import net.mcreator.unitquegems.block.StoneOfFireBlock;
import net.mcreator.unitquegems.block.DirtOfFireBlock;
import net.mcreator.unitquegems.UnitqueGemsModElements;

import com.google.common.collect.ImmutableList;

@UnitqueGemsModElements.ModElement.Tag
public class FireBiomeBiome extends UnitqueGemsModElements.ModElement {
	@ObjectHolder("unitque_gems:fire_biome")
	public static final CustomBiome biome = null;
	public FireBiomeBiome(UnitqueGemsModElements instance) {
		super(instance, 55);
	}

	@Override
	public void initElements() {
		elements.biomes.add(() -> new CustomBiome());
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
	}
	static class CustomBiome extends Biome {
		public CustomBiome() {
			super(new Biome.Builder().downfall(0.5f).depth(0.7999999999999999f).scale(0.6f).temperature(2f).precipitation(Biome.RainType.RAIN)
					.category(Biome.Category.NONE).waterColor(-16737895).waterFogColor(-16737895).parent("nether")
					.surfaceBuilder(SurfaceBuilder.DEFAULT, new SurfaceBuilderConfig(DirtOfFireBlock.block.getDefaultState(),
							StoneOfFireBlock.block.getDefaultState(), StoneOfFireBlock.block.getDefaultState())));
			setRegistryName("fire_biome");
			DefaultBiomeFeatures.addCarvers(this);
			DefaultBiomeFeatures.addFossils(this);
			DefaultBiomeFeatures.addMonsterRooms(this);
			DefaultBiomeFeatures.addDeadBushes(this);
			DefaultBiomeFeatures.addStructures(this);
			DefaultBiomeFeatures.addTaigaRocks(this);
			addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(DefaultBiomeFeatures.GRASS_CONFIG)
					.withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(12))));
			this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.SEAGRASS.withConfiguration(new SeaGrassConfig(20, 0.3D))
					.withPlacement(Placement.TOP_SOLID_HEIGHTMAP.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));
			addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
					Feature.RANDOM_SELECTOR
							.withConfiguration(new MultipleRandomFeatureConfig(
									ImmutableList.of(Feature.FANCY_TREE.withConfiguration(DefaultBiomeFeatures.FANCY_TREE_CONFIG).withChance(0.1F)),
									Feature.NORMAL_TREE.withConfiguration(DefaultBiomeFeatures.JUNGLE_TREE_CONFIG)))
							.withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(6, 0.1F, 1))));
		}

		@OnlyIn(Dist.CLIENT)
		@Override
		public int getGrassColor(double posX, double posZ) {
			return -10092544;
		}

		@OnlyIn(Dist.CLIENT)
		@Override
		public int getFoliageColor() {
			return -13408768;
		}

		@OnlyIn(Dist.CLIENT)
		@Override
		public int getSkyColor() {
			return -10079488;
		}
	}
}
