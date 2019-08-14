package fr.frezilla.game.framework.engines;

import fr.frezilla.game.framework.engines.sound.SoundEngine;
import fr.frezilla.game.framework.engines.graphic.GraphicEngine;
import fr.frezilla.game.framework.engines.game.GameEngine;
import fr.frezilla.game.framework.core.Engine;

public enum Engines {
    Game("game", GameEngine.class),
    Graphics("graphics", GraphicEngine.class),
    Network("network", GameEngine.class),
    Sound("sound", SoundEngine.class);
    
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
