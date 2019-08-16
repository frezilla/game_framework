
import fr.frezilla.game.framework.core.Game;
import fr.frezilla.game.framework.core.GameBuilder;

public class Launcher {
    public static void main(String[] args) {
        Game g = GameBuilder.build();
        if (g != null) {
            g.getEnginesNames().forEach((s) -> System.out.println(s));
            g.run();
        } 
    }
}
