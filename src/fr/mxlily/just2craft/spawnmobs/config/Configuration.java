package fr.mxlily.just2craft.spawnmobs.config;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.craftbukkit.libs.jline.internal.Log;

import java.util.List;

public class Configuration {
    private Object defaultValue;
    private Object value;
    private String key;

    private YamlConfiguration config;

    public Configuration(Object defaultValue, String key, List<Configuration> configurations, YamlConfiguration config) {
        this.defaultValue = defaultValue;
        this.key = key;
        this.config = config;
        this.setValue();
        configurations.add(this);
    }

    private void setValue() {
        value = config.get(key);
        // Fill value if not exist
        if(value == null) {
            config.set(key, defaultValue);
        }

        // Check the value in config is in good format
        else if(!value.getClass().equals(defaultValue.getClass())) {
            Log.error("Attempted to give " + value.getClass() + " object for '" + key + "' value. Needed " + defaultValue.getClass() + " object.");
            value = defaultValue;
            config.set(key, defaultValue);
        }
    }

    public Object getValue() {
        return value;
    }
}
