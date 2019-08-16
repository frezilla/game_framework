package fr.frezilla.game.framework.engines.ihm;

import fr.frezilla.game.framework.core.Engine;
import fr.frezilla.game.framework.core.EngineEvent;
import fr.frezilla.game.framework.core.Game;

public class IhmEngine extends Engine {
    
    public IhmEngine(Game g, Boolean p) {
        super(g, p);
    }

    @Override
    protected void frame() {
        System.out.println("GraphicEngine.frame()");
    }

    @Override
    protected void processEvent(EngineEvent e) {
        System.out.println("GraphicEngine.processEvent()");
    }
}
