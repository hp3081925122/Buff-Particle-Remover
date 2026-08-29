package org.hp.buff_particle_remover;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import org.hp.buff_particle_remover.client.ClientConfig;

// 这个入口只负责让 Forge 加载模组，具体的客户端渲染修改由客户端 Mixin 完成。
@Mod(Buff_particle_remover.MODID)
public final class Buff_particle_remover {
    // 模组 ID 必须与 mods.toml 和 Mixin 配置中的命名空间保持一致。
    public static final String MODID = "buff_particle_remover";

    // 保留 Forge 所需的无参模组入口，不注册任何服务端内容。
    public Buff_particle_remover() {
        // 注册客户端配置，使配置文件默认开启第一人称火焰移除。
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, ClientConfig.SPEC);
    }
}
