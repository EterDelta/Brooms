package com.github.eterdelta.broomsmod.item.enchantment;

import com.github.eterdelta.broomsmod.item.WoodenBroomItem;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;

public class HoveringEnchantment extends Enchantment {
    public HoveringEnchantment() {
        super(Rarity.UNCOMMON, WoodenBroomItem.ENCHANTMENT_CATEGORY, EquipmentSlot.values());
    }

    @Override
    public int getMinCost(int p_44679_) {
        return p_44679_ * 20;
    }

    @Override
    public int getMaxCost(int p_44610_) {
        return 80;
    }

    @Override
    public int getMaxLevel() {
        return 4;
    }
}
