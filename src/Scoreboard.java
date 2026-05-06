import java.awt.*;
import javax.swing.*;

public class Scoreboard extends JPanel {
    private int xScore = 0;
    private int oScore = 0;

    JLabel scoreboardTitle = new JLabel("Scoreboard");
    JLabel scoreboardPlayerX = new JLabel("Player X: 0");
    JLabel scoreboardPlayerO = new JLabel("Player O: 0");

    public Scoreboard() {
        setLayout(new GridLayout(2, 3, 5, 5));

        scoreboardTitle.setFont(new Font("Arial", Font.BOLD, 20));
        scoreboardPlayerX.setFont(new Font("Arial", Font.BOLD, 15));
        scoreboardPlayerO.setFont(new Font("Arial", Font.BOLD, 15));

        add(scoreboardTitle);
        add(new JLabel(""));
        add(new JLabel(""));
        add(scoreboardPlayerX);
        add(scoreboardPlayerO);
    }

    public void updatePlayerHighlight(Player player) {
        switch (player) {
            case Player.playerX -> {
                scoreboardPlayerX.setForeground(Color.RED);
                scoreboardPlayerO.setForeground(Color.BLACK);
            }

            case Player.playerO -> {
                scoreboardPlayerO.setForeground(Color.BLUE);
                scoreboardPlayerX.setForeground(Color.BLACK);
            }

            default -> {
                scoreboardPlayerX.setForeground(Color.BLACK);
                scoreboardPlayerO.setForeground(Color.BLACK);
            }
        }
    }

    private void updateScore() {
        scoreboardPlayerX.setText("Player X: " + xScore);
        scoreboardPlayerO.setText("Player O: " + oScore);
    }

    public void addPointForX() {
        xScore++;
        updateScore();
    }

    public void addPointForO() {
        oScore++;
        updateScore();
    }

    public void resetScore() {
        xScore = 0;
        oScore = 0;
        updateScore();
    }
}