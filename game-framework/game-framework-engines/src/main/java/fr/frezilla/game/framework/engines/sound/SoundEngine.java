package fr.frezilla.game.framework.engines.sound;

import fr.frezilla.game.framework.core.EngineEvent;
import fr.frezilla.game.framework.ds.FifoQueue;
import fr.frezilla.game.framework.engines.GenericEngine;
import fr.frezilla.game.framework.utils.XmlUtils;
import java.io.IOException;
import javazoom.jl.decoder.JavaLayerException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class SoundEngine extends GenericEngine {

    private static final String SOUNDS_FILE = "sounds/sounds.xml";

    private final SoundsMap soundsMap;
    private final FifoQueue<Sound> soundsToPlay;

    public SoundEngine() {
        super();

        soundsMap = new SoundsMap();
        soundsToPlay = FifoQueue.newInstance();

        loadSounds();
    }

    @Override
    protected void beforeLoop() {
        soundsMap.getSoundsNames().forEach((soundName) -> {
            Sound sound = soundsMap.getSound(soundName);
            if (sound != null) {
                sound.stop();
            }
        });
    }

    @Override
    protected void frame() {
        while (!soundsToPlay.isEmpty()) {
            soundsToPlay.pop().play();
        }
    }

    private void loadSounds() {
        Document doc = XmlUtils.parse(getClass().getClassLoader().getResourceAsStream(SOUNDS_FILE));
        NodeList nodeList = doc.getElementsByTagName("sound");

        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (Node.ELEMENT_NODE == node.getNodeType()) {
                try {
                    Element element = (Element) node;
                    String soundName = element.getElementsByTagName("name").item(0).getTextContent();
                    String soundFile = element.getElementsByTagName("file").item(0).getTextContent();
                    soundsMap.putSound(soundName, Sound.of(getClass().getClassLoader().getResourceAsStream(soundFile)));
                } catch (JavaLayerException | IOException e) {
                    e.printStackTrace(System.err);
                }
            }
        }
    }

    @Override
    protected void processEvent(EngineEvent e) {
        soundsToPlay.push(soundsMap.getSound("waves"));
    }

}
