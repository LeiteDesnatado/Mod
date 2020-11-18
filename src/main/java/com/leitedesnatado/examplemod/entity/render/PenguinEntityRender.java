package com.leitedesnatado.examplemod.entity.render;

import com.leitedesnatado.examplemod.ExampleMod;
import com.leitedesnatado.examplemod.entities.FishyEntity;
import com.leitedesnatado.examplemod.entities.PenguinEntity;
import com.leitedesnatado.examplemod.entity.model.FishyEntityModel;
import com.leitedesnatado.examplemod.entity.model.PenguinEntityModel;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class PenguinEntityRender extends MobRenderer<PenguinEntity, PenguinEntityModel<PenguinEntity>> {

	
	   protected static final ResourceLocation TEXTURE = new ResourceLocation(ExampleMod.MOD_ID, "textures/entity/penguin.png");

	    public PenguinEntityRender(EntityRendererManager renderManagerIn) {
	        super(renderManagerIn, new com.leitedesnatado.examplemod.entity.model.PenguinEntityModel<>(), 0.7f);
	    }

	    @Override
	    public ResourceLocation getEntityTexture(PenguinEntity entity) {
	        return TEXTURE;
	    }

}
