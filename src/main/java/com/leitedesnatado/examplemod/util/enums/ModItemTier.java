package com.leitedesnatado.examplemod.util.enums;

import java.util.function.Supplier;

import com.leitedesnatado.examplemod.init.ModItems;

import net.minecraft.item.IItemTier; 
import net.minecraft.item.crafting.Ingredient;
import com.leitedesnatado.examplemod.init.ModItems;

public enum ModItemTier implements IItemTier {
	
	RUBY(2, 1000, 9F, 3.0F, 12, () -> {
		return Ingredient.fromItems(ModItems.RUBY.get());
	});
	
	private final int harvestLevel;
	private final int maxUses;
	private final float efficiency;
	private final float attackDamage;
	private final int enchantability;
	public final Supplier<Ingredient> repairMaterial;
	
	ModItemTier(int harvestLevel, int maxUses, float efficiency, float attackDamage, int enchantability, Supplier<Ingredient> repairMaterial) {
		this.harvestLevel = harvestLevel;
		this.maxUses = maxUses;
		this.efficiency = efficiency;
		this.attackDamage = attackDamage;
		this.enchantability = enchantability;
		this.repairMaterial = repairMaterial;
	}

	@Override
	public int getMaxUses() {
		
		return maxUses;
	}

	@Override
	public float getEfficiency() {
		
		return efficiency;
	}

	@Override
	public float getAttackDamage() {
		
		return attackDamage;
	}

	@Override
	public int getHarvestLevel() {
		
		return harvestLevel;
	}

	@Override
	public int getEnchantability() {
		
		return enchantability;
	}

	@Override
	public Ingredient getRepairMaterial() {
		
		return repairMaterial.get();
	}

}