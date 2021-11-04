package com.github.eterdelta.broomsmod.item.enchantment;

import com.github.eterdelta.broomsmod.item.WoodenBroomItem;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.inventory.EquipmentSlotType;

public class LandSkillsEnchantment extends Enchantment {
    public LandSkillsEnchantment() {
        super(Rarity.COMMON, WoodenBroomItem.ENCHANTMENT_CATEGORY, EquipmentSlotType.values());
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
        return !(enchantment instanceof AirSkillsEnchantment) && super.checkCompatibility(enchantment);
    }
}
