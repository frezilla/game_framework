package fr.frezilla.game.framework.engines.sound;

import java.io.InputStream;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import lombok.NonNull;

class Sound extends Thread {

    private final Player player;

    private Sound(@NonNull InputStream stream) throws JavaLayerException {
        player = new Player(stream);
    }

    @Override
    public void interrupt() {
        player.close();
    }
    
    public Sound of(InputStream stream) throws JavaLayerException {
        return new Sound(stream);
    }

    @Override
    public void start() {
        try {
            player.play();
        } catch (JavaLayerException e) {
            player.close();
        }
    }

}
