package org.hp.buff_particle_remover;

import net.fabricmc.api.ModInitializer;
import org.hp.buff_particle_remover.client.ClientConfig;

// 这个入口只负责让 Fabric Loader 加载客户端粒子隐藏功能。
public final class Buff_particle_remover implements ModInitializer {
    // 模组 ID 必须与 fabric.mod.json 和 Mixin 配置中的命名空间一致。
    public static final String MODID = "buff_particle_remover";

    // 本模组没有服务端注册内容，初始化阶段无需执行额外逻辑。
    @Override
    public void onInitialize() {
        // 在客户端初始化阶段创建配置文件，并保持默认开启第一人称火焰移除。
        ClientConfig.isRemoveFirstPersonFireEnabled();
    }
}
