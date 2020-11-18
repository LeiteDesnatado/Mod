package com.leitedesnatado.examplemod.objects.items;

import com.leitedesnatado.examplemod.ExampleMod;

import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class Coco extends Item {

	public Coco() {
		super(new Item.Properties()
				.group(ExampleMod.TAB)
				.food(new Food.Builder()
						.hunger(2)
						.saturation(1.1f)
						.effect(
								() -> new EffectInstance(Effects.NAUSEA,20*20,2),
								1.0f
								)
						.effect(
								() -> new EffectInstance(Effects.POISON,20*5,1),
								1.0f
								)
						.build())
				
				
				
				
				);
		
	}

}
