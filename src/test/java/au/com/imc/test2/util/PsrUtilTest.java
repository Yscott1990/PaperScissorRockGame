package au.com.imc.test2.util;

import au.com.imc.test2.model.AiPlayer;
import au.com.imc.test2.model.Gesture;
import au.com.imc.test2.model.Result;
import au.com.imc.test2.model.UserPlayer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.EnumSet;
import java.util.Iterator;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class PsrUtilTest {

    @Mock
    UserPlayer userPlayer;
    @Mock
    AiPlayer aiPlayer;

    @Test
    public void getUserResultOfRound() {
        Mockito.when(userPlayer.getCurrentGesture()).thenReturn(Gesture.PAPER);
        Mockito.when(aiPlayer.getCurrentGesture()).thenReturn(Gesture.ROCK);
        assertEquals(Result.WIN, PsrUtil.getUserResultOfRound(userPlayer, aiPlayer));

        Mockito.when(userPlayer.getCurrentGesture()).thenReturn(Gesture.SCISSORS);
        Mockito.when(aiPlayer.getCurrentGesture()).thenReturn(Gesture.ROCK);
        assertEquals(Result.LOSE, PsrUtil.getUserResultOfRound(userPlayer, aiPlayer));

        Mockito.when(userPlayer.getCurrentGesture()).thenReturn(Gesture.PAPER);
        Mockito.when(aiPlayer.getCurrentGesture()).thenReturn(Gesture.PAPER);
        assertEquals(Result.DRAW, PsrUtil.getUserResultOfRound(userPlayer, aiPlayer));
    }

    @Test
    public void userResult() {
        Mockito.when(userPlayer.getWinRounds()).thenReturn(1);
        Mockito.when(aiPlayer.getWinRounds()).thenReturn(3);
        assertEquals(Result.LOSE, PsrUtil.userResult(userPlayer, aiPlayer));

        Mockito.when(userPlayer.getWinRounds()).thenReturn(4);
        Mockito.when(aiPlayer.getWinRounds()).thenReturn(3);
        assertEquals(Result.WIN, PsrUtil.userResult(userPlayer, aiPlayer));

        Mockito.when(userPlayer.getWinRounds()).thenReturn(3);
        Mockito.when(aiPlayer.getWinRounds()).thenReturn(3);
        assertEquals(Result.DRAW, PsrUtil.userResult(userPlayer, aiPlayer));
    }

    @Test
    public void generateRandomAiGesture() {
        final Set<Gesture> gestureSets = EnumSet.allOf(Gesture.class);
        for (int i = 0; i < 10; i++) {
            assertTrue(gestureSets.contains(PsrUtil.generateRandomAiGesture()));
        }
    }
}