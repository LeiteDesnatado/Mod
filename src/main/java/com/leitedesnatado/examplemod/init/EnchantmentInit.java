package com.leitedesnatado.examplemod.init;

import com.leitedesnatado.examplemod.ExampleMod;
import com.leitedesnatado.examplemod.enchantments.TesteEnchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantment.Rarity;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class EnchantmentInit {


	public static final DeferredRegister<Enchantment> ENCHANTMENTS = new DeferredRegister<>(
			ForgeRegistries.ENCHANTMENTS, ExampleMod.MOD_ID);

	public static final RegistryObject<Enchantment> TESTE = ENCHANTMENTS.register("teste",
			() -> new TesteEnchantment(Rarity.RARE, EnchantmentType.ARMOR_FEET,
					new EquipmentSlotType[] { EquipmentSlotType.FEET }));
}
