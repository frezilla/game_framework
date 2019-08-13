package fr.frezilla.game.framework.engines;

import fr.frezilla.game.framework.core.Engine;
import fr.frezilla.game.framework.core.EngineEvent;
import fr.frezilla.game.framework.core.Game;

public class GameEngine extends Engine {

    public GameEngine(Game g, Boolean p) {
        super(g, p);
    }

    @Override
    public void frame() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void processEvent(EngineEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
