package au.com.imc.test2.ui;

import au.com.imc.test2.controller.GameController;

import javax.swing.*;
import java.awt.*;

public class RoundInputPanel extends JFrame {
    private static final String INPUT_DIALOG = "Rounds input dialog";
    private JTextField roundsTextField;
    private JTextField userNameTextField;
    private JButton confirmButton;

    /**
     * init UI components and register button action listener
     * @param gameController
     */
    public void init(GameController gameController) {
        this.setBounds(600, 200, 400, 150);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setTitle(INPUT_DIALOG);
        this.setLocationRelativeTo(null);

        // layout
        Container container = this.getContentPane();
        container.setLayout(new BorderLayout());

        JPanel fieldPanle = new JPanel();
        fieldPanle.setLayout(new FlowLayout());
        JLabel roundsLable = new JLabel("Enter game rounds:");
        roundsTextField = new JTextField(20);
        JLabel userNameLabel = new JLabel("Enter user name:");
        userNameTextField = new JTextField(20);
        fieldPanle.add(roundsLable);
        fieldPanle.add(roundsTextField);
        fieldPanle.add(userNameLabel);
        fieldPanle.add(userNameTextField);
        container.add(fieldPanle, "Center");

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        confirmButton = new JButton("confirm");
        buttonPanel.add(confirmButton);
        container.add(buttonPanel, "South");

        this.setVisible(true);

        addButtonListener(gameController);
    }

    /**
     * fetch username and number of rounds from input
     * and trigger game panel.input will be gathered by game controller and
     * register game controller to game panel.
     * @param gameController
     */
    private void addButtonListener(final GameController gameController) {
        confirmButton.addActionListener(e -> {
            gameController.initGameRounds(Integer.parseInt(roundsTextField.getText()));
            gameController.setUserPlayerName(userNameTextField.getText());
            new GamePanel().init(gameController);
            this.dispose();
        });
    }
}
