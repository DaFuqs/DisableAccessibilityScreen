package de.dafuqs.disableaccessibilityscreen.mixin;

import de.dafuqs.disableaccessibilityscreen.client.*;
import net.minecraft.*;
import net.minecraft.client.*;
import net.minecraft.client.gui.screen.*;
import net.minecraft.client.option.*;
import org.jetbrains.annotations.*;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.*;

@Mixin(MinecraftClient.class)
public abstract class MinecraftClientMixin {

    @Shadow public abstract void setScreen(@Nullable Screen screen);

    // disable onboardAccessibility
    @Inject(method = "setScreen(Lnet/minecraft/client/gui/screen/Screen;)V", at = @At("HEAD"), cancellable = true)
    private void disableAccessibilityScreen(@Nullable Screen screen, CallbackInfo ci) {
        if(screen instanceof class_8032) {
            // disable the narrator
            DisableAccessibilityScreenClient.narratorDisableFlag = true;
            MinecraftClient.getInstance().options.getNarrator().setValue(NarratorMode.OFF);
            DisableAccessibilityScreenClient.narratorDisableFlag = false;

            // load title screen instead
            this.setScreen(new TitleScreen(true));
            ci.cancel();
        }

    }

}
