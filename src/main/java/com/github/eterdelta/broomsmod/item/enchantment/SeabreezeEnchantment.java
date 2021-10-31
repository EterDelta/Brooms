package com.github.eterdelta.broomsmod.item.enchantment;

import com.github.eterdelta.broomsmod.item.WoodenBroomItem;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;

public class SeabreezeEnchantment extends Enchantment {
    public SeabreezeEnchantment() {
        super(Rarity.RARE, WoodenBroomItem.ENCHANTMENT_CATEGORY, EquipmentSlot.values());
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
