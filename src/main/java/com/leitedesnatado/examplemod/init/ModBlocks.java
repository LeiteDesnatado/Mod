package com.leitedesnatado.examplemod.init;

import com.leitedesnatado.examplemod.ExampleMod;
import com.leitedesnatado.examplemod.objects.blocks.Oven;
import com.leitedesnatado.examplemod.objects.blocks.RubyBlock;
import com.leitedesnatado.examplemod.objects.blocks.ruby_ore;

import net.minecraft.block.Block;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBlocks {

	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ExampleMod.MOD_ID);
	
	 //blocks
	 public static final RegistryObject<Block> RUBY_BLOCK = BLOCKS.register("ruby_block", RubyBlock::new);
	 public static final RegistryObject<Block> RUBY_ORE = BLOCKS.register("ruby_ore", ruby_ore::new);
	 public static final RegistryObject<Block> OVEN = BLOCKS.register("oven", Oven::new);
	 
}
