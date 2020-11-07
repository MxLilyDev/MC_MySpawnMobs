package fr.mxlily.just2craft.spawnmobs;

import fr.mxlily.just2craft.spawnmobs.config.ConfigController;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;


public final class Main extends JavaPlugin implements Listener {
    public void onEnable() {
        System.out.println("========== MYMOBS ==========");
        System.out.println("\tSTART");
        System.out.println("========== MYMOBS ==========");
        (new ConfigController(this)).init();
        log("Load Config files");
        getServer().getPluginManager().registerEvents( new Event(), this);
    }



    @Override
    public void onDisable() {
        System.out.println("========== MYMOBS ==========");
        System.out.println("\tSTOP");
        System.out.println("========== MYMOBS ==========");
    }

    /**
     * Log functions
     */

    public void log(String message) {
        this.getLogger().info("[MYMOBS] " + message);
    }

    public void error(String message) {
        this.getLogger().info("Error: " + message);
    }
}
