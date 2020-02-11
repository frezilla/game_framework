package fr.frezilla.game.framework.engines.sound;

import java.io.IOException;
import java.io.InputStream;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import lombok.NonNull;

class Sound {

    private long playedStream;
    private long streamLength;
    private Thread playThread;
    private final Player player;
    private Thread resumeThread;
    private final InputStream soundStream;

    private Sound(@NonNull InputStream stream) throws JavaLayerException, IOException {
        soundStream = stream;

        playedStream = streamLength = soundStream.available();
        player = new Player(soundStream);

        playThread = new Thread(() -> {
            try {
                player.play();
            } catch (JavaLayerException e) {
                e.printStackTrace(System.err);
            }
        });

        resumeThread = new Thread(() -> {
            try {
                soundStream.skip(streamLength - playedStream);
                player.play();
            } catch (JavaLayerException | IOException e) {
                e.printStackTrace(System.err);
            }
        });

    }

    public static Sound of(InputStream stream) throws IOException, JavaLayerException {
        return new Sound(stream);
    }

    public void pause() throws IOException {
        playedStream = soundStream.available();
        player.close();
    }

    public void play() {
        if (playThread.isAlive()) {
            player.close();
        }
        playThread.start();
    }
    
    private void playSound(boolean resume) {
        
    }

    public void resume() {
        resumeThread.start();
    }

    public void stop() {
        player.close();
    }
}
