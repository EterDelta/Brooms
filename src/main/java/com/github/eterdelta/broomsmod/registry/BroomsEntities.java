package com.github.eterdelta.broomsmod.registry;

import com.github.eterdelta.broomsmod.BroomsMod;
import com.github.eterdelta.broomsmod.entity.WoodenBroomEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BroomsEntities {

    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, BroomsMod.MODID);

    public static final RegistryObject<EntityType<WoodenBroomEntity>> WOODEN_BROOM = registerBroom(WoodenBroomEntity::new, "wooden_broom");

    public static <T extends Entity> RegistryObject<EntityType<T>> registerBroom(EntityType.EntityFactory<T> entity, String name) {
        return ENTITIES.register(name,
                () -> EntityType.Builder.of(entity, MobCategory.MISC).sized(0.7F, 0.6F).build(name));
    }
}
