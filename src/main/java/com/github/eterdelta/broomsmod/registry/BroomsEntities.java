package com.github.eterdelta.broomsmod.registry;

import com.github.eterdelta.broomsmod.BroomsMod;
import com.github.eterdelta.broomsmod.entity.WoodenBroomEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BroomsEntities {

    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, BroomsMod.MODID);

    public static final RegistryObject<EntityType<WoodenBroomEntity>> WOODEN_BROOM = registerBroom(WoodenBroomEntity::new, "wooden_broom");

    public static <T extends Entity> RegistryObject<EntityType<T>> registerBroom(EntityType.IFactory<T> entity, String name) {
        return ENTITIES.register(name,
                () -> EntityType.Builder.of(entity, EntityClassification.MISC).sized(0.7F, 0.6F).build(name));
    }
}
