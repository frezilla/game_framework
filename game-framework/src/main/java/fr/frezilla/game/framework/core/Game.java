package fr.frezilla.game.framework.core;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import lombok.NonNull;
import org.apache.commons.lang3.tuple.Pair;

public final class Game {

    private final Lock lock;
    private final Map<String, Engine> modulesMap;
    private boolean stillRunning;

    /**
     * Constructeur du jeu
     */
    public Game() {
        lock = new ReentrantLock();
        modulesMap = new HashMap<>();
        stillRunning = true;
    }
    
    /**
     * Ajoute un moteur nommé au jeu.
     * <p>
     * Le nom du moteur doit être unique. Si un moteur existe déjà avec le même
     * nom, le moteur sera remplacé par celui passé en paramètre.
     * 
     * @param namedEngine Moteur nommé; la clé est le nom du moteur, la valeur 
     * est le moteur à proprement parler.
     */
    void addEngine(@NonNull Pair<String, Engine> namedEngine) {
        modulesMap.put(
                Objects.requireNonNull(namedEngine.getKey()), 
                Objects.requireNonNull(namedEngine.getValue())
        );
    }
    
    /**
     * Route un évènement moteur vers un moteur.
     * 
     * @param engineName Nom du moteur destinataire de l'évènement
     * @param evt Evènement
     */
    void dispatchMessage(@NonNull String engineName, @NonNull EngineEvent evt) {
        if (modulesMap.containsKey(engineName)) {
            modulesMap.get(engineName).pushEvent(evt);
        }
    }
    
    /**
     * Retourne les noms des moteurs déclarés dans le jeu.
     * 
     * @return 
     */
    public Set<String> getEnginesNames() {
        return modulesMap.keySet();
    }

    /**
     * Exécute le jeu.
     */
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
