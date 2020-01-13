package fr.frezilla.game.framework.core;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class GameProperties {
    
    public static String GAME_XML_PATH = System.getProperty("game_xml_path", "game.xml");
    
    
}
