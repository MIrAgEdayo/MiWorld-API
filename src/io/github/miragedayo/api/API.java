package io.github.miragedayo.api;

import io.github.miragedayo.MiWorld;
import org.bukkit.World;

public interface API {

    MiWorld.loadState load();
    boolean unload();
    boolean isWorldExist();
    World getWorld();
    boolean isLoaded();
}