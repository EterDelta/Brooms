package com.github.eterdelta.broomsmod.registry;

import com.github.eterdelta.broomsmod.BroomsMod;
import com.github.eterdelta.broomsmod.item.enchantment.AirSkillsEnchantment;
import com.github.eterdelta.broomsmod.item.enchantment.HoveringEnchantment;
import com.github.eterdelta.broomsmod.item.enchantment.LandSkillsEnchantment;
import com.github.eterdelta.broomsmod.item.enchantment.SeabreezeEnchantment;
import net.minecraft.enchantment.Enchantment;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BroomsEnchantments {

    public static final DeferredRegister<Enchantment> ENCHANTMENTS = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, BroomsMod.MODID);

    public static final RegistryObject<AirSkillsEnchantment> AIR_SKILLS = ENCHANTMENTS.register("air_skills", AirSkillsEnchantment::new);
    public static final RegistryObject<HoveringEnchantment> HOVERING = ENCHANTMENTS.register("hovering", HoveringEnchantment::new);
    public static final RegistryObject<LandSkillsEnchantment> LAND_SKILLS = ENCHANTMENTS.register("land_skills", LandSkillsEnchantment::new);
    public static final RegistryObject<SeabreezeEnchantment> SEA_BREEZE = ENCHANTMENTS.register("seabreeze", SeabreezeEnchantment::new);
}
