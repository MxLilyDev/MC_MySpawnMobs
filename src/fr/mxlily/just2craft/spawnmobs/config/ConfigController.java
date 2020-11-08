package fr.mxlily.just2craft.spawnmobs.config;

import fr.mxlily.just2craft.spawnmobs.Main;

public class ConfigController {
    public Main main;
    public Config config;
    public Lang lang;

    public ConfigController(Main main) {
        this.main = main;
    }


    public void init() {
        config = new Config(main);
        lang = new Lang(main);

        config.init();
        lang.init();
    }

    public void reload() {
        config.reload();
        lang.reload();
    }
}
