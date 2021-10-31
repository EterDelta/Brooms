package com.github.eterdelta.broomsmod.handler;

import com.github.eterdelta.broomsmod.BroomsMod;
import com.github.eterdelta.broomsmod.client.renderer.WoodenBroomRenderer;
import com.github.eterdelta.broomsmod.client.renderer.model.WoodenBroomModel;
import com.github.eterdelta.broomsmod.registry.BroomsEntities;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = BroomsMod.MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientHandler {

    @SubscribeEvent
    public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(BroomsEntities.WOODEN_BROOM.get(), WoodenBroomRenderer::new);
    }

    @SubscribeEvent
    public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(WoodenBroomModel.LAYER_LOCATION, WoodenBroomModel::createBodyLayer);
    }
}
