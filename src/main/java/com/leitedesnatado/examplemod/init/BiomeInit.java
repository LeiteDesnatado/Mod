package com.leitedesnatado.examplemod.init;

import com.leitedesnatado.examplemod.ExampleMod;
import com.leitedesnatado.examplemod.world.biomes.Biomy;

import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.Category;
import net.minecraft.world.biome.Biome.RainType;
import net.minecraft.world.biome.BiomeManager;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraft.world.biome.BiomeManager;

public class BiomeInit {

	public static final DeferredRegister<Biome> BIOMES  = DeferredRegister.create(ForgeRegistries.BIOMES, ExampleMod.MOD_ID);
	
	public static final RegistryObject<Biome> BIOMY = BIOMES.register("biomy",
			() -> new Biomy(
					new Biome.Builder().precipitation(RainType.RAIN).scale(1.2f).temperature(0.0f)
							.waterColor(12921600).waterFogColor(12921684)
							.surfaceBuilder(SurfaceBuilder.DEFAULT,
									new SurfaceBuilderConfig(Blocks.GRASS_BLOCK.getDefaultState(),
											Blocks.COARSE_DIRT.getDefaultState(),
											Blocks.DIAMOND_BLOCK.getDefaultState()))
							.category(Category.JUNGLE)
							.downfall(0.25f)
							.depth(1.0f)
							.parent(null)));
	

	public static void registerBiomes() {
		registerBiome(BIOMY.get(), Type.PLAINS, Type.OVERWORLD);
	}

	private static void registerBiome(Biome biome, Type... types) {
		BiomeDictionary.addTypes(biome, types);
		
	}
}

