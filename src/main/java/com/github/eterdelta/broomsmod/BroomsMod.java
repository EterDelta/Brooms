package com.github.eterdelta.broomsmod;

import com.github.eterdelta.broomsmod.registry.BroomsEnchantments;
import com.github.eterdelta.broomsmod.registry.BroomsEntities;
import com.github.eterdelta.broomsmod.registry.BroomsItems;
import com.github.eterdelta.broomsmod.registry.BroomsSounds;
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
    }
}
