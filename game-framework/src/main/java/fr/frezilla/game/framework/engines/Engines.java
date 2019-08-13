package fr.frezilla.game.framework.engines;

import fr.frezilla.game.framework.core.Engine;

public enum Engines {
    Game("game", GameEngine.class),
    Graphics("graphics", GameEngine.class),
    Network("network", GameEngine.class),
    Sound("sound", GameEngine.class);
    
    private final String name;
    private final Class<? extends Engine> engineClass;
    
    private Engines(String name, Class<? extends Engine> engineClass) {
        this.name = name;
        this.engineClass = engineClass;
    }
    
    public String getName() {
        return name;
    }
    
    public Class<? extends Engine> getEngineClass() {
        return engineClass;
    }
}
