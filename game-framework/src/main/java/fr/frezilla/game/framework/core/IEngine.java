package fr.frezilla.game.framework.core;

public interface IEngine {

    /**
     * Exécute le traitement suivant la boucle du jeu.
     */
    void afterLoop();

    /**
     * Exécute le traitement préliminaire à la boucle du jeu.
     */
    void beforeLoop();

    /**
     * Détruit le moteur.
     * <p>
     * Cette méthode devrait être utilisée pour libérer les ressources utilisées
     * par le moteur.
     */
    void destroy();

    /**
     * Exécute le traitement du moteur
     */
    void frame();

    /**
     * Initialise le moteur.
     * <p>
     * Cette méthode devrait être utilisée pour accéder aux ressources
     * nécessaires au fonctionnement du moteur.
     */
    void init();

}