package com.leitedesnatado.examplemod.entity.model;

import com.leitedesnatado.examplemod.entities.FishyEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

	public class FishyEntityModel<T extends FishyEntity> extends EntityModel<T> {
		private final ModelRenderer fishy;
		private final ModelRenderer body;
		private final ModelRenderer tail;

		public FishyEntityModel() {
			textureWidth = 16;
			textureHeight = 16;

			fishy = new ModelRenderer(this);
			fishy.setRotationPoint(0.0F, 24.0F, 0.0F);
			setRotationAngle(fishy, 0.0F, 1.5708F, 0.0F);
			

			body = new ModelRenderer(this);
			body.setRotationPoint(0.0F, 0.0F, 0.0F);
			fishy.addChild(body);
			body.setTextureOffset(0, 0).addBox(-5.0F, -1.0F, -1.0F, 11.0F, 1.0F, 2.0F, 0.0F, false);
			body.setTextureOffset(0, 0).addBox(-5.0F, -5.0F, -1.0F, 12.0F, 4.0F, 2.0F, 0.0F, false);
			body.setTextureOffset(0, 0).addBox(-5.0F, -6.0F, -1.0F, 11.0F, 1.0F, 2.0F, 0.0F, false);

			tail = new ModelRenderer(this);
			tail.setRotationPoint(-5.0F, -3.0F, 0.0F);
			fishy.addChild(tail);
			tail.setTextureOffset(0, 0).addBox(-2.0F, -1.0F, 0.0F, 2.0F, 2.0F, 0.0F, 0.0F, false);
			tail.setTextureOffset(0, 0).addBox(-3.0F, -2.0F, 0.0F, 2.0F, 1.0F, 0.0F, 0.0F, false);
			tail.setTextureOffset(0, 0).addBox(-3.0F, 1.0F, 0.0F, 2.0F, 1.0F, 0.0F, 0.0F, false);
		}


		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
			fishy.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}


		@Override
		public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks,
				float netHeadYaw, float headPitch) {
			float f = 1.0F;
		      if (!entityIn.isInWater()) {
		         f = 1.5F;
		      }

		      this.tail.rotateAngleY = -f * 0.45F * MathHelper.sin(0.6F * ageInTicks);
			
		}
	}

