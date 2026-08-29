package org.hp.buff_particle_remover;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;

// 这个入口只负责让 NeoForge 加载模组，具体的客户端粒子过滤由客户端 Mixin 完成。
@Mod(Buff_particle_remover.MODID)
public final class Buff_particle_remover {
    // 模组 ID 必须与 NeoForge 元数据和 Mixin 配置中的命名空间保持一致。
    public static final String MODID = "buff_particle_remover";

    // 使用 NeoForge 26.1.2 的模组构造器签名，不注册服务端内容。
    public Buff_particle_remover(IEventBus modEventBus, ModContainer modContainer) {
    }
}
