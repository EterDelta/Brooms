package com.github.eterdelta.broomsmod.advancements;

import com.github.eterdelta.broomsmod.BroomsMod;
import com.google.gson.JsonObject;
import net.minecraft.advancements.criterion.AbstractCriterionTrigger;
import net.minecraft.advancements.criterion.CriterionInstance;
import net.minecraft.advancements.criterion.EntityPredicate;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.loot.ConditionArrayParser;
import net.minecraft.util.ResourceLocation;

public class StartRidingBroomTrigger extends AbstractCriterionTrigger<StartRidingBroomTrigger.TriggerInstance> {
    static final ResourceLocation ID = new ResourceLocation(BroomsMod.MODID, "started_riding_broom");

    @Override
    public ResourceLocation getId() {
        return ID;
    }

    @Override
    public StartRidingBroomTrigger.TriggerInstance createInstance(JsonObject p_160390_, EntityPredicate.AndPredicate p_160391_, ConditionArrayParser p_160392_) {
        return new StartRidingBroomTrigger.TriggerInstance(p_160391_);
    }

    public void trigger(ServerPlayerEntity playerEntity) {
        this.trigger(playerEntity, (triggerInstance) -> true);
    }

    public static class TriggerInstance extends CriterionInstance {
        public TriggerInstance(EntityPredicate.AndPredicate p_160400_) {
            super(StartRidingBroomTrigger.ID, p_160400_);
        }

        public static StartRidingBroomTrigger.TriggerInstance playerStartsRiding(EntityPredicate.Builder p_160402_) {
            return new StartRidingBroomTrigger.TriggerInstance(EntityPredicate.AndPredicate.wrap(p_160402_.build()));
        }
    }
}
