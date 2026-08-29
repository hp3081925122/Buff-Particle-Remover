package org.hp.buff_particle_remover.client;

import net.minecraftforge.common.ForgeConfigSpec;

// 定义 Forge 客户端配置，并将第一人称火焰移除默认设为关闭。
public final class ClientConfig {
    public static final ForgeConfigSpec SPEC;
    public static final ForgeConfigSpec.BooleanValue REMOVE_FIRST_PERSON_FIRE;

    static {
        ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();
        REMOVE_FIRST_PERSON_FIRE = builder
                .comment("移除玩家着火时的第一人称火焰覆盖层。", "Remove the first-person fire overlay when the player is on fire.")
                .define("remove_first_person_fire", true);
        SPEC = builder.build();
    }

    private ClientConfig() {
    }

    // 返回是否隐藏玩家着火时的第一人称火焰覆盖层。
    public static boolean isRemoveFirstPersonFireEnabled() {
        return REMOVE_FIRST_PERSON_FIRE.get();
    }
}
