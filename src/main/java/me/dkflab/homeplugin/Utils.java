package me.dkflab.homeplugin;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class Utils {

    public static String color(String s) {
        return ChatColor.translateAlternateColorCodes('&',s);
    }

    public static void sendMessage(CommandSender sender, String message) {
        sender.sendMessage(color(message));
    }

    public static void notAPlayer(CommandSender sender) {
        sendMessage(sender, "&cYou need to be a player!");
    }
}
