import java.awt.*;
import javax.swing.*;

public class TicTacToeGame {
    public Scoreboard scoreboard;
    public Board board;

    public TicTacToeGame() {
        JFrame window = new JFrame("Tic Tac Toe");
        JButton resetButton = new JButton("Reset");

        window.setSize(550, 550);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLayout(new BorderLayout(5, 5));
        ((JPanel)window.getContentPane()).setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        resetButton.setFont(new Font("Arial", Font.BOLD, 15));
        resetButton.setFocusPainted(false);
        resetButton.addActionListener(_ -> {
            scoreboard.resetScore();
            board.resetBoard(Player.playerX);
            scoreboard.updatePlayerHighlight(Player.playerX);
        });

        scoreboard = new Scoreboard();
        board = new Board(this);

        scoreboard.updatePlayerHighlight(Player.playerX);

        window.add(scoreboard, BorderLayout.NORTH);
        window.add(board, BorderLayout.CENTER);
        window.add(resetButton, BorderLayout.SOUTH);


        window.setVisible(true);
    }
}
