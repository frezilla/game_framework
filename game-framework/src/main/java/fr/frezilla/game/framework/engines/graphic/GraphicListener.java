package fr.frezilla.game.framework.engines.graphic;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import lombok.NonNull;

class GraphicListener implements KeyListener {
    
    private final GraphicEngine graphicEngine;
    
    public GraphicListener(@NonNull GraphicEngine ge) {
        graphicEngine = ge;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if ('s' == e.getKeyChar()) {
            graphicEngine.sendStopGameRequest();    
        }
    }

    @Override
    public void keyReleased(KeyEvent e) { ; }

    @Override
    public void keyTyped(KeyEvent e) { ; }
    
}
