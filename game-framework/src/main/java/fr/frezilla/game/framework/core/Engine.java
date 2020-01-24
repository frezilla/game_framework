package fr.frezilla.game.framework.core;

import fr.frezilla.game.framework.ds.FifoQueue;
import lombok.NonNull;

/**
 * La classe Engine implémente les méthodes communes à l'ensemble des moteurs du
 * jeu.
 * <p>
 * Les méthodes {@link Engine#afterLoop()}, {@link Engine#beforeLoop()},
 * {@link Engine#destroy()} et {@link Engine#init()} peuvent être redéfinies
 * dans les classes filles si nécessaires.
 */
abstract class Engine {

    private final Game game;
    private final FifoQueue<EngineEvent> eventsQueue;
    protected final boolean passiveMode;

    /**
     * Constructeur.
     *
     * @param gameRef Référence vers le jeu
     * @param passiveMode Mode passif activé ou pas
     * @see Game
     */
    protected Engine(@NonNull Game gameRef, @NonNull Boolean passiveMode) {
        this.eventsQueue = FifoQueue.newInstance();
        this.game = gameRef;
        this.passiveMode = passiveMode;
    }

    /**
     * Exécute le traitement suivant la boucle du jeu.
     */
    protected void afterLoop() {
    }

    /**
     * Exécute le traitement préliminaire à la boucle du jeu.
     */
    protected void beforeLoop() {
    }

    /**
     * Détruit le moteur.
     * <p>
     * Cette méthode devrait être utilisée pour libérer les ressources utilisées
     * par le moteur.
     */
    protected void destroy() {
    }

    /**
     * Exécute le traitement du moteur
     */
    protected abstract void frame();

    /**
     * Initialise le moteur.
     * <p>
     * Cette méthode devrait être utilisée pour accéder aux ressources
     * nécessaires au fonctionnement du moteur.
     */
    protected void init() {
    }

    /**
     * Lance le traitement des tous les évènements présents dans la pile des
     * évènement.
     */
    final void processEvents() {
        while (!eventsQueue.isEmpty()) {
            EngineEvent e = eventsQueue.pop();
            processEvent(e);
        }
    }

    /**
     * Traite un évènement transmis au moteur.
     *
     * @param e Evènement
     */
    protected abstract void processEvent(EngineEvent e);

    /**
     * Ajoute un évènement à la liste des évènements à traiter.
     *
     * @param eEvent Evènement
     */
    void pushEvent(@NonNull EngineEvent eEvent) {
        eventsQueue.push(eEvent);
    }

    /**
     * Emet un évènement vers un moteur identifié par son nom.
     * <p>
     * La liste des moteurs référencés dans l'ojet Game est accessible via la
     * méthode {@link Game#getEnginesNames}.
     *
     * @param eName Nom du moteur destinataire
     * @param eEvent Evènement
     * @see Game#getEnginesNames()
     */
    protected final void sendEventTo(@NonNull String eName, @NonNull EngineEvent eEvent) {
        game.dispatchMessage(eName, eEvent);
    }

    /**
     * Emet une requête d'arrêt au jeu.
     */
    public final void sendStopGameRequest() {
        game.stop();
    }
}
