package rmc.mixins.wecui_prefer_mod;

import java.util.Map;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import com.sk89q.worldedit.extension.platform.Capability;
import com.sk89q.worldedit.extension.platform.Preference;

/**
 * Developed by RMC Team, 2021
 */
@Mixin(targets = "com.sk89q.worldedit.forge.ForgePlatform")
public abstract class ForgePlatformMixin {

    @Inject(method = "Lcom/sk89q/worldedit/forge/ForgePlatform;getCapabilities()Ljava/util/Map;",
            remap = false,
            locals = LocalCapture.CAPTURE_FAILEXCEPTION,
            at = @At(value = "TAIL"))
    private void injectGetCapabilities(CallbackInfoReturnable<?> mixin, Map<Capability, Preference> capabilities) {
        capabilities.put(Capability.WORLDEDIT_CUI, Preference.PREFERRED);
    }

}