package com.leitedesnatado.examplemod.init;

import com.leitedesnatado.examplemod.ExampleMod;
import com.leitedesnatado.examplemod.armor.ModArmorMaterial;
import com.leitedesnatado.examplemod.objects.blocks.BlockItemBase;
import com.leitedesnatado.examplemod.objects.blocks.Oven;
import com.leitedesnatado.examplemod.objects.items.Coco;
import com.leitedesnatado.examplemod.objects.items.ItemBase;
import com.leitedesnatado.examplemod.util.enums.ModItemTier;

import net.minecraft.block.Block;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.MusicDiscItem;
import net.minecraft.item.SwordItem;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {

	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ExampleMod.MOD_ID);
	

	 
	 //items
	 public static final RegistryObject<Item> RUBY = ITEMS.register("ruby", () -> new Item(new Item.Properties().group(ExampleMod.TAB)));
	 public static final RegistryObject<Coco> COCO = ITEMS.register("coco", Coco::new);
	 public static final RegistryObject<Item> RICK_MUSIC_DISC = ITEMS.register("rick_music_disc",
			 () -> new MusicDiscItem(1, SoundList.RICK_LAZY.get(), new Item.Properties().maxStackSize(1).group(ExampleMod.TAB)) {} );
	 
	 //tools
	 public static final RegistryObject<Item> RUBY_SWORD = ITEMS.register("ruby_sword", () -> 
			 new SwordItem(ModItemTier.RUBY,  (int) -1F,  0.0F, new Item.Properties().group(ExampleMod.TAB)));
			 
	//block items
				 
	 public static final RegistryObject<Item> RUBY_BLOCK_ITEM = ITEMS.register("ruby_block", 
			 () -> new BlockItem(ModBlocks.RUBY_BLOCK.get(), new Item.Properties().group(ExampleMod.TAB)));
	 
	 public static final RegistryObject<Item> RUBY_ORE_ITEM = ITEMS.register("ruby_ore", 
			 () -> new BlockItem(ModBlocks.RUBY_ORE.get(), new Item.Properties().group(ExampleMod.TAB)));
	 
	 public static final RegistryObject<Item> OVEN_ITEM = ITEMS.register("oven",
	            () -> new BlockItem(ModBlocks.OVEN.get(), new Item.Properties().group(ExampleMod.TAB)));
	 
	 
	 public static final RegistryObject<ArmorItem> RUBY_HELMET = ITEMS.register("ruby_helmet",
	            () -> new ArmorItem(ModArmorMaterial.RUBY, EquipmentSlotType.HEAD, new Item.Properties().group(ExampleMod.TAB)));

	    public static final RegistryObject<ArmorItem> RUBY_CHESTPLATE = ITEMS.register("ruby_chestplate",
	            () -> new ArmorItem(ModArmorMaterial.RUBY, EquipmentSlotType.CHEST, new Item.Properties().group(ExampleMod.TAB)));

	    public static final RegistryObject<ArmorItem> RUBY_LEGGINGS = ITEMS.register("ruby_leggings",
	            () -> new ArmorItem(ModArmorMaterial.RUBY, EquipmentSlotType.LEGS, new Item.Properties().group(ExampleMod.TAB)));

	    public static final RegistryObject<ArmorItem> RUBY_BOOTS = ITEMS.register("ruby_boots",
	            () -> new ArmorItem(ModArmorMaterial.RUBY, EquipmentSlotType.FEET, new Item.Properties().group(ExampleMod.TAB)));
	
}
