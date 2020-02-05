package fr.frezilla.game.framework.engines;

import fr.frezilla.game.framework.core.Engine;
import lombok.NonNull;

public abstract class GenericEngine extends Engine {
    
    protected GenericEngine(@NonNull Boolean passiveMode) {
        super(passiveMode);
    }
    
    protected GenericEngine() {
        super(true);
    }
    
    @Override
    protected void afterLoop() {
        System.out.println("afterLoop");
    }

    @Override
    protected void beforeLoop() {
        System.out.println("beforeLoop");
    }

    @Override
    protected void destroy() {
        System.out.println("destroy");
    }
    
}
