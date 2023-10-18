package de.dafuqs.disableaccessibilityscreen.mixin;

import net.minecraft.client.*;
import net.minecraft.client.option.*;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.*;

@Mixin(MinecraftClient.class)
public abstract class MinecraftClientMixin {
    
    @Shadow @Final public GameOptions options;
    
    @Inject(method = "onInitFinished(Lnet/minecraft/client/MinecraftClient$LoadingContext;)Ljava/lang/Runnable;", at = @At("HEAD"))
    private void disableAccessibilityScreen(CallbackInfoReturnable<Runnable> cir) {
        this.options.onboardAccessibility = false;
    }

}
