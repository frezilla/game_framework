package fr.frezilla.game.framework.core;

import fr.frezilla.game.framework.utils.XmlUtils;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class GameBuilder {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(GameBuilder.class);
    
    public static Game build() {
        Game game;
        
        Document gameXmlDocument = XmlUtils.parse(GameBuilder.class.getClassLoader().getResourceAsStream(GameProperties.GAME_XML_PATH));
        NodeList nEngineList = gameXmlDocument.getElementsByTagName("engine");
        int nbEngines = nEngineList.getLength();
        
        if (nbEngines == 0) {
            game = null;
        } else {
            try {
                game = new Game();
                for (int i = 0; i < nbEngines; i++) {
                    Node node = nEngineList.item(i);
                    if (Node.ELEMENT_NODE == node.getNodeType()) {
                        Element element = (Element) node;
                        String eName = element.getAttribute("name");
                        String eClassName = element.getAttribute("class");
                        
                        LOGGER.trace("Instanciation du moteur <" + eName + "> - " + eClassName);

                        Class eClass = Class.forName(eClassName);
                        if (Engine.class.isAssignableFrom(eClass)) {
                            Constructor<? extends Engine> constructor = eClass.getConstructor(Boolean.class);
                            Engine eInstance = constructor.newInstance(false);
                            eInstance.setGame(game);
                            game.addEngine(eName, eInstance);
                        }
                    }
                }
            } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | InvocationTargetException | NoSuchMethodException e) {
                e.printStackTrace(System.err);
                game = null;
            }
        }
        
        return game;
    }
    
}
