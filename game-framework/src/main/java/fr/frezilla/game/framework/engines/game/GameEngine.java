package fr.frezilla.game.framework.engines.game;

import fr.frezilla.game.framework.core.EngineEvent;
import fr.frezilla.game.framework.core.Game;
import fr.frezilla.game.framework.core.IEngine;

public class GameEngine implements IEngine {

    public GameEngine(Game g, Boolean p) {
        super(g, p);
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
