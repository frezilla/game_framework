package fr.frezilla.game.framework.core;

import fr.frezilla.game.framework.ds.FifoQueue;
import lombok.NonNull;

public abstract class Engine {
    
    final Game game;
    private final FifoQueue<EngineEvent> eventsQueue;
    
    public Engine(Game g) {
        eventsQueue = FifoQueue.newInstance();
        game = g;
    }
    
    public abstract void frame();
    
    protected abstract void processEvent(EngineEvent e);
    
    public void processQueue() {
        while (!eventsQueue.isEmpty()) {
           EngineEvent e = eventsQueue.pop();
           processEvent(e);
        }
    }
    
    void pushEvent(EngineEvent e) {
        eventsQueue.push(e);
    }
    
    protected final void sendMessageTo(@NonNull String engineName, @NonNull EngineEvent evt) {
        game.dispatchMessage(engineName, evt);
    }
    
    protected final void sendStopGameRequest() {
        game.stop();
    }
}
