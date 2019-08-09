package fr.frezilla.game.framework.core;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import lombok.NonNull;
import org.apache.commons.lang3.tuple.Pair;

public class Game {

    private final Lock lock;
    private final Map<String, Engine> modulesMap;
    private boolean stillRunning;

    public Game() {
        lock = new ReentrantLock();
        modulesMap = new HashMap<>();
        stillRunning = true;
    }
    
    public void addEngine(Pair<String, Engine> namedEngine) {
        modulesMap.put(
                Objects.requireNonNull(namedEngine.getKey()), 
                Objects.requireNonNull(namedEngine.getValue())
        );
    }

    void dispatchMessage(@NonNull String engineName, @NonNull EngineEvent evt) {
        if (modulesMap.containsKey(engineName)) {
            modulesMap.get(engineName).pushEvent(evt);
        }
    }

    public void run() {
        boolean currentStillRunning = stillRunning;

        while (currentStillRunning) {
            modulesMap.values().forEach((e) -> {
                e.frame();
            });
            
            lock.lock();
            try {
                currentStillRunning = stillRunning;
            } finally {
                lock.unlock();
            }
        }
    }
    
    /**
     * Demande l'arrêt du jeu.
     * <p>
     * Aucune nouvelle action ne sera exécutée mais les actions en cours ne sont 
     * pas interrompues.
     */
    void stop() {
        lock.lock();
        try {
            stillRunning = false;
        } finally {
            lock.unlock();
        }
    }
}
