package au.com.imc.test2.util;

import au.com.imc.test2.model.AiPlayer;
import au.com.imc.test2.model.Gesture;
import au.com.imc.test2.model.Result;
import au.com.imc.test2.model.UserPlayer;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Random;

public class PsrUtil {

    /**
     * pre-defined schema in 2-D array stores the result user player again AI player
     *
     * user player's symbols vertically are PAPER, SCISSORS, ROCK
     * AI player's symbol horizontally are PAPER, SCISSORS, ROCK
     *
     * 0 : draw
     * 1 : user player win
     * 2 : user player lose
     *
     * The index is based on the gesture's index. for example: user's gesture
     * is "PAPER(0)" and AI's gesture is "SCISSORS(1)", so just look into SCHEMA[0][1],
     * user lose this round.
     */
    private static final int[][] SCHEMA = new int[][]{
            {0, 2, 1},
            {1, 0, 2},
            {2, 1, 0}
    };

    /**
     * lookup map for generating gesture based on the random integer number generated
     */
    private static final Map<Integer, Gesture> gestureMap = new HashMap<>();

    static {
        gestureMap.put(0, Gesture.PAPER);
        gestureMap.put(1, Gesture.SCISSORS);
        gestureMap.put(2, Gesture.ROCK);
    }

    /**
     * get the result of user player in current round
     *
     * @param userPlayer
     * @param aiPlayer
     * @return
     */
    public static Result getUserResultOfRound(UserPlayer userPlayer, AiPlayer aiPlayer) {
        Objects.requireNonNull(userPlayer, "user player does not exists");
        Objects.requireNonNull(aiPlayer, "ai player does not exists");
        switch(SCHEMA[userPlayer.getCurrentGesture().getIndex()][aiPlayer.getCurrentGesture().getIndex()]) {
            case 0:
                return Result.DRAW;
            case 1:
                return Result.WIN;
            case 2:
                return Result.LOSE;
            default:
                throw new RuntimeException("unable to resolve result");
        }
    }

    /**
     * get final result of user against AI player
     * @param userPlayer
     * @param aiPlayer
     * @return
     */
    public static Result userResult (UserPlayer userPlayer, AiPlayer aiPlayer) {
        if (userPlayer.getWinRounds() == aiPlayer.getWinRounds()) {
            return Result.DRAW;
        } else if (userPlayer.getWinRounds() > aiPlayer.getWinRounds()){
            return Result.WIN;
        } else {
            return Result.LOSE;
        }
    }

    /**
     * generate random gesture for AI palayer
     * @return
     */
    public static Gesture generateRandomAiGesture() {
        Random r = new Random();
        int randNum = r.nextInt(3);
        return gestureMap.get(randNum);
    }
}
