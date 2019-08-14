package fr.frezilla.game.framework.engines.sound;

import java.util.Map;
import java.util.Set;
import lombok.NonNull;

class SoundsMap {

    private Map<String, Sound> sounds;

    public Sound getSound(@NonNull String soundName) {
        return sounds.get(soundName);
    }

    public Set<String> getSoundsNames() {
        return sounds.keySet();
    }

}
