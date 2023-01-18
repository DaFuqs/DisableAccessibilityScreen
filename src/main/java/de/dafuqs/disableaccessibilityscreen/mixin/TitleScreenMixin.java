package de.dafuqs.disableaccessibilityscreen.mixin;

import net.minecraft.client.gui.screen.*;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.*;

@Mixin(TitleScreen.class)
public class TitleScreenMixin {

    @ModifyArg(at = @At(value = "INVOKE", target = ""), method = "init", index = 0)
    private int disableaccessibilityscreen(int value) {
        return value;
    }

}
