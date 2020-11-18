package com.leitedesnatado.examplemod.entity.render;


import com.leitedesnatado.examplemod.ExampleMod;
import com.leitedesnatado.examplemod.entities.FishyEntity;
import com.leitedesnatado.examplemod.entity.model.FishyEntityModel;
import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.renderer.Vector3f;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.entity.passive.fish.TropicalFishEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;

public class FishyEntityRender extends MobRenderer<FishyEntity, FishyEntityModel<FishyEntity>> {

	protected static final ResourceLocation TEXTURE = new ResourceLocation(ExampleMod.MOD_ID,
			"textures/entity/fishy_entity.png");

	public FishyEntityRender(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new FishyEntityModel(), 0.2f);
	}

	public ResourceLocation getEntityTexture(FishyEntity entity) {
		return TEXTURE;
	}


}