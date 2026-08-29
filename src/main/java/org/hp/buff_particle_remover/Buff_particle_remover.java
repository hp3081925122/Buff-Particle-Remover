package org.hp.buff_particle_remover;

import net.fabricmc.api.ModInitializer;

// 这个入口只负责让 Fabric 加载客户端模组，具体的粒子过滤由客户端 Mixin 完成。
public final class Buff_particle_remover implements ModInitializer {
    // 模组 ID 必须与 fabric.mod.json 和 Mixin 配置中的命名空间一致。
    public static final String MODID = "buff_particle_remover";

    // Fabric 初始化时不注册服务端内容，保留空的通用入口以满足模组元数据要求。
    @Override
    public void onInitialize() {
    }
}
