package com.github.eterdelta.broomsmod.client.renderer;

import com.github.eterdelta.broomsmod.BroomsMod;
import com.github.eterdelta.broomsmod.client.renderer.model.WoodenBroomModel;
import com.github.eterdelta.broomsmod.entity.WoodenBroomEntity;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

public class WoodenBroomRenderer extends BroomRenderer<WoodenBroomEntity> {
    private static final ResourceLocation BROOM_TEXTURE = new ResourceLocation(BroomsMod.MODID, "textures/entity/wooden_broom.png");
    private final WoodenBroomModel<WoodenBroomEntity> broomModel;

    public WoodenBroomRenderer(EntityRendererProvider.Context context) {
        super(context);
        this.broomModel = new WoodenBroomModel<>(context.bakeLayer(WoodenBroomModel.LAYER_LOCATION));
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
