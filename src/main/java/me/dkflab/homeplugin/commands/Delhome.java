package me.dkflab.homeplugin.commands;

import me.dkflab.homeplugin.HomePlugin;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import static me.dkflab.homeplugin.Utils.notAPlayer;
import static me.dkflab.homeplugin.Utils.sendMessage;

public class Delhome implements CommandExecutor {

    private HomePlugin main;
    public Delhome(HomePlugin main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player)) {
            notAPlayer(sender);
            return true;
        }
        Player p = (Player) sender;
        main.resetHome(p.getUniqueId());
        sendMessage(p, "&a&lSuccess! &7Home reset.");
        return true;
    }
}
