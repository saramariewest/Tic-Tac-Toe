import java.awt.*;
import javax.swing.*;

public class Board extends JPanel {
    Square[][] buttons = new Square[3][3];
    GameLogic gamelogic;

    public Board(TicTacToeGame ticTacToeGame) {
        setLayout(new GridLayout(3, 3));
        setBorder(BorderFactory.createEmptyBorder(10,0,0,0));

        gamelogic = new GameLogic(buttons);

        for (int i = 0; i < buttons.length; i++) {
            for (int j = 0; j < buttons[i].length; j++) {

                buttons[i][j] = new Square();
                buttons[i][j].setButton(new JButton());
                buttons[i][j].setMarker(Player.none);

                int x = i;
                int y = j;

                buttons[i][j].getButton().setFont(new Font("Arial", Font.BOLD, 40));
                buttons[i][j].getButton().setFocusPainted(false);
                buttons[i][j].getButton().setBackground(Color.WHITE);
                buttons[i][j].getButton().setPreferredSize(new Dimension(100, 100));

                buttons[i][j].getButton().addActionListener(_ -> {
                    // Ignore clicks on squares that are already used.
                    if (gamelogic.makeMove(x, y)) {

                        buttons[x][y].getButton()
                                .setText(String.valueOf(gamelogic.getPlayer().displayName));

                        // Check whether the latest move finished a winning line.
                        if (gamelogic.checkWin(x, y)) {

                            switch (gamelogic.getPlayer()) {
                                case Player.playerX -> {
                                    ticTacToeGame.scoreboard.addPointForX();
                                    System.out.println(Player.playerX == gamelogic.getPlayer());
                                }

                                case Player.playerO -> {
                                    ticTacToeGame.scoreboard.addPointForO();
                                    System.out.println(Player.playerO == gamelogic.getPlayer());
                                }

                                default -> System.out.println("Error");
                            }

                            JOptionPane.showMessageDialog(this,"Player " + gamelogic.getPlayer().displayName + " wins!");
                            resetBoard(gamelogic.switchPlayer());
                            ticTacToeGame.scoreboard.updatePlayerHighlight(gamelogic.getPlayer());
                            return;
                        }

                        if (gamelogic.isDraw()) {
                            JOptionPane.showMessageDialog(this, "Draw!");
                            resetBoard(Player.playerX);
                            ticTacToeGame.scoreboard.updatePlayerHighlight(gamelogic.getPlayer());
                            return;
                        }

                        gamelogic.switchPlayer();
                        ticTacToeGame.scoreboard.updatePlayerHighlight(gamelogic.getPlayer());
                    }
                });

                add(buttons[i][j].getButton());
            }
        }

        setVisible(true);
    }

    public void resetBoard(Player player) {
        gamelogic.resetBoard();
        gamelogic.setPlayer(player);

        for (Square[] button : buttons) {
            for (Square square : button) {
                square.getButton().setText("");
                square.getButton().setEnabled(true);
            }
        }
    }
}
