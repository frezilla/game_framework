package fr.frezilla.game.framework.engines.ihm;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

final class IhmWindowListener implements WindowListener {
    
    private final IhmEngine ihmEngine;
    
    private IhmWindowListener(IhmEngine ihmEngine) {
        this.ihmEngine = ihmEngine;
    }

    static IhmWindowListener create(IhmEngine ihmEngine) {
        return new IhmWindowListener(ihmEngine);
    }
    
    @Override
    public void windowActivated(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowClosed(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowClosing(WindowEvent e) {
        ihmEngine.sendStopGameRequest();
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowIconified(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowOpened(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
