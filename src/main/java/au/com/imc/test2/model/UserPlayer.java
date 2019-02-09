package au.com.imc.test2.model;

/**
 * User Player extends from Abstract player
 * with attribute name to be displayed on the game panel and
 * game over panel
 */
public class UserPlayer extends AbstractPlayer {

    private String name;

    public UserPlayer() {
        super();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
