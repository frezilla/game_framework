package fr.frezilla.game.framework.engines.ihm;

import fr.frezilla.game.framework.core.EngineEvent;
import fr.frezilla.game.framework.engines.GenericEngine;

public class IhmEngine extends GenericEngine {
    
    public IhmEngine(Boolean p) {
        super(p);
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
