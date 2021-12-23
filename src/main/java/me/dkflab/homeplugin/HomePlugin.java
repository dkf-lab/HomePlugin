package me.dkflab.homeplugin;

import me.dkflab.homeplugin.commands.Delhome;
import me.dkflab.homeplugin.commands.Home;
import me.dkflab.homeplugin.commands.Sethome;
import me.dkflab.homeplugin.listeners.Death;
import org.bukkit.Location;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public final class HomePlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        saveDefaultConfig();
        getCommand("delhome").setExecutor(new Delhome(this));
        getCommand("sethome").setExecutor(new Sethome(this));
        getCommand("home").setExecutor(new Home(this));
        getServer().getPluginManager().registerEvents(new Death(this),this);
    }

    public Location getHome(@NotNull UUID uuid) {
        Location loc = getConfig().getLocation(uuid.toString());
        if (loc == null) {
            loc = new Location(getServer().getWorld("lobby"), 0, 80, 0);
        }
        return loc;
    }

    public void setHome(@NotNull UUID uuid, @NotNull Location loc) {
        getConfig().set(uuid.toString(), loc);
        saveConfig();
    }

    public void resetHome(@NotNull UUID uuid) {
        setHome(uuid, new Location(getServer().getWorld("lobby"), 0, 80, 0));
    }
}
