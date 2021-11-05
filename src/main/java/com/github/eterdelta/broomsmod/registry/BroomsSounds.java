package com.github.eterdelta.broomsmod.registry;

import com.github.eterdelta.broomsmod.BroomsMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BroomsSounds {

    public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, BroomsMod.MODID);

    public static final RegistryObject<SoundEvent> BROOM_DESTROY = SOUND_EVENTS.register("entity.wooden_broom.destroy", () -> new SoundEvent(new ResourceLocation(BroomsMod.MODID, "entity.wooden_broom.destroy")));
    public static final RegistryObject<SoundEvent> BROOM_FALL = SOUND_EVENTS.register("entity.wooden_broom.fall", () -> new SoundEvent(new ResourceLocation(BroomsMod.MODID, "entity.wooden_broom.fall")));
}
