package com.github.eterdelta.broomsmod.registry;

import com.github.eterdelta.broomsmod.BroomsMod;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BroomsSounds {

    public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, BroomsMod.MODID);

    public static final RegistryObject<SoundEvent> BROOM_FALL = SOUND_EVENTS.register("entity.wooden_broom.fall", () -> new SoundEvent(new ResourceLocation(BroomsMod.MODID, "entity.wooden_broom.fall")));
}
