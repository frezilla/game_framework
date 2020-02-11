package fr.frezilla.game.framework.engines.ihm;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

final class IhmKeyListener implements KeyListener {
    
    private final IhmEngine ihmEngine;

    private IhmKeyListener(IhmEngine ihmEngine) {
        this.ihmEngine = ihmEngine;
    }
    
    static IhmKeyListener create(IhmEngine ihmEngine) {
        return new IhmKeyListener(ihmEngine);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
