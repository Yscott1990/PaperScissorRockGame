package au.com.imc.test2.ui;

import au.com.imc.test2.controller.GameController;

import javax.swing.*;
import java.awt.*;

/**
 * This UI component will be triggered when game is over
 * winner will be printed to the panel
 */
public class GameOverPanel {
    private String gameResult;

    public GameOverPanel(final String gameResult) {
        this.gameResult = gameResult;
        initGameOverPanel();
    }

    public void initGameOverPanel() {
        JFrame frame = new JFrame("result dialog");
        frame.setLocationRelativeTo(null);
        JPanel jPanel = new JPanel();
        JLabel gameResultLabel = new JLabel();
        JButton exitButton = new JButton("Exit game");

        exitButton.setSize(200, 200);
        exitButton.setEnabled(true);


        gameResultLabel.setText(gameResult);

        jPanel.add(gameResultLabel);
        jPanel.add(exitButton);

        frame.add(jPanel);

        frame.setSize(300, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        exitButton.addActionListener(e-> {
            // shutdown application jvm
            System.exit(0);
        });

        frame.setVisible(true);
    }
}
