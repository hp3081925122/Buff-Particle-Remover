package org.hp.buff_particle_remover.mixin.client;

import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.LivingEntity;
import org.hp.buff_particle_remover.client.ParticleSuppressionState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

// 在本地玩家第一人称更新 Buff 时建立粒子抑制上下文。
@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin {
    @Unique
    private int buff_particle_remover$suppressionDepth;

    // 在 Buff tick 开始时只为当前客户端玩家的第一人称开启抑制范围。
    @Inject(method = "tickEffects", at = @At("HEAD"), remap = false)
    private void buff_particle_remover$beginSuppression(CallbackInfo callbackInfo) {
        Minecraft minecraft = Minecraft.getInstance();
        if ((Object) this == minecraft.player && minecraft.options.getCameraType().isFirstPerson()) {
            ParticleSuppressionState.enter();
            this.buff_particle_remover$suppressionDepth++;
        }
    }

    // 在 Buff tick 正常返回时关闭当前实体对应的抑制范围。
    @Inject(method = "tickEffects", at = @At("RETURN"), remap = false)
    private void buff_particle_remover$endSuppression(CallbackInfo callbackInfo) {
        if (this.buff_particle_remover$suppressionDepth > 0) {
            ParticleSuppressionState.exit();
            this.buff_particle_remover$suppressionDepth--;
        }
    }
}
