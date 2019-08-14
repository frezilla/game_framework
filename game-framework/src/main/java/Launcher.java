
import fr.frezilla.game.framework.core.Game;
import fr.frezilla.game.framework.core.GameBuilder;

public class Launcher {
    public static void main(String[] args) {
        Game g = GameBuilder.build();
        g.getEnginesNames().forEach((s) -> System.out.println(s));
        g.run();
    }
}
