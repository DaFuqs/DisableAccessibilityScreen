package de.dafuqs.disableaccessibilityscreen.mixin;

import net.minecraft.client.*;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.*;

@Mixin(Minecraft.class)
public abstract class MinecraftClientMixin {
    
    @Shadow @Final public Options options;
    
    @Inject(method = "addInitialScreens(Ljava/util/List;)Z", at = @At("HEAD"))
    private void disableAccessibilityScreen(CallbackInfoReturnable<Runnable> cir) {
        this.options.onboardAccessibility = false;
    }

}
