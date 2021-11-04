package com.github.eterdelta.broomsmod.item.enchantment;

import com.github.eterdelta.broomsmod.item.WoodenBroomItem;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.inventory.EquipmentSlotType;

public class SeabreezeEnchantment extends Enchantment {
    public SeabreezeEnchantment() {
        super(Rarity.RARE, WoodenBroomItem.ENCHANTMENT_CATEGORY, EquipmentSlotType.values());
    }

    @Override
    public int getMinCost(int p_44679_) {
        return p_44679_ * 40;
    }

    @Override
    public int getMaxCost(int p_44610_) {
        return this.getMinCost(p_44610_) * 2;
    }

    @Override
    public int getMaxLevel() {
        return 1;
    }
}
