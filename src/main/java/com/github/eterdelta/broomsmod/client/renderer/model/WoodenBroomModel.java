package com.github.eterdelta.broomsmod.client.renderer.model;

import com.github.eterdelta.broomsmod.entity.WoodenBroomEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class WoodenBroomModel<T extends WoodenBroomEntity> extends EntityModel<T> {
    private final ModelRenderer root;
    private final ModelRenderer bone;

    public WoodenBroomModel() {
        texWidth = 64;
        texHeight = 64;

        root = new ModelRenderer(this);
        root.setPos(0.0F, 20.0F, 0.25F);
        setRotationAngle(root, 0.0F, -1.5708F, 0.0F);
        root.texOffs(0, 4).addBox(8.0F, -2.5F, -2.5F, 6.0F, 5.0F, 5.0F, 0.0F, false);
        root.texOffs(0, 14).addBox(7.0F, -1.5F, -1.5F, 9.0F, 3.0F, 3.0F, 0.0F, false);

        bone = new ModelRenderer(this);
        bone.setPos(0.0F, 3.0F, 0.0F);
        root.addChild(bone);
        bone.texOffs(0, 20).addBox(-12.0F, -4.5F, -1.5F, 1.0F, 3.0F, 3.0F, 0.0F, false);
        bone.texOffs(0, 0).addBox(-13.0F, -4.0F, -1.0F, 20.0F, 2.0F, 2.0F, 0.0F, false);
    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        float f = ageInTicks * 0.1F;
        if (entity.getPassengers().isEmpty()) {
            this.root.y = MathHelper.sin(f) * 1.8F;
        } else {
            this.root.y = 3.0F;
        }
        this.root.xRot = MathHelper.cos(f * 2) * 0.1F;
        this.root.zRot = MathHelper.sin(f * 2) * 0.1F;
    }

    @Override
    public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        root.render(matrixStack, buffer, packedLight, packedOverlay);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.xRot = x;
        modelRenderer.yRot = y;
        modelRenderer.zRot = z;
    }
}