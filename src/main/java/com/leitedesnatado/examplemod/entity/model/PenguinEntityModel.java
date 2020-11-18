package com.leitedesnatado.examplemod.entity.model;

import com.leitedesnatado.examplemod.entities.FishyEntity;
import com.leitedesnatado.examplemod.entities.PenguinEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class PenguinEntityModel<T extends PenguinEntity> extends EntityModel<T> {

	public class custom_model extends EntityModel<Entity> {
		private final ModelRenderer Penguin;
		private final ModelRenderer feet;
		private final ModelRenderer body;
		private final ModelRenderer arms;
		private final ModelRenderer head;

		public custom_model() {
			textureWidth = 64;
			textureHeight = 64;

			Penguin = new ModelRenderer(this);
			Penguin.setRotationPoint(0.0F, 24.0F, 0.0F);
			

			feet = new ModelRenderer(this);
			feet.setRotationPoint(0.0F, 0.0F, 0.0F);
			Penguin.addChild(feet);
			feet.setTextureOffset(22, 16).addBox(-4.0F, -1.0F, 0.0F, 2.0F, 1.0F, 4.0F, 0.0F, false);
			feet.setTextureOffset(16, 11).addBox(0.0F, -1.0F, 0.0F, 2.0F, 1.0F, 4.0F, 0.0F, false);

			body = new ModelRenderer(this);
			body.setRotationPoint(0.0F, 0.0F, 0.0F);
			Penguin.addChild(body);
			body.setTextureOffset(0, 0).addBox(-4.0F, -12.0F, 1.0F, 6.0F, 11.0F, 3.0F, 0.0F, false);

			arms = new ModelRenderer(this);
			arms.setRotationPoint(0.0F, 0.0F, 0.0F);
			Penguin.addChild(arms);
			arms.setTextureOffset(17, 20).addBox(-5.0F, -12.0F, 1.0F, 1.0F, 8.0F, 3.0F, 0.0F, false);
			arms.setTextureOffset(18, 0).addBox(2.0F, -12.0F, 1.0F, 1.0F, 8.0F, 3.0F, 0.0F, false);

			head = new ModelRenderer(this);
			head.setRotationPoint(0.0F, 0.0F, 0.0F);
			Penguin.addChild(head);
			head.setTextureOffset(0, 14).addBox(-4.0F, -17.0F, 0.0F, 6.0F, 5.0F, 4.0F, 0.0F, false);
			head.setTextureOffset(0, 23).addBox(-2.0F, -14.0F, -2.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		}

		@Override
		public void setRotationAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
			//previously the render function, render code was moved to a method below
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
			Penguin.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}
	}

	@Override
	public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks,
			float netHeadYaw, float headPitch) {
	
		
	}

	@Override
	public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn,
			float red, float green, float blue, float alpha) {
	
		
	}



}
