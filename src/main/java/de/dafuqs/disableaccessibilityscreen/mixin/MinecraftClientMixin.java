package de.dafuqs.disableaccessibilityscreen.mixin;

import net.minecraft.client.*;
import net.minecraft.client.option.*;
import net.minecraft.client.realms.*;
import net.minecraft.resource.*;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.*;

@Mixin(MinecraftClient.class)
public abstract class MinecraftClientMixin {
    
    @Shadow @Final public GameOptions options;
    
    @Inject(method = "onInitFinished(Lnet/minecraft/client/realms/RealmsClient;Lnet/minecraft/resource/ResourceReload;Lnet/minecraft/client/RunArgs$QuickPlay;)V", at = @At("HEAD"))
    private void disableAccessibilityScreen(RealmsClient realms, ResourceReload reload, RunArgs.QuickPlay quickPlay, CallbackInfo ci) {
        this.options.onboardAccessibility = false;
    }

}
