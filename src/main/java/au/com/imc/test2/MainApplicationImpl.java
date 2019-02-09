package au.com.imc.test2;

import au.com.imc.test2.controller.GameController;
import au.com.imc.test2.model.AiPlayer;
import au.com.imc.test2.model.UserPlayer;
import au.com.imc.test2.ui.RoundInputPanel;

/**
 * MainApplicationImpl class is the implementation of MainApplication interface
 * This class creates user player instance, AI player instance, Game controller instance
 * and UI components.
 *
 * This class also registers game controller into the UI components to control UI and
 * update both player instances.
 */
public class MainApplicationImpl implements MainApplication {

    @Override
    public void start() {
        // create user player
        final UserPlayer userPlayer = new UserPlayer();
        // create AI player
        final AiPlayer aiPlayer = new AiPlayer();
        // create game controller
        final GameController gameController = new GameController(userPlayer, aiPlayer);
        // initialize entry panel
        new RoundInputPanel().init(gameController);
    }
}
