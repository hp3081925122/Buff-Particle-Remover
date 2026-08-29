package org.hp.buff_particle_remover.client;

import net.fabricmc.loader.api.FabricLoader;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Pattern;

// 读取 Fabric 客户端配置，并在缺少配置文件时写入默认开启值。
public final class ClientConfig {
    private static final String DEFAULT_CONFIG = "{\n  \"remove_first_person_fire\": true\n}\n";
    private static final Pattern ENABLED_VALUE = Pattern.compile("\\\"remove_first_person_fire\\\"\\s*:\\s*true");
    private static final boolean REMOVE_FIRST_PERSON_FIRE = load();

    private ClientConfig() {
    }

    // 返回是否隐藏玩家着火时的第一人称火焰覆盖层。
    public static boolean isRemoveFirstPersonFireEnabled() {
        return REMOVE_FIRST_PERSON_FIRE;
    }

    // 读取配置文件并在首次运行时创建默认配置。
    private static boolean load() {
        Path configPath = FabricLoader.getInstance().getConfigDir().resolve("buff_particle_remover.json");
        try {
            if (Files.notExists(configPath)) {
                Files.writeString(configPath, DEFAULT_CONFIG, StandardCharsets.UTF_8);
                return true;
            }
            return ENABLED_VALUE.matcher(Files.readString(configPath, StandardCharsets.UTF_8)).find();
        } catch (IOException exception) {
            return false;
        }
    }
}
