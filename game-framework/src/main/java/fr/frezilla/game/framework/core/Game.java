package fr.frezilla.game.framework.core;

import java.awt.DisplayMode;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Consumer;
import lombok.NonNull;

/**
 * Classe du jeu.
 */
public final class Game {

    static final int FRAMES_PER_SECOND;

    private final Map<String, Engine> enginesMap;
    private final Lock lock;
    private final long loopDuration;
    private boolean stillRunning;
    
    static {
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice gd = ge.getDefaultScreenDevice();
        DisplayMode dm = gd.getDisplayMode();
        
        int refreshRate = dm.getRefreshRate();
        FRAMES_PER_SECOND = (refreshRate == DisplayMode.REFRESH_RATE_UNKNOWN) ? 60 : refreshRate;
    }

    /**
     * Constructeur.
     */
    Game() {
        enginesMap = new HashMap<>();
        lock = new ReentrantLock();
        loopDuration = (long) 1000000000 / FRAMES_PER_SECOND;
        stillRunning = true;
    }

    /**
     * Ajoute un moteur identifié par un nom au jeu.
     * <p>
     * Le nom du moteur doit être unique. Si un moteur existe déjà avec le même
     * nom, le moteur sera remplacé par celui passé en paramètre.
     *
     * @param name Nom du moteur
     * @param engine Moteur
     * @see Engine
     */
    void addEngine(@NonNull String name, @NonNull Engine engine) {
        enginesMap.put(name, engine);
    }

    /**
     * Diffuse un évènement vers un moteur identifié par son nom.
     * <p>
     * Si le nom du moteur est inconnu du jeu, l'appel à cette méthode est sans
     * effet.
     *
     * @param engineName Nom du moteur destinataire de l'évènement
     * @param evt Evènement
     */
    void dispatchMessage(@NonNull String engineName, @NonNull EngineEvent evt) {
        if (enginesMap.containsKey(engineName)) {
            enginesMap.get(engineName).pushEvent(evt);
        }
    }
    
    /**
     * Exécute une action pour chacun des modules déclarés dans le jeu.
     * 
     * @param action Action à exécuter
     */
    private void executeActionOnModules(Consumer<? super Engine> action) {
        enginesMap.values().forEach(action);
    }

    /**
     * Retourne la liste des noms des moteurs déclarés dans le jeu.
     *
     * @return Ensemble des noms des moteurs
     */
    public Set<String> getEnginesNames() {
        return enginesMap.keySet();
    }

    /**
     * Met le jeu en "pause" pour respecter les contraintes liées au framerate
     * définies via la variable {@link Game#FRAMES_PER_SECOND}.
     * 
     * @param startLoopTime Instant de départ du traitement de la boucle
     */
    private void pause(long startLoopTime) {
        long sleepTime = loopDuration - (System.nanoTime() - startLoopTime);
        if (sleepTime > 0) {
            try {
                Thread.sleep(sleepTime / 999999, (int) sleepTime % 999999);
            } catch (InterruptedException e) {
                e.printStackTrace(System.err);
            }
        }
    }

    /**
     * Lance le jeu.
     * <p>
     * Le principe de fonctionnement de cette méthode est :
     * <p>
     * <code>
     * * Ouvertures des moteurs<br>
     * * Traitement antérieurs à la boucle du jeu<br>
     * * Boucle du jeu {<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;- Traitement des évènements reçus<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;- Traitement<br>
     * * }<br>
     * * Traitement postérieurs à la boucle du jeu<br>
     * * Fermeture des moteurs
     */
    public final void run() {
        boolean currentStillRunning = stillRunning;
        
        // Initialisation des moteurs
        executeActionOnModules(Engine::init);

        // Traitements antérieurs à la boucle du jeu
        executeActionOnModules(Engine::beforeLoop);
        
        while (currentStillRunning) {
            long startLoopTime = System.nanoTime();
            
            // Traitement des évènements
            executeActionOnModules(Engine::processEvents);
            
            // Traitement 
            executeActionOnModules(Engine::frame);

            lock.lock();
            try {
                currentStillRunning = stillRunning;
            } finally {
                lock.unlock();
            }
            if (currentStillRunning) {
                pause(startLoopTime);
            }
        }

        // Traitements postérieurs à la boucle du jeu
        executeActionOnModules(Engine::afterLoop);
        
        // Fermeture des moteurs
        executeActionOnModules(Engine::destroy);
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
