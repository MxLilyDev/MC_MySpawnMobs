package fr.mxlily.just2craft.spawnmobs.config;

import fr.mxlily.just2craft.spawnmobs.Main;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public abstract class ConfigFile {
    private String filename;

    private List<Configuration> configurations;
    private Main main;
    private YamlConfiguration config;

    public ConfigFile(Main main, String filename) {
        this.main = main;
        this.filename = filename;
    }

    /**
     * Load variable
     */
    public void init() {
        // Get config file and create it if not exist
        File configFile = new File(main.getDataFolder(), filename);
        if (!configFile.exists()) {
            main.log(filename + " creating");
            this.createFile(configFile);
        }

        main.log(filename + " loading");
        this.load();

        main.log(filename + " saving");
        this.save();
    }

    /**
     * Reload configuration file
     */
    public void reload() {
        main.log(filename + " reloading");
        main.log(filename + " loading");
        this.load();

        main.log(filename + " saving");
        this.save();
    }

    /**
     * Register key for yaml for each variable
     */
    protected abstract void loadConfigurations(List<Configuration> configurations, YamlConfiguration config);

    /**
     * Create the file
     * @param configFile
     */
    private void createFile(File configFile) {
        try {
            // Creating file
            final boolean mkdir = main.getDataFolder().mkdir();
            final boolean newFile = configFile.createNewFile();
            if (!mkdir && !newFile)
                throw new IOException("Error during file creation");
        } catch (IOException e) {
            // Error print error and stop plugin
            main.error( "Couldn't create " + filename + " file : " + e);
            main.onDisable();
        }
    }

    /**
     * Load config
     */
    private void load() {
        // Clear or instantiate configurations list
        configurations = new ArrayList<>();

        // Load Yaml configuration
        File configFile = new File(main.getDataFolder(), filename);
        config = YamlConfiguration.loadConfiguration(configFile);

        // Load configurations
        this.loadConfigurations(configurations, config);
    }

    /**
     * Save Yaml config file
     */
    private void save() {
        try {
            File configFile = new File(main.getDataFolder(), filename);
            config.save(configFile);
        } catch (IOException e) {
            main.log("Failed to save config.yml : " + e);
        }
    }
}
