package fr.frezilla.game.framework.engines.ihm;

import fr.frezilla.game.framework.engines.GenericEngine;
import java.awt.Dimension;
import javax.swing.JFrame;

public final class IhmEngine extends GenericEngine {

    private JFrame jFrame;

    public IhmEngine(Boolean p) {
        super(p);
    }

    @Override
    protected void afterLoop() {
        jFrame.setVisible(false);
    }

    @Override
    protected void beforeLoop() {
        jFrame.setVisible(true);
    }

    @Override
    protected void destroy() {
        jFrame.dispose();
    }

    @Override
    protected void init() {
        jFrame = new JFrame();
        jFrame.setPreferredSize(new Dimension(640, 480));
        jFrame.getContentPane().addKeyListener(IhmKeyListener.create(this));
        jFrame.addWindowListener(IhmWindowListener.create(this));
    }
}
