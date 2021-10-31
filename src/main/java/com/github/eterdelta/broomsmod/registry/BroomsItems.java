package com.github.eterdelta.broomsmod.registry;

import com.github.eterdelta.broomsmod.BroomsMod;
import com.github.eterdelta.broomsmod.item.WoodenBroomItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BroomsItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, BroomsMod.MODID);

    public static final RegistryObject<WoodenBroomItem> WOODEN_BROOM = ITEMS.register("wooden_broom", () -> new WoodenBroomItem(new Item.Properties().stacksTo(1).tab(CreativeModeTab.TAB_TRANSPORTATION)));
}
