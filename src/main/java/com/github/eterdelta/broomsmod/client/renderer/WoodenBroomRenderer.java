package com.github.eterdelta.broomsmod.client.renderer;

import com.github.eterdelta.broomsmod.BroomsMod;
import com.github.eterdelta.broomsmod.client.renderer.model.WoodenBroomModel;
import com.github.eterdelta.broomsmod.entity.WoodenBroomEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;

public class WoodenBroomRenderer extends BroomRenderer<WoodenBroomEntity> {
    private static final ResourceLocation BROOM_TEXTURE = new ResourceLocation(BroomsMod.MODID, "textures/entity/wooden_broom.png");
    private final WoodenBroomModel<WoodenBroomEntity> broomModel = new WoodenBroomModel<>();

    public WoodenBroomRenderer(EntityRendererManager rendererManager) {
        super(rendererManager);
    }

    @Override
    public EntityModel<WoodenBroomEntity> getBroomModel() {
        return this.broomModel;
    }

    @Override
    public ResourceLocation getTextureLocation(WoodenBroomEntity woodenBroomEntity) {
        return BROOM_TEXTURE;
    }
}
