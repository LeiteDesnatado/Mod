package com.leitedesnatado.examplemod.init;

import com.leitedesnatado.examplemod.ExampleMod;
import com.leitedesnatado.examplemod.entities.FishyEntity;
import com.leitedesnatado.examplemod.entities.PenguinEntity;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.FoxEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEntityTypes {
	
	public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = new DeferredRegister<>(ForgeRegistries.ENTITIES, ExampleMod.MOD_ID);
	
	public static final RegistryObject<EntityType<FishyEntity>> FISHY_ENTITY = ENTITY_TYPES.register("fishy_entity",
			() -> EntityType.Builder.<FishyEntity>create(FishyEntity::new, EntityClassification.WATER_CREATURE)
			.size(0.2f, 0.2f)
			.build(new ResourceLocation(ExampleMod.MOD_ID, "fishy_entity").toString()));
	

	
	public static final RegistryObject<EntityType<PenguinEntity>> PENGUIN = ENTITY_TYPES.register("penguin",
			() -> EntityType.Builder.<PenguinEntity>create(PenguinEntity::new, EntityClassification.CREATURE)
			.size(1.0f, 1.0f)
			.build(new ResourceLocation(ExampleMod.MOD_ID, "penguin").toString()));


	

	

}

