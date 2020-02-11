package fr.frezilla.game.framework.engines;

import fr.frezilla.game.framework.core.Engine;
import fr.frezilla.game.framework.core.EngineEvent;

public abstract class GenericEngine extends Engine {

    protected GenericEngine() {
        super();
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
