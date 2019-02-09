package au.com.imc.test2.controller;

import au.com.imc.test2.model.AiPlayer;
import au.com.imc.test2.model.Gesture;
import au.com.imc.test2.model.Result;
import au.com.imc.test2.model.UserPlayer;
import au.com.imc.test2.ui.GameOverPanel;
import au.com.imc.test2.ui.GamePanel;
import au.com.imc.test2.util.PsrUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.awt.*;

/**
 * This class is designed to control the UI component of user player
 * and AI player. this controller will a part of GamePanel class. When
 * user player is entered the number of game rounds and clicked the Symbol
 * button, controller will be triggered.
 */
public class GameController {

    private int rounds;
    private int currentRound;
    private UserPlayer userPlayer;
    private AiPlayer aiPlayer;
    private static final Logger logger = LoggerFactory.getLogger(GameController.class);

    public GameController(final UserPlayer userPlayer, final AiPlayer aiPlayer) {
        this.currentRound = 1;
        this.userPlayer = userPlayer;
        this.aiPlayer = aiPlayer;
    }

    /**
     * increment current round
     */
    private void incrementCurrentRound() {
        ++currentRound;
    }

    /**
     * initialize game totel rounds
     * @param rounds
     */
    public void initGameRounds(final int rounds) {
        this.rounds = rounds;
    }

    /**
     * This method is responsible for updating UI components,
     * controlling user player attributes, AI player attributes,
     * game rounds and whole system status. when game is over,
     * a game over panel will show up representing final result and
     * winner
     *
     * @param gesture
     * @param userSymbolTextLabel
     * @param aiPaperLabel
     * @param aiScissorsLabel
     * @param aiRockLabel
     * @param aiSymbolTextLabel
     * @param roundLabel
     * @param userWinRoundsLabel
     * @param aiPlayerWinRoundsLabel
     */
    public void control(final Gesture gesture,
                        final JLabel userSymbolTextLabel,
                        final JLabel aiPaperLabel,
                        final JLabel aiScissorsLabel,
                        final JLabel aiRockLabel,
                        final JLabel aiSymbolTextLabel,
                        final JLabel roundLabel,
                        final JLabel userWinRoundsLabel,
                        final JLabel aiPlayerWinRoundsLabel,
                        final GamePanel gamePanel) {

        // remove current highlighted symbol label
        logger.debug("removed current highlighted symbol label");
        aiPaperLabel.setBorder(BorderFactory.createEmptyBorder());
        aiScissorsLabel.setBorder(BorderFactory.createEmptyBorder());
        aiRockLabel.setBorder(BorderFactory.createEmptyBorder());

        logger.info("============= round : {} ============", currentRound);
        // set current round label
        roundLabel.setText(Integer.toString(currentRound));
        logger.info("setting current round label text to {}", currentRound);

        // user control
        userPlayer.setCurrentGesture(gesture);
        userSymbolTextLabel.setText(gesture.getAlias());
        logger.info("setting user gesture label text to {}", gesture.getAlias());

        // generate ai gesture
        Gesture aiGesture = PsrUtil.generateRandomAiGesture();
        logger.info("generated AI symbol {}", aiGesture.getAlias());
        aiPlayer.setCurrentGesture(aiGesture);
        JLabel targetPsrLabel = null;
        if (aiGesture == Gesture.PAPER) {
            targetPsrLabel = aiPaperLabel;
        }
        if (aiGesture == Gesture.ROCK) {
            targetPsrLabel = aiRockLabel;
        }
        if (aiGesture == Gesture.SCISSORS) {
            targetPsrLabel = aiScissorsLabel;
        }
        logger.info("highlight AI symbol {} generated", aiGesture.getAlias());
        targetPsrLabel .setBorder(BorderFactory.createLineBorder(Color.BLUE, 3));

        // ai symbol text label
        aiSymbolTextLabel.setText(aiPlayer.getCurrentGesture().getAlias());
        logger.info("setting ai symbol gesture text label");
        // judge winner of the round
        Result result = PsrUtil.getUserResultOfRound(userPlayer, aiPlayer);
        if (result == Result.LOSE) aiPlayer.incrementWinRound();
        if (result == Result.WIN) userPlayer.incrementWinRound();
        logger.info("winner {} this round", result.toString());
        // update win rounds label
        userWinRoundsLabel.setText(Integer.toString(userPlayer.getWinRounds()));
        aiPlayerWinRoundsLabel.setText(Integer.toString(aiPlayer.getWinRounds()));

        // increment current round
        incrementCurrentRound();

        // check if this round is last round
        if (currentRound > rounds) {
            Result userResult = PsrUtil.userResult(userPlayer, aiPlayer);

            logger.info("disabling user button...");
            logger.info("game over, printing result panel.");
            // disable buttons on the Game Panel
            gamePanel.getPaperButton().setEnabled(false);
            gamePanel.getRockButton().setEnabled(false);
            gamePanel.getScissorsButton().setEnabled(false);

            if (userResult == Result.WIN) {
                new GameOverPanel(userPlayer.getName() + " wins game");
            } else if (userResult == Result.LOSE) {
                new GameOverPanel("AI player wins game");
            } else {
                new GameOverPanel("Draw game");
            }
        }
    }

    /**
     * set user player with name
     * @param userPlayerName
     */
    public void setUserPlayerName(final String userPlayerName) {
        this.userPlayer.setName(userPlayerName);
    }

    /**
     * get user player's name
     * @return
     */
    public String getUserPlayerName() {return this.userPlayer.getName();}
}
