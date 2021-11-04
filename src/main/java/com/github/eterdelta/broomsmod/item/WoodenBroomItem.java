package com.github.eterdelta.broomsmod.item;

import com.github.eterdelta.broomsmod.entity.WoodenBroomEntity;
import com.github.eterdelta.broomsmod.registry.BroomsItems;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class WoodenBroomItem extends Item {
    public static final EnchantmentType ENCHANTMENT_CATEGORY = EnchantmentType.create("broom", (item) -> item.equals(BroomsItems.WOODEN_BROOM.get()));

    public WoodenBroomItem(Properties properties) {
        super(properties);
    }

    public ActionResult<ItemStack> use(World level, PlayerEntity player, Hand interactionHand) {
        ItemStack itemStack = player.getItemInHand(interactionHand);
        RayTraceResult hitResult = getPlayerPOVHitResult(level, player, RayTraceContext.FluidMode.ANY);
        if (hitResult.getType() == RayTraceResult.Type.MISS) {
            return ActionResult.pass(itemStack);
        } else {
            if (hitResult.getType() == RayTraceResult.Type.BLOCK) {
                WoodenBroomEntity broom = new WoodenBroomEntity(itemStack, level, hitResult.getLocation().x(), hitResult.getLocation().y(), hitResult.getLocation().z());
                broom.yRot = player.yRot;

                if (!level.noCollision(broom, broom.getBoundingBox().inflate(-0.1D))) {
                    return ActionResult.fail(itemStack);
                } else {
                    if (!level.isClientSide()) {
                        level.addFreshEntity(broom);
                        if (!player.abilities.instabuild) {
                            itemStack.shrink(1);
                        }
                    }
                    player.awardStat(Stats.ITEM_USED.get(this));
                    return ActionResult.sidedSuccess(itemStack, level.isClientSide());
                }
            } else {
                return ActionResult.pass(itemStack);
            }
        }
    }
}
