package fr.frezilla.game.framework.engines.sound;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import lombok.NonNull;

class SoundsMap {

    private final Map<String, Sound> sounds;
    
    public SoundsMap() {
        sounds = new HashMap<>();
    }

    public Sound getSound(@NonNull String soundName) {
        return sounds.get(soundName);
    }

    public Set<String> getSoundsNames() {
        return sounds.keySet();
    }
    
    public Sound putSound(@NonNull String soundName, @NonNull Sound sound) {
        return sounds.put(soundName, sound);
    }

}
