package me.GamingMaster0211.OPS;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class OPSMain extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this);
        getLogger().info("OPS loaded!");
    }

    @EventHandler
    public void onBedEnter(PlayerBedEnterEvent event) {
        if (event.getBedEnterResult() != PlayerBedEnterEvent.BedEnterResult.OK) return;

        World world = event.getPlayer().getWorld();

        long time = world.getTime();
        if (time < 12541 || time > 23458) return;

        world.setTime(1000);
        world.setStorm(false);
        world.setThundering(false);
    }
}
