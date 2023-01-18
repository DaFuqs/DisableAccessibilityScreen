package de.dafuqs.disableaccessibilityscreen.mixin;

import de.dafuqs.disableaccessibilityscreen.client.*;
import net.minecraft.client.option.*;
import net.minecraft.client.util.*;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.*;

@Mixin(NarratorManager.class)
public class NarratorManagerMixin {

    @Inject(method = "onModeChange(Lnet/minecraft/client/option/NarratorMode;)V", at = @At("HEAD"), cancellable = true)
    private void disableAccessibilityScreen(NarratorMode mode, CallbackInfo ci) {
        if(DisableAccessibilityScreenClient.narratorDisableFlag) {
            ci.cancel();
        }
    }


}
