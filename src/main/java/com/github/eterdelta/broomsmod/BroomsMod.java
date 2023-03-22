package com.github.eterdelta.broomsmod;

import com.github.eterdelta.broomsmod.client.renderer.WoodenBroomRenderer;
import com.github.eterdelta.broomsmod.client.renderer.model.WoodenBroomModel;
import com.github.eterdelta.broomsmod.registry.BroomsEnchantments;
import com.github.eterdelta.broomsmod.registry.BroomsEntities;
import com.github.eterdelta.broomsmod.registry.BroomsItems;
import com.github.eterdelta.broomsmod.registry.BroomsSounds;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(BroomsMod.MODID)
public class BroomsMod {
    public static final String MODID = "broomsmod";

    public BroomsMod() {
        final IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        BroomsEnchantments.ENCHANTMENTS.register(eventBus);
        BroomsEntities.ENTITIES.register(eventBus);
        BroomsItems.ITEMS.register(eventBus);
        BroomsSounds.SOUND_EVENTS.register(eventBus);

        eventBus.addListener(this::registerEntityRenderers);
        eventBus.addListener(this::registerEntityLayers);
    }

    public void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(BroomsEntities.WOODEN_BROOM.get(), WoodenBroomRenderer::new);
    }

    public void registerEntityLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(WoodenBroomModel.LAYER_LOCATION, WoodenBroomModel::createBodyLayer);
    }
}
