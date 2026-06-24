package de.dafuqs.disableaccessibilityscreen.mixin;

import net.minecraft.client.*;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.*;

@Mixin(Minecraft.class)
public abstract class MinecraftClientMixin {
    
    @Shadow @Final public Options options;
    
    @Inject(method = "onResourceLoadFinished(Lnet/minecraft/client/GameLoadCookie;)V", at = @At("HEAD"))
    private void disableAccessibilityScreen(GameLoadCookie loadCookie, CallbackInfo ci) {
        this.options.onboardAccessibility = false;
    }

}
