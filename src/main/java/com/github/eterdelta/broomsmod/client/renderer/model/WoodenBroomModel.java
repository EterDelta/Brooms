package com.github.eterdelta.broomsmod.client.renderer.model;

import com.github.eterdelta.broomsmod.BroomsMod;
import com.github.eterdelta.broomsmod.entity.WoodenBroomEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class WoodenBroomModel<T extends WoodenBroomEntity> extends EntityModel<T> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(BroomsMod.MODID, "wooden_broom"), "main");
    private final ModelPart stick;

    public WoodenBroomModel(ModelPart root) {
        this.stick = root.getChild("stick");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshDefinition = new MeshDefinition();
        PartDefinition partDefinition = meshDefinition.getRoot();

        PartDefinition stick = partDefinition.addOrReplaceChild("stick", CubeListBuilder.create()
                        .texOffs(0, 20).addBox(-12.0F, -1.5F, -1.5F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
                        .texOffs(0, 0).addBox(-13.0F, -1.0F, -1.0F, 20.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 21.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

        PartDefinition bristles = stick.addOrReplaceChild("bristles", CubeListBuilder.create()
                        .texOffs(0, 4).addBox(0.0F, -2.5F, -2.5F, 6.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
                        .texOffs(0, 14).addBox(-1.0F, -1.5F, -1.5F, 9.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)),
                PartPose.offset(8.0F, 0.0F, 0.0F));

        return LayerDefinition.create(meshDefinition, 64, 64);
    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        float f = ageInTicks * 0.1F;
        if (entity.getPassengers().isEmpty()) {
            this.stick.y = Mth.sin(f) * 1.8F;
        } else {
            this.stick.y = 3.0F;
        }
        this.stick.xRot = Mth.cos(f * 2) * 0.1F;
        this.stick.zRot = Mth.sin(f * 2) * 0.1F;
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        stick.render(poseStack, buffer, packedLight, packedOverlay);
    }
}