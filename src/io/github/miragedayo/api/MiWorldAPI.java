package io.github.miragedayo.api;

import io.github.miragedayo.MiWorld;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.generator.ChunkGenerator;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MiWorldAPI implements API {

    private String worldName;

    public MiWorldAPI(String worldName) {

        this.worldName = worldName;
    }

    public MiWorld.loadState load() {

        if (isLoaded())
            return MiWorld.loadState.ALREADY_LOADED;

        if (!isWorldExist())
            return MiWorld.loadState.NOT_FOUND_WORLD;

        WorldCreator worldCreator = new WorldCreator(this.worldName);
        worldCreator
                .environment(World.Environment.NORMAL)
                .generateStructures(false)
                .seed(0)
                .generator(getGenerator(this.worldName));
        World world = Bukkit.createWorld(worldCreator);

        if (world == null)
            return MiWorld.loadState.CANNOT_LOAD;

        return MiWorld.loadState.SUCCESS;
    }

    public boolean unload() {

        World world = getWorld();
        if (world == null)
            return false;

        return Bukkit.unloadWorld(world, world.isAutoSave());
    }

    public boolean isWorldExist() {

        File container = Bukkit.getWorldContainer();
        String absolutePathpath = container.getAbsolutePath();
        String path = absolutePathpath.substring(0, (absolutePathpath.length()) - 1);
        File world = new File(path + this.worldName);
        List<File> files = new ArrayList<>();
        Bukkit.broadcastMessage(container.getAbsolutePath() + "  :  " + world.getAbsolutePath());

        if (world.listFiles() != null) {

            Arrays.stream(world.listFiles())
                    .filter(File::isDirectory)
                    .forEach(files::add);

            Bukkit.broadcastMessage(files.toString());

            if (files.contains(new File(path + this.worldName + "/region"))) {
                return true;
            }

            if (files.contains(new File(path + this.worldName + "/DMI-1"))) {
                return true;
            }

            if (files.contains(new File(path + this.worldName + "/DMI1"))) {
                return true;
            }
        }

        return false;
    }

    public World getWorld() {

        return Bukkit.getWorld(this.worldName);
    }

    public boolean isLoaded() {

        return getWorld() != null;
    }

    private ChunkGenerator getGenerator(String generator) {

        if(generator == null)
            return null;

        return WorldCreator.getGeneratorForName(this.worldName, generator, null);
    }
}