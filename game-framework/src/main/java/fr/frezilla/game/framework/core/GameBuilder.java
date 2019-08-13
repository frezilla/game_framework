package fr.frezilla.game.framework.core;

import fr.frezilla.game.framework.engines.Engines;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.tuple.Pair;

@NoArgsConstructor
public class GameBuilder {
    
    public static Game build() {
        Engines[] engines = Engines.values();
        int nbEngines = engines.length;
        Game g;
        
        if (nbEngines == 0) {
            g = null;
        } else {
            g = new Game();
            try {
                for (int i = 0; i < nbEngines; i++) {
                    if (engines[i] != null) {
                        Engines e = engines[i];
                        Class<? extends Engine> engineClass = e.getEngineClass();
                        Constructor<? extends Engine> constructor = engineClass.getConstructor(Game.class, Boolean.class);
                        g.addEngine(
                                Pair.of(
                                        e.getName(), 
                                        constructor.newInstance(g, false)
                                )
                        );
                    }
                }
            } catch (IllegalAccessException | InstantiationException | InvocationTargetException | NoSuchMethodException e) {
                g = null;
            }
        }
        
        return g;
    }
    
}
