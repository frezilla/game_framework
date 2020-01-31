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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void beforeLoop() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void destroy() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
