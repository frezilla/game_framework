package fr.frezilla.game.framework.engines.graphic;

import fr.frezilla.game.framework.core.Engine;
import fr.frezilla.game.framework.core.EngineEvent;
import fr.frezilla.game.framework.core.Game;
import javax.swing.JFrame;

public class GraphicEngine extends Engine {
    
    private final JFrame frame;
    private final GraphicListener listener;
    
    public GraphicEngine(Game g, Boolean p) {
        super(g, p);
        
        listener = new GraphicListener(this);
        
        frame = new JFrame();
        initFrame();
    }

    @Override
    public void end() {
        frame.setVisible(false);
        frame.dispose();
    }
    
    private void initFrame() {
        frame.setTitle("Jeu");
        frame.setVisible(true);
        frame.addKeyListener(listener);
    }

    @Override
    public void frame() {
        System.out.println("GraphicEngine.frame()");
    }

    @Override
    protected void processEvent(EngineEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
