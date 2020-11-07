package fr.mxlily.just2craft.spawnmobs;

import fr.mxlily.just2craft.spawnmobs.config.Config;
import fr.mxlily.just2craft.spawnmobs.config.Lang;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;


public class Event implements Listener {

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        Action action = event.getAction();
        Player player = event.getPlayer();
        Block block = event.getClickedBlock();
        Location location = player.getLocation();
        String mobName = Config.Mobs;
        World w = player.getWorld();
        if (action.equals(Action.LEFT_CLICK_BLOCK)) {
            if (block.getType().equals(Material.valueOf(Config.TypeBlock))) {
                w.spawnEntity(location, EntityType.valueOf(mobName));
                player.sendMessage(Lang.SpawnMobMessage.replace("%mob%", mobName.toLowerCase()));
                location.getWorld().spawnParticle(Particle.valueOf(Config.Particules), location, 16, 0.2F, 1F, 0.2F);

            }
        }
    }
}