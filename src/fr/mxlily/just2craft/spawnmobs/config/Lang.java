package fr.mxlily.just2craft.spawnmobs.config;
import fr.mxlily.just2craft.spawnmobs.Main;
import org.bukkit.configuration.file.YamlConfiguration;

import java.util.List;


public class Lang extends ConfigFile {
    public Lang(Main main) {
        super(main, "lang.yml");
    }

    // Configurations
    public static String SpawnMobMessage;

    protected void loadConfigurations(List<Configuration> configurations, YamlConfiguration config) {
        SpawnMobMessage = (String) new Configuration("§3§oPrenez garde ! Un %mob% vient d'apparaître près de vous !","player.message.fusionitem", configurations, config).getValue();
    }
}