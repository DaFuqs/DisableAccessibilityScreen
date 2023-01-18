package de.dafuqs.disableaccessibilityscreen.client;

import net.fabricmc.api.*;

@Environment(EnvType.CLIENT)
public class DisableAccessibilityScreenClient implements ClientModInitializer {

    public static boolean narratorDisableFlag = false;

    @Override
    public void onInitializeClient() {

    }


}
