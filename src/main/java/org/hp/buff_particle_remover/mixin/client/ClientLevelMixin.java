package org.hp.buff_particle_remover.mixin.client;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.particles.ParticleOptions;
import org.hp.buff_particle_remover.client.ParticleSuppressionState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

// 过滤本地玩家 Buff tick 同步触发的客户端粒子生成入口。
@Mixin(ClientLevel.class)
public abstract class ClientLevelMixin {
    // 过滤普通的六参数粒子生成调用。
    @Inject(method = "addParticle(Lnet/minecraft/core/particles/ParticleOptions;DDDDDD)V", at = @At("HEAD"), cancellable = true, remap = false)
    private void buff_particle_remover$cancelParticle(ParticleOptions particleOptions, double x, double y, double z, double xd, double yd, double zd, CallbackInfo callbackInfo) {
        if (ParticleSuppressionState.isActive()) {
            callbackInfo.cancel();
        }
    }

    // 过滤带粒子限制参数的生成调用。
    @Inject(method = "addParticle(Lnet/minecraft/core/particles/ParticleOptions;ZDDDDDD)V", at = @At("HEAD"), cancellable = true, remap = false)
    private void buff_particle_remover$cancelLimitedParticle(ParticleOptions particleOptions, boolean overrideLimiter, double x, double y, double z, double xd, double yd, double zd, CallbackInfo callbackInfo) {
        if (ParticleSuppressionState.isActive()) {
            callbackInfo.cancel();
        }
    }

    // 过滤始终可见的六参数粒子生成调用。
    @Inject(method = "addAlwaysVisibleParticle(Lnet/minecraft/core/particles/ParticleOptions;DDDDDD)V", at = @At("HEAD"), cancellable = true, remap = false)
    private void buff_particle_remover$cancelAlwaysVisibleParticle(ParticleOptions particleOptions, double x, double y, double z, double xd, double yd, double zd, CallbackInfo callbackInfo) {
        if (ParticleSuppressionState.isActive()) {
            callbackInfo.cancel();
        }
    }

    // 过滤带粒子限制参数的始终可见粒子生成调用。
    @Inject(method = "addAlwaysVisibleParticle(Lnet/minecraft/core/particles/ParticleOptions;ZDDDDDD)V", at = @At("HEAD"), cancellable = true, remap = false)
    private void buff_particle_remover$cancelLimitedAlwaysVisibleParticle(ParticleOptions particleOptions, boolean overrideLimiter, double x, double y, double z, double xd, double yd, double zd, CallbackInfo callbackInfo) {
        if (ParticleSuppressionState.isActive()) {
            callbackInfo.cancel();
        }
    }
}
