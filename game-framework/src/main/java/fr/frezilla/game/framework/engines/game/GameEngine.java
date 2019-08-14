package fr.frezilla.game.framework.engines.game;

import fr.frezilla.game.framework.core.Engine;
import fr.frezilla.game.framework.core.EngineEvent;
import fr.frezilla.game.framework.core.Game;

public class GameEngine extends Engine {

    public GameEngine(Game g, Boolean p) {
        super(g, p);
    }

    @Override
    public void end() {
        System.out.println("GameEngine.end");
    }

    @Override
    public void frame() {
        System.out.println("GameEngine.frame");
    }

    @Override
    protected void processEvent(EngineEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
