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
public abstract class Engine {

    private Game game;
    private final FifoQueue<EngineEvent> eventsQueue;

    /**
     * Constructeur.
     *
     * @see Game
     */
    protected Engine() {
        this.eventsQueue = FifoQueue.newInstance();
    }

    /**
     * Exécute le traitement suivant la boucle du jeu.
     */
    protected abstract void afterLoop();

    /**
     * Exécute le traitement préliminaire à la boucle du jeu.
     */
    protected abstract void beforeLoop();

    /**
     * Détruit le moteur.
     * <p>
     * Cette méthode devrait être utilisée pour libérer les ressources utilisées
     * par le moteur.
     */
    protected abstract void destroy();

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
    protected abstract void init();

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
    final void pushEvent(@NonNull EngineEvent eEvent) {
        eventsQueue.push(eEvent);
    }

    /**
     * Transmet un évènement vers un moteur identifié par son nom.
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
     * Transmet un évènement vers tous les moteurs connus du jeu.
     * 
     * @param eEvent Evènement
     */
    protected final void sendEventToAll(@NonNull EngineEvent eEvent) {
        game.getEnginesNames().forEach((eName) -> {sendEventTo(eName, eEvent); });
    }

    /**
     * Emet une requête d'arrêt au jeu.
     */
    public final void sendStopGameRequest() {
        game.stop();
    }
    
    /**
     * Permet de créer un lien entre le moteur et le jeu.
     * <p>
     * Cette méthode devrait être seulement invoqué par la GameBuilder (les 
     * instances filles de Engine ne devrait pas pouvoir disposer d'un accès 
     * direct à l'instance du jeu)
     * 
     * @param game 
     */
    final void setGame(@NonNull Game game) {
        this.game = game;
    }
}
