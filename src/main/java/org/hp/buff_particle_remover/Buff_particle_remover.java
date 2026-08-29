package org.hp.buff_particle_remover;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;

// 这个入口只负责让 NeoForge 加载模组，具体的客户端渲染修改由客户端 Mixin 完成。
@Mod(Buff_particle_remover.MODID)
public final class Buff_particle_remover {
    // 模组 ID 必须与 neoforge.mods.toml 和 Mixin 配置中的命名空间保持一致。
    public static final String MODID = "buff_particle_remover";

    // 使用 NeoForge 注入的总线和容器完成最小模组初始化。
    public Buff_particle_remover(IEventBus modEventBus, ModContainer modContainer) {
    }
}
