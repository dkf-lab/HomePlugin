package me.dkflab.homeplugin.listeners;

import me.dkflab.homeplugin.HomePlugin;
import me.dkflab.homeplugin.Utils;
import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.potion.PotionEffect;

import static me.dkflab.homeplugin.Utils.*;

public class Death implements Listener {

    private HomePlugin main;
    public Death(HomePlugin main) {
        this.main = main;
    }

    @EventHandler
    public void onDeath(PlayerDeathEvent e) {
        Player p = e.getPlayer();
        e.setCancelled(true);
        p.getInventory().clear();
        p.getInventory().setHelmet(null);
        p.getInventory().setChestplate(null);
        p.getInventory().setLeggings(null);
        p.getInventory().setBoots(null);
        for (PotionEffect effect: p.getActivePotionEffects()) {
            p.removePotionEffect(effect.getType());
        }
        p.setHealth(p.getMaxHealth());
        p.setFoodLevel(20);
        p.setSaturation(20);
        p.setFireTicks(0);
        main.resetHome(p.getUniqueId());
        // title
        p.sendTitle(color("&c&lYou Died!"), color("&7Better luck next time."), 20, 40, 20);
        // rtp
        ConsoleCommandSender c = Bukkit.getConsoleSender();
        Bukkit.dispatchCommand(c, "rtp player " + p.getName() + " world");
    }
}
