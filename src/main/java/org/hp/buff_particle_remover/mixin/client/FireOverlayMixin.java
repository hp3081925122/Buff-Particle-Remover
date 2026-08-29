package org.hp.buff_particle_remover.mixin.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ScreenEffectRenderer;
import org.hp.buff_particle_remover.client.ClientConfig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

// 根据客户端配置隐藏玩家着火时的第一人称火焰覆盖层。
@Mixin(ScreenEffectRenderer.class)
public abstract class FireOverlayMixin {
    // 只拦截原版火焰覆盖层绘制，不影响其他屏幕覆盖层和玩家着火状态。
    @Inject(method = "renderFire", at = @At("HEAD"), cancellable = true)
    private static void buff_particle_remover$cancelFireOverlay(Minecraft minecraft, PoseStack poseStack, CallbackInfo callbackInfo) {
        if (ClientConfig.isRemoveFirstPersonFireEnabled()) {
            callbackInfo.cancel();
        }
    }
}
