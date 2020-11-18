package com.leitedesnatado.examplemod.events;

import com.leitedesnatado.examplemod.ExampleMod;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.ServerChatEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ExampleMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.DEDICATED_SERVER)
public class ModServerClient {
	@SubscribeEvent
	public static void onServerChat(ServerChatEvent event) {
		
	}

}
