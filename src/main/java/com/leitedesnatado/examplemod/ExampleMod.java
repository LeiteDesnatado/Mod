package com.leitedesnatado.examplemod;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.leitedesnatado.examplemod.init.BiomeInit;
import com.leitedesnatado.examplemod.init.EnchantmentInit;
import com.leitedesnatado.examplemod.init.ModBlocks;
import com.leitedesnatado.examplemod.init.ModEntityTypes;
import com.leitedesnatado.examplemod.init.ModItems;
import com.leitedesnatado.examplemod.init.PaintingInit;
import com.leitedesnatado.examplemod.init.SoundList;


@Mod("examplemod")
@Mod.EventBusSubscriber(modid = ExampleMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ExampleMod
{
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "examplemod";
    public static ExampleMod instance;


    public ExampleMod() {      
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);
        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
		modEventBus.addListener(this::setup);

        MinecraftForge.EVENT_BUS.register(this);
        ModBlocks.BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ModItems.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ModEntityTypes.ENTITY_TYPES.register(FMLJavaModLoadingContext.get().getModEventBus());
       BiomeInit.BIOMES.register(FMLJavaModLoadingContext.get().getModEventBus());
       PaintingInit.PAINTING_TYPES.register(FMLJavaModLoadingContext.get().getModEventBus());
       SoundList.SOUNDS.register(FMLJavaModLoadingContext.get().getModEventBus());
       EnchantmentInit.ENCHANTMENTS.register(FMLJavaModLoadingContext.get().getModEventBus());
       
       
    }

    @SubscribeEvent
    public static void onRegisterBiomes(final RegistryEvent.Register<Biome> event) {
    	BiomeInit.registerBiomes();
    }
    private void setup(final FMLCommonSetupEvent event)
    {
    	DeferredWorkQueue.runLater(() -> {
            GlobalEntityTypeAttributes.put(ModEntityTypes.PENGUIN.get(), PenguinEntity.setCustomAttributes().create());
        });
    }

    private void doClientStuff(final FMLClientSetupEvent event) { 
    	
    }
    
    public static final ItemGroup TAB = new ItemGroup("testab") {
    	@Override 
    	public ItemStack createIcon() {
    		return new ItemStack(ModItems.RUBY.get());
    	}
    };
}
