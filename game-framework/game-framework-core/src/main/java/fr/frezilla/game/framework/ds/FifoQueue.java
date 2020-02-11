package fr.frezilla.game.framework.ds;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import lombok.NonNull;

/**
 * Pile FIFO.
 * <p>
 * Le premier objet inséré dans la pile sera le premier retiré.
 * 
 * @param <T> 
 */
public final class FifoQueue<T> {
    
    private final LinkedList<T> linkedList;
    
    private FifoQueue() {
        linkedList = new LinkedList<>();
    }

    /**
     * Créé un nouvelle instance 
     * @param <T>
     * @return 
     */
    public static <T> FifoQueue<T> newInstance() {
        return new FifoQueue<>();
    }

    /**
     * Retourne true si la pile FIFO est vide; false sinon.
     * 
     * @return 
     */
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    /**
     * Retire et retourne le premier élément inséré dans la pile.
     * 
     * @return Premier objet
     * @throws NoSuchElementException Si la pile est vide
     */
    public T pop() throws NoSuchElementException {
        return linkedList.removeFirst();
    }

    /**
     * Ajoute un élément non null à la pile.
     * 
     * @param o Objet non null
     */
    public void push(@NonNull T o) {
        linkedList.addLast(o);
    }
    
}
