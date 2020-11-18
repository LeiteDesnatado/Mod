package com.leitedesnatado.examplemod.entities;

import java.util.Random;

import com.leitedesnatado.examplemod.init.ModEntityTypes;

import net.minecraft.block.Blocks;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.controller.MovementController;
import net.minecraft.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.entity.ai.goal.PanicGoal;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.passive.WaterMobEntity;
import net.minecraft.entity.passive.fish.AbstractFishEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityPredicates;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;

public class FishyEntity extends WaterMobEntity {

	public FishyEntity(EntityType<? extends WaterMobEntity> type, World worldIn) {
		super(type, worldIn);	
	}
	  
	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(10, new SwimGoal(this));
		this.goalSelector.addGoal(3, new PanicGoal(this, 1.25D));
	    this.goalSelector.addGoal(2, new AvoidEntityGoal<>(this, PlayerEntity.class, 8.0F, 1.6D, 1.4D, EntityPredicates.NOT_SPECTATING::test));
	    this.goalSelector.addGoal(1, new RandomWalkingGoal(this, 0.8D, 20));
		}
	public static boolean func_223363_b(EntityType<? extends AbstractFishEntity> type, IWorld worldIn, SpawnReason reason, BlockPos p_223363_3_, Random randomIn) {
	      return worldIn.getBlockState(p_223363_3_).getBlock() == Blocks.WATER && worldIn.getBlockState(p_223363_3_.up()).getBlock() == Blocks.WATER;
	   }

	   static class MoveHelperController extends MovementController {
	      private final FishyEntity fish;

	      MoveHelperController(FishyEntity fish) {
	         super(fish);
	         this.fish = fish;
	      }

	      public void tick() {
	         if (this.fish.areEyesInFluid(FluidTags.WATER)) {
	            this.fish.setMotion(this.fish.getMotion().add(0.0D, 0.0D, 0.0D));
	         }


	         if (this.action == MovementController.Action.MOVE_TO && !this.fish.getNavigator().noPath()) {
	            double d0 = this.posX - this.fish.getPosX();
	            double d1 = this.posY - this.fish.getPosY();
	            double d2 = this.posZ - this.fish.getPosZ();
	            double d3 = (double)MathHelper.sqrt(d0 * d0 + d1 * d1 + d2 * d2);
	            d1 = d1 / d3;
	            float f = (float)(MathHelper.atan2(d2, d0) * (double)(180F / (float)Math.PI)) - 90.0F;
	            this.fish.rotationYaw = this.limitAngle(this.fish.rotationYaw, f, 0.0F);
	            this.fish.renderYawOffset = this.fish.rotationYaw;
	            float f1 = (float)(this.speed * this.fish.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getValue());
	            this.fish.setAIMoveSpeed(MathHelper.lerp(0.2F, this.fish.getAIMoveSpeed(), f1));
	            this.fish.setMotion(this.fish.getMotion().add(0.0D, (double)this.fish.getAIMoveSpeed() * d2 * 0.1D, 0.0D));
	         } else {
	            this.fish.setAIMoveSpeed(0.0F);
	         }
	      }
	   }
	   public boolean isNotColliding(IWorldReader worldIn) {
		      return worldIn.checkNoEntityCollision(this);
		   }
	   protected void updateAir(int p_209207_1_) {
		      if (this.isAlive() && !this.isInWaterOrBubbleColumn()) {
		         this.setAir(p_209207_1_ - 1);
		         if (this.getAir() == -20) {
		            this.setAir(0);
		            this.attackEntityFrom(DamageSource.DROWN, 2.0F);
		         }
		      } else {
		         this.setAir(300);
		      }

		   }
	   public CreatureAttribute getCreatureAttribute() {
	      return CreatureAttribute.WATER;
	   } 
	   protected SoundEvent getAmbientSound() {
		      return SoundEvents.ENTITY_COD_AMBIENT;
		   }

		   protected SoundEvent getDeathSound() {
		      return SoundEvents.ENTITY_COD_DEATH;
		   }

		   protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		      return SoundEvents.ENTITY_COD_HURT;
		   }

		   protected SoundEvent getFlopSound() {
		      return SoundEvents.ENTITY_COD_FLOP;
		   }	
	@Override
	protected void registerAttributes() {
		super.registerAttributes();
		this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(4.0D);
		this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(1.0D);
	}
}
