package com.leitedesnatado.examplemod.events;

import com.leitedesnatado.examplemod.ExampleMod;

import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.CowEntity;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.item.Items;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.event.entity.ProjectileImpactEvent;
import net.minecraftforge.event.entity.living.AnimalTameEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingJumpEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ExampleMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class ModClientEvents 
{

	@SubscribeEvent
	public static void onJumpWithStick(LivingEvent.LivingJumpEvent event) {
		LivingEntity player = event.getEntityLiving();
		if (player.getHeldItemMainhand().getItem() == Items.STICK) {
			ExampleMod.LOGGER.info("Player tried to jump with a stick!");
			World world = player.getEntityWorld();
			 world.setBlockState(player.getPosition().add(0, -1, 0), Blocks.DIAMOND_BLOCK.getDefaultState());
		}

		
	}
	
	@SubscribeEvent
	public static void tntRun(LivingEvent.LivingJumpEvent event) {
		LivingEntity player = event.getEntityLiving();
		if (player.isBurning()) {
			player.addPotionEffect(new EffectInstance(Effects.ABSORPTION, 100, 200));
		}

				
		
	}

	
	
	@SubscribeEvent
	public static void onDamageSheep(AttackEntityEvent event) {
		if(event.getEntityLiving().getHeldItemMainhand().getItem() == Items.POISONOUS_POTATO) {
			if(event.getTarget().isAlive()){
				LivingEntity target = (LivingEntity) event.getTarget();
				if(target instanceof SheepEntity) {
					PlayerEntity player = event.getPlayer();
					target.addPotionEffect(new EffectInstance(Effects.POISON, 200));
					target.setGlowing(true);
					
					if(event.getPlayer().getEntityWorld().isRemote) {
						String msg = TextFormatting.BLUE + "The sheep ate the bad potato boi";
						 player.sendMessage(new StringTextComponent(msg));
					}
				}
			}
			
		}
	}
}
