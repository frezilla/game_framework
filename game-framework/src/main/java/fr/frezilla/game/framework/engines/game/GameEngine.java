package fr.frezilla.game.framework.engines.game;

import fr.frezilla.game.framework.core.EngineEvent;
import fr.frezilla.game.framework.engines.GenericEngine;

public class GameEngine extends GenericEngine {

    public GameEngine(Boolean p) {
        super(p);
    }

    @Override
    protected void frame() {
        System.out.println("GameEngine.frame()");
    }

    @Override
    protected void processEvent(EngineEvent e) {
        System.out.println("GameEngine.processEvent()");
    }
}
