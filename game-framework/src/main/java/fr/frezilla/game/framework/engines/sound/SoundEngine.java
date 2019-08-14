package fr.frezilla.game.framework.engines.sound;

import fr.frezilla.game.framework.core.Engine;
import fr.frezilla.game.framework.core.EngineEvent;
import fr.frezilla.game.framework.core.Game;
import java.io.InputStream;

public class SoundEngine extends Engine {
    
    private SoundsMap soundsMap;
    
    public SoundEngine(Game g, Boolean p) {
        super(g, p);
    }
    
    @Override
    public void end() {
        System.out.println("SoundEngine.end");
        soundsMap.getSoundsNames().forEach((soundName) -> {
            Sound sound = soundsMap.getSound(soundName);
            if (sound != null) {
                sound.interrupt();
            }
        });
    }

    @Override
    public void frame() {
        System.out.println("SoundEngine.frame");
    }
    
    public void loadSounds(InputStream...is) {
        
        
    }
    
    @Override
    protected void processEvent(EngineEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
