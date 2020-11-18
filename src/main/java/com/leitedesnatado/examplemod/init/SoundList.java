package com.leitedesnatado.examplemod.init;

import com.leitedesnatado.examplemod.ExampleMod;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.common.util.Lazy;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class SoundList {

	public static final DeferredRegister<SoundEvent> SOUNDS = new DeferredRegister<>(ForgeRegistries.SOUND_EVENTS, ExampleMod.MOD_ID);
		
	public static final Lazy<SoundEvent> RICK_LAZY = Lazy
			.of(() -> new SoundEvent(new ResourceLocation(ExampleMod.MOD_ID, "item.rick_disc")));
	
	public static final RegistryObject<SoundEvent> RICK_DISC = SOUNDS.register("item.rick_disc.disc", RICK_LAZY);
}
