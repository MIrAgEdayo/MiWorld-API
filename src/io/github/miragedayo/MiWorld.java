package io.github.miragedayo;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class MiWorld extends JavaPlugin {

    private final String prefix = "[MiWorld-API] ";

    public void onEnable() {

        Bukkit.getLogger().info(prefix + "Enabled plugin.");
    }

    public void onDisable() {

        Bukkit.getLogger().info(prefix + "Disabled plugin.");
    }

    public enum loadState {

        SUCCESS,
        ALREADY_LOADED,
        NOT_FOUND_WORLD,
        CANNOT_LOAD
    }
}