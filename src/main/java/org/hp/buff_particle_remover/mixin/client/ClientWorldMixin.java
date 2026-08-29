package org.hp.buff_particle_remover.mixin.client;

import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.ParticleEffect;
import org.hp.buff_particle_remover.client.ParticleSuppressionState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

// 过滤本地玩家状态效果 tick 同步触发的客户端粒子生成入口。
@Mixin(ClientWorld.class)
public abstract class ClientWorldMixin {
    // 过滤普通的六参数粒子生成调用。
    @Inject(method = "addParticle(Lnet/minecraft/particle/ParticleEffect;DDDDDD)V", at = @At("HEAD"), cancellable = true)
    private void buff_particle_remover$cancelParticle(ParticleEffect particleEffect, double x, double y, double z, double xd, double yd, double zd, CallbackInfo callbackInfo) {
        if (ParticleSuppressionState.isActive()) {
            callbackInfo.cancel();
        }
    }

    // 过滤带粒子限制参数的生成调用。
    @Inject(method = "addParticle(Lnet/minecraft/particle/ParticleEffect;ZDDDDDD)V", at = @At("HEAD"), cancellable = true)
    private void buff_particle_remover$cancelLimitedParticle(ParticleEffect particleEffect, boolean overrideLimiter, double x, double y, double z, double xd, double yd, double zd, CallbackInfo callbackInfo) {
        if (ParticleSuppressionState.isActive()) {
            callbackInfo.cancel();
        }
    }

    // 过滤普通的始终可见粒子生成调用。
    @Inject(method = "addImportantParticle(Lnet/minecraft/particle/ParticleEffect;DDDDDD)V", at = @At("HEAD"), cancellable = true)
    private void buff_particle_remover$cancelImportantParticle(ParticleEffect particleEffect, double x, double y, double z, double xd, double yd, double zd, CallbackInfo callbackInfo) {
        if (ParticleSuppressionState.isActive()) {
            callbackInfo.cancel();
        }
    }

    // 过滤带粒子限制参数的始终可见粒子生成调用。
    @Inject(method = "addImportantParticle(Lnet/minecraft/particle/ParticleEffect;ZDDDDDD)V", at = @At("HEAD"), cancellable = true)
    private void buff_particle_remover$cancelLimitedImportantParticle(ParticleEffect particleEffect, boolean overrideLimiter, double x, double y, double z, double xd, double yd, double zd, CallbackInfo callbackInfo) {
        if (ParticleSuppressionState.isActive()) {
            callbackInfo.cancel();
        }
    }
}
