package org.hp.buff_particle_remover;

import net.fabricmc.api.ModInitializer;

// 这个入口只负责让 Fabric 加载模组，具体的客户端粒子过滤由客户端 Mixin 完成。
public final class Buff_particle_remover implements ModInitializer {
    // 模组 ID 必须与 fabric.mod.json 和 Mixin 配置中的命名空间保持一致。
    public static final String MODID = "buff_particle_remover";

    // 该模组没有通用服务端初始化内容。
    @Override
    public void onInitialize() {
    }
}
