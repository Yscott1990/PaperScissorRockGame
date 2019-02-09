package au.com.imc.test2.ui;

import au.com.imc.test2.controller.GameController;
import au.com.imc.test2.model.Gesture;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JFrame {

    // user components

    private JButton paperButton, scissorsButton, rockButton;
    private JLabel userSymbolLabel;
    private JLabel userWinRoundsLabel;
    // AI player components

    private JLabel paperLabel, scissorsLabel, rockLabel;
    private JLabel aiSymbolLabel;
    private JLabel aiWinRoundsLabel;
    // current round components

    private JLabel currentRoundLabel;
    /**
     * initialize UI components of Game panel.
     *
     * @param gameController
     */
    void init(final GameController gameController) {

        this.setBounds(600, 200, 1000, 400);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setTitle("Paper Game board");
        this.setLocationRelativeTo(null);
        Container container = this.getContentPane();
        container.setLayout(new BorderLayout());

        // initialize image icon with image
        ImageIcon rockImg = new ImageIcon("src\\main\\resources\\rock.PNG");
        ImageIcon paperImg = new ImageIcon("src\\main\\resources\\paper.PNG");
        ImageIcon scissorsImg = new ImageIcon("src\\main\\resources\\scissors.PNG");
        rockImg.setImage(rockImg.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH));
        paperImg.setImage(paperImg.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH));
        scissorsImg.setImage(scissorsImg.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH));

        // initialize label with images
        paperLabel = new JLabel();
        paperLabel.setIcon(paperImg);
        rockLabel = new JLabel();
        rockLabel.setIcon(rockImg);
        scissorsLabel = new JLabel();
        scissorsLabel.setIcon(scissorsImg);

        // user button initialize
        paperButton = new JButton();
        scissorsButton = new JButton();
        rockButton = new JButton();
        paperButton.setIcon(paperImg);
        scissorsButton.setIcon(scissorsImg);
        rockButton.setIcon(rockImg);

        //user panel initialize
        JPanel userPlayerPanel = new JPanel();
        userPlayerPanel.setLayout(new GridLayout(3, 3));
        userPlayerPanel.setBorder(BorderFactory.createTitledBorder(gameController.getUserPlayerName()));
        userPlayerPanel.add(paperButton);
        userPlayerPanel.add(scissorsButton);
        userPlayerPanel.add(rockButton);
        userSymbolLabel = new JLabel();
        JLabel userSymbolStaticLabel = new JLabel("Symbol:");
        JLabel blank = new JLabel();
        userWinRoundsLabel = new JLabel();
        JLabel userWinRoundsStaticLabel = new JLabel("WINS:");
        userPlayerPanel.add(userSymbolStaticLabel);
        userPlayerPanel.add(userSymbolLabel);
        userPlayerPanel.add(blank);
        userPlayerPanel.add(userWinRoundsStaticLabel);
        userPlayerPanel.add(userWinRoundsLabel);
        container.add(userPlayerPanel, "West");

        // round panel initialize
        JPanel roundPanel = new JPanel();
        roundPanel.setLayout(new GridLayout(10, 1));
        roundPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        JLabel currentRoundStaticLabel = new JLabel("Round");
        currentRoundLabel = new JLabel();
        roundPanel.add(currentRoundStaticLabel);
        roundPanel.add(currentRoundLabel);
        container.add(roundPanel, "Center");

        /**
         * AI panel initialize
         */
        JPanel aiPanel = new JPanel();
        aiPanel.setLayout(new GridLayout(3, 3));
        aiPanel.setBorder(BorderFactory.createTitledBorder("AI player"));
        aiPanel.add(paperLabel);
        aiPanel.add(scissorsLabel);
        aiPanel.add(rockLabel);
        aiSymbolLabel = new JLabel();
        JLabel aiSymbolStaticLabel = new JLabel("Symbol:");
        blank = new JLabel();
        aiWinRoundsLabel = new JLabel();
        JLabel aiWinRoundsStaticLabel = new JLabel("WINS:");
        aiPanel.add(aiSymbolStaticLabel);
        aiPanel.add(aiSymbolLabel);
        aiPanel.add(blank);
        aiPanel.add(aiWinRoundsStaticLabel);
        aiPanel.add(aiWinRoundsLabel);
        container.add(aiPanel, "East");

        // register buttons listeners
        addButtonListeners(gameController);
        this.setVisible(true);
    }

    public JButton getPaperButton() {
        return paperButton;
    }

    public JButton getScissorsButton() {
        return scissorsButton;
    }

    public JButton getRockButton() {
        return rockButton;
    }

    /**
     * add game controller to the button. When user selected the symbol of this round,
     * game controller will be responsible for updating the UI component, updating user player
     * attributes, AI player attributes, and game attributes.
     *
     * @param gameController
     */
    private void addButtonListeners(final GameController gameController) {
        paperButton.addActionListener(e -> {
            gameController.control(Gesture.PAPER,
                    userSymbolLabel,
                    paperLabel,
                    scissorsLabel,
                    rockLabel,
                    aiSymbolLabel,
                    currentRoundLabel,
                    userWinRoundsLabel,
                    aiWinRoundsLabel,
                    this
            );
        });

        scissorsButton.addActionListener(e -> {
            gameController.control(Gesture.SCISSORS,
                    userSymbolLabel,
                    paperLabel,
                    scissorsLabel,
                    rockLabel,
                    aiSymbolLabel,
                    currentRoundLabel,
                    userWinRoundsLabel,
                    aiWinRoundsLabel,
                    this
            );
        });

        rockButton.addActionListener(e -> {
            gameController.control(Gesture.ROCK,
                    userSymbolLabel,
                    paperLabel,
                    scissorsLabel,
                    rockLabel,
                    aiSymbolLabel,
                    currentRoundLabel,
                    userWinRoundsLabel,
                    aiWinRoundsLabel,
                    this
            );
        });
    }
}
