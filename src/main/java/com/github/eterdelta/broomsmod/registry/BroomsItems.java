package com.github.eterdelta.broomsmod.registry;

import com.github.eterdelta.broomsmod.BroomsMod;
import com.github.eterdelta.broomsmod.item.WoodenBroomItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BroomsItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, BroomsMod.MODID);

    public static final RegistryObject<WoodenBroomItem> WOODEN_BROOM = ITEMS.register("wooden_broom", () -> new WoodenBroomItem(new Item.Properties().stacksTo(1).tab(ItemGroup.TAB_TRANSPORTATION)));
}
