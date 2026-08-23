package org.hp.buff_particle_remover.client;

// 这个状态只在当前线程记录 Buff tick 内的粒子抑制嵌套层数。
public final class ParticleSuppressionState {
    private static final ThreadLocal<Integer> DEPTH = ThreadLocal.withInitial(() -> 0);

    private ParticleSuppressionState() {
    }

    // 进入本地玩家第一人称 Buff tick 的粒子抑制范围。
    public static void enter() {
        DEPTH.set(DEPTH.get() + 1);
    }

    // 离开粒子抑制范围，并清理当前线程不再需要的状态。
    public static void exit() {
        int depth = DEPTH.get();
        if (depth <= 1) {
            DEPTH.remove();
        } else {
            DEPTH.set(depth - 1);
        }
    }

    // 判断当前粒子调用是否发生在需要隐藏的 Buff tick 内。
    public static boolean isActive() {
        return DEPTH.get() > 0;
    }
}
