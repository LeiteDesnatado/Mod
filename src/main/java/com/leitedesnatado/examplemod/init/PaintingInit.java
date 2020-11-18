package com.leitedesnatado.examplemod.init;

import com.leitedesnatado.examplemod.ExampleMod;

import net.minecraft.entity.item.PaintingType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class PaintingInit {

	public static final DeferredRegister<PaintingType> PAINTING_TYPES = new DeferredRegister<PaintingType>(ForgeRegistries.PAINTING_TYPES, ExampleMod.MOD_ID);
	
	public static final RegistryObject<PaintingType> SPACE = PAINTING_TYPES.register("space", 
			() -> new PaintingType(64, 64));
}
