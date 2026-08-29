package org.hp.buff_particle_remover.mixin.client;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.particles.ParticleOptions;
import org.hp.buff_particle_remover.client.ParticleSuppressionState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

// 过滤本地玩家第一人称 Buff tick 同步触发的客户端粒子生成入口。
@Mixin(ClientLevel.class)
public abstract class ClientLevelMixin {
    // 过滤普通六参数粒子生成调用。
    @Inject(method = "addParticle(Lnet/minecraft/core/particles/ParticleOptions;DDDDDD)V", at = @At("HEAD"), cancellable = true)
    private void buff_particle_remover$cancelParticle(ParticleOptions particle, double x, double y, double z, double xd, double yd, double zd, CallbackInfo callbackInfo) {
        if (ParticleSuppressionState.isActive()) {
            callbackInfo.cancel();
        }
    }

    // 过滤 26.1.2 新增 alwaysShow 参数的双布尔粒子生成调用。
    @Inject(method = "addParticle(Lnet/minecraft/core/particles/ParticleOptions;ZZDDDDDD)V", at = @At("HEAD"), cancellable = true)
    private void buff_particle_remover$cancelParticleWithVisibility(ParticleOptions particle, boolean overrideLimiter, boolean alwaysShow, double x, double y, double z, double xd, double yd, double zd, CallbackInfo callbackInfo) {
        if (ParticleSuppressionState.isActive()) {
            callbackInfo.cancel();
        }
    }

    // 过滤始终可见的普通粒子生成调用。
    @Inject(method = "addAlwaysVisibleParticle(Lnet/minecraft/core/particles/ParticleOptions;DDDDDD)V", at = @At("HEAD"), cancellable = true)
    private void buff_particle_remover$cancelAlwaysVisibleParticle(ParticleOptions particle, double x, double y, double z, double xd, double yd, double zd, CallbackInfo callbackInfo) {
        if (ParticleSuppressionState.isActive()) {
            callbackInfo.cancel();
        }
    }

    // 过滤始终可见且带限制参数的粒子生成调用。
    @Inject(method = "addAlwaysVisibleParticle(Lnet/minecraft/core/particles/ParticleOptions;ZDDDDDD)V", at = @At("HEAD"), cancellable = true)
    private void buff_particle_remover$cancelLimitedAlwaysVisibleParticle(ParticleOptions particle, boolean overrideLimiter, double x, double y, double z, double xd, double yd, double zd, CallbackInfo callbackInfo) {
        if (ParticleSuppressionState.isActive()) {
            callbackInfo.cancel();
        }
    }
}
