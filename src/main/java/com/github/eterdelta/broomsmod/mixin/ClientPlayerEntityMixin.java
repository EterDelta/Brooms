package com.github.eterdelta.broomsmod.mixin;

import com.github.eterdelta.broomsmod.entity.WoodenBroomEntity;
import com.mojang.authlib.GameProfile;
import net.minecraft.client.entity.player.AbstractClientPlayerEntity;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.util.MovementInput;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientPlayerEntity.class)
public class ClientPlayerEntityMixin extends AbstractClientPlayerEntity {
    @Shadow
    public MovementInput input;

    @Shadow
    private boolean handsBusy;

    public ClientPlayerEntityMixin(ClientWorld p_108548_, GameProfile p_108549_) {
        super(p_108548_, p_108549_);
    }

    @Inject(at = @At("TAIL"), method = "rideTick()V")
    private void rideTick(CallbackInfo callbackInfo) {
        if (this.getVehicle() instanceof WoodenBroomEntity) {
            WoodenBroomEntity broomVehicle = (WoodenBroomEntity) this.getVehicle();
            broomVehicle.setInputs(this.input.left, this.input.right, this.input.up, this.input.down, this.input.jumping);
            this.handsBusy |= this.input.left || this.input.right || this.input.up || this.input.down || this.input.jumping;
        }
    }
}
