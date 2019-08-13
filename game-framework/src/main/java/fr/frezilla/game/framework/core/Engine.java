package fr.frezilla.game.framework.core;

import fr.frezilla.game.framework.ds.FifoQueue;
import lombok.NonNull;

public abstract class Engine {
    
    private final Game game;
    private final FifoQueue<EngineEvent> eventsQueue;
    protected final boolean passiveMode;
    
    public Engine(@NonNull Game g, @NonNull Boolean p) {
        eventsQueue = FifoQueue.newInstance();
        game = g;
        passiveMode = p;
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
