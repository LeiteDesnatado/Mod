package com.leitedesnatado.examplemod.util.enums;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

import com.leitedesnatado.examplemod.ExampleMod;
import com.leitedesnatado.examplemod.entity.render.FishyEntityRender;
import com.leitedesnatado.examplemod.entity.render.PenguinEntityRender;
import com.leitedesnatado.examplemod.init.ModEntityTypes;

@Mod.EventBusSubscriber(modid = ExampleMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEventBusSubscriber {

	@SubscribeEvent
	public static void onClientSetup(FMLClientSetupEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.FISHY_ENTITY.get(), FishyEntityRender::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.PENGUIN.get(), PenguinEntityRender::new);

		
	}

}
