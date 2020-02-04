package fr.frezilla.game.framework.engines.network;

import fr.frezilla.game.framework.core.EngineEvent;
import fr.frezilla.game.framework.engines.GenericEngine;

public class NetworkEngine extends GenericEngine {

    public NetworkEngine(Boolean p) {
        super(p);
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
