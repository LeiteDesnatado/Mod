package com.leitedesnatado.examplemod.enchantments;

import com.leitedesnatado.examplemod.ExampleMod;
import com.leitedesnatado.examplemod.init.EnchantmentInit;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.block.material.Material;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent.PlayerTickEvent;
import net.minecraftforge.event.entity.ProjectileImpactEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

public class TesteEnchantment extends Enchantment {

	public TesteEnchantment(Rarity rarityIn, EnchantmentType typeIn, EquipmentSlotType[] slots) {
		super(rarityIn, EnchantmentType.ARMOR_FEET, slots);
			
	}
	
	@Override
	public int getMaxLevel() {
		return 1;
	}

	@Override
	public int getMinLevel() {
		return 1;
	}


	
	@Mod.EventBusSubscriber(modid = ExampleMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
	public static class TesteTinho {
		
		@SubscribeEvent
		public static void testAndo(PlayerTickEvent event) {

			PlayerEntity playerIn = event.player;
			World worldIn = playerIn.world;
			if (playerIn.hasItemInSlot(EquipmentSlotType.FEET)
					&& EnchantmentHelper.getEnchantmentLevel(EnchantmentInit.TESTE.get(),
							playerIn.getItemStackFromSlot(EquipmentSlotType.FEET)) > 0) {
		
				if (playerIn.isSwimming()) {
					playerIn.addPotionEffect(new EffectInstance(Effects.REGENERATION, 200));
				}
			}
		}

	}
}