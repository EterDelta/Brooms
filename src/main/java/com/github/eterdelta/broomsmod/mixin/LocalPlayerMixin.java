package com.github.eterdelta.broomsmod.mixin;

import com.github.eterdelta.broomsmod.entity.WoodenBroomEntity;
import com.mojang.authlib.GameProfile;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.player.Input;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.entity.player.ProfilePublicKey;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LocalPlayer.class)
public class LocalPlayerMixin extends AbstractClientPlayer {
    @Shadow
    public Input input;

    @Shadow
    private boolean handsBusy;

    public LocalPlayerMixin(ClientLevel clientLevel, GameProfile gameProfile, ProfilePublicKey profilePublicKey) {
        super(clientLevel, gameProfile, profilePublicKey);
    }

    @Inject(at = @At("TAIL"), method = "rideTick()V")
    private void rideTick(CallbackInfo callbackInfo) {
        if (this.getVehicle() instanceof WoodenBroomEntity broomVehicle) {
            broomVehicle.setInputs(this.input.left, this.input.right, this.input.up, this.input.down, this.input.jumping);
            this.handsBusy |= this.input.left || this.input.right || this.input.up || this.input.down || this.input.jumping;
        }
    }
}
