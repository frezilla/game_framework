package fr.frezilla.game.framework.engines.network;

import fr.frezilla.game.framework.core.Engine;
import fr.frezilla.game.framework.core.EngineEvent;
import fr.frezilla.game.framework.core.Game;

public class NetworkEngine extends Engine {

    public NetworkEngine(Game g, Boolean p) {
        super(g, p);
    }

    @Override
    protected void frame() {
        System.out.println("NetworkEngine.frame()");
    }

    @Override
    protected void processEvent(EngineEvent e) {
        System.out.println("Network.processEvent()");
    }
    
}
