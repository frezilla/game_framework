package fr.frezilla.game.framework.ds;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import lombok.NonNull;

public final class FifoQueue<T> {
    
    private final LinkedList<T> linkedList;
    
    private FifoQueue() {
        linkedList = new LinkedList<>();
    }

    public static <T> FifoQueue<T> newInstance() {
        return new FifoQueue<>();
    }

    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    public T pop() throws NoSuchElementException {
        return linkedList.removeFirst();
    }

    public void push(@NonNull T o) {
        linkedList.addLast(o);
    }
    
}
