package fr.frezilla.game.framework.engines.game;

import fr.frezilla.game.framework.core.Engine;
import fr.frezilla.game.framework.core.EngineEvent;

public class GameEngine extends Engine {

    public GameEngine(Boolean p) {
        super(p);
    }

    @Override
    protected void afterLoop() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void beforeLoop() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void destroy() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
