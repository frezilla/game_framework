package fr.frezilla.game.framework.engines;

import fr.frezilla.game.framework.core.Engine;
import fr.frezilla.game.framework.core.EngineEvent;
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
    }

    @Override
    protected void beforeLoop() {
    }

    @Override
    protected void destroy() {
    }

    @Override
    protected void frame() {
    }

    @Override
    protected void init() {
    }

    @Override
    protected void processEvent(EngineEvent e) {
    }
}
