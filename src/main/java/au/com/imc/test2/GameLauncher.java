package au.com.imc.test2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Paper Scissors Rock game launcher
 */
public class GameLauncher {
    private static final Logger logger = LoggerFactory.getLogger(GameLauncher.class);

    public static void main(String[] args) {
        MainApplication psrGame = new MainApplicationImpl();
        psrGame.start();
        logger.info("game started...");
    }
}
