package me.dkflab.homeplugin.commands;

import me.dkflab.homeplugin.HomePlugin;
import me.dkflab.homeplugin.Utils;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import static me.dkflab.homeplugin.Utils.*;

public class Home implements CommandExecutor {

    private HomePlugin main;
    public Home(HomePlugin main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player)) {
            notAPlayer(sender);
            return true;
        }
        Player p = (Player) sender;
        p.teleport(main.getHome(p.getUniqueId()));
        p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_BELL, 1, 1);
        sendMessage(p, "&aTeleporting...");
        return true;
    }
}
