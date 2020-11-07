package fr.mxlily.just2craft.spawnmobs.config;

import fr.mxlily.just2craft.spawnmobs.Main;
import org.bukkit.configuration.file.YamlConfiguration;

import java.util.List;


public class Config extends ConfigFile {
    public Config(Main main) {
        super(main, "config.yml");
    }

    // Configurations
    public static String TypeBlock;
    public static String Mobs;
    public static String Particules;



    // Initialisation
    protected void loadConfigurations(List<Configuration> configurations, YamlConfiguration config) {
        TypeBlock = (String) new Configuration("EMERALD_BLOCK", "block", configurations, config).getValue();
        Mobs = (String) new Configuration("WOLF", "mobs", configurations, config).getValue();
        Particules = (String) new Configuration("HEART", "part", configurations, config).getValue();
    }
}
