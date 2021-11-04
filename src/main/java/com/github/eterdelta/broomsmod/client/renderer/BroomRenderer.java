package com.github.eterdelta.broomsmod.client.renderer;

import com.github.eterdelta.broomsmod.entity.WoodenBroomEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.vertex.VertexBuilderUtils;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3f;

public abstract class BroomRenderer<T extends WoodenBroomEntity> extends EntityRenderer<T> {
    public BroomRenderer(EntityRendererManager rendererManager) {
        super(rendererManager);
        this.shadowRadius = 0.6F;
    }

    @Override
    public void render(T broomEntity, float p_113930_, float partialTicks, MatrixStack poseStack, IRenderTypeBuffer multiBufferSource, int p_113934_) {
        poseStack.pushPose();
        poseStack.translate(0.0D, 0.5D, 0.0D);
        poseStack.mulPose(Vector3f.YP.rotationDegrees(-p_113930_));

        float hurtTime = broomEntity.getHurtTime() - partialTicks;

        if (hurtTime > 0.0F) {
            float swingDegrees = MathHelper.sin(hurtTime) * hurtTime * 2.5F / 10.0F;
            poseStack.mulPose(Vector3f.XP.rotationDegrees(swingDegrees));
            poseStack.mulPose(Vector3f.ZP.rotationDegrees(swingDegrees));
        }

        ResourceLocation broomTexture = this.getTextureLocation(broomEntity);
        EntityModel<T> broomModel = this.getBroomModel();

        poseStack.scale(-1.0F, -1.0F, 1.0F);
        poseStack.mulPose(Vector3f.YP.rotationDegrees(180.0F));
        broomModel.setupAnim(broomEntity, partialTicks, 0.0F, broomEntity.tickCount + partialTicks, 0.0F, 0.0F);
        IVertexBuilder vertexConsumer = this.getBuffer(broomEntity, broomModel, broomTexture, multiBufferSource);
        broomModel.renderToBuffer(poseStack, vertexConsumer, p_113934_, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);

        poseStack.popPose();
        super.render(broomEntity, p_113930_, partialTicks, poseStack, multiBufferSource, p_113934_);
    }

    public IVertexBuilder getBuffer(T broomEntity, EntityModel<T> broomModel, ResourceLocation broomTexture, IRenderTypeBuffer multiBufferSource) {
        IVertexBuilder buffer;
        if (broomEntity.getItem().isEnchanted()) {
            buffer = VertexBuilderUtils.create(multiBufferSource.getBuffer(RenderType.entityGlint()), multiBufferSource.getBuffer(broomModel.renderType(broomTexture)));
        } else {
            buffer = multiBufferSource.getBuffer(broomModel.renderType(broomTexture));
        }
        return buffer;
    }

    public abstract EntityModel<T> getBroomModel();
}
