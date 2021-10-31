package com.github.eterdelta.broomsmod.item.enchantment;

import com.github.eterdelta.broomsmod.item.WoodenBroomItem;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;

public class AirSkillsEnchantment extends Enchantment {
    public AirSkillsEnchantment() {
        super(Rarity.COMMON, WoodenBroomItem.ENCHANTMENT_CATEGORY, EquipmentSlot.values());
    }

    @Override
    public int getMinCost(int p_44679_) {
        return p_44679_ * 15;
    }

    @Override
    public int getMaxCost(int p_44610_) {
        return 60;
    }

    @Override
    public int getMaxLevel() {
        return 3;
    }

    @Override
    protected boolean checkCompatibility(Enchantment enchantment) {
        return !(enchantment instanceof LandSkillsEnchantment) && super.checkCompatibility(enchantment);
    }
}
