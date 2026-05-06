public class GameLogic {
    private Player player = Player.playerX;
    private final Square[][] board;

    public GameLogic(Square[][] board) {
        this.board = board;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    // Switches between player X and player O.
    public Player switchPlayer() {
        player = (player == Player.playerX) ? Player.playerO : Player.playerX;
        return player;
    }

    // Places the current marker if the square is empty.
    public boolean makeMove(int x, int y) {
        if (board[x][y].getMarker() != Player.none) {
            return false;
        }

        board[x][y].setMarker(player);
        return true;
    }

    // Checks all directions around the last move for a full line.
    public boolean checkWin(int x, int y) {
        Player current = board[x][y].getMarker();

        int[][] directions = {
                {0, 1},     // horizontal
                {1, 0},     // vertical
                {1, 1},     //diagonal down-right
                {1, -1}     //diagonal up-right
        };

        for (int[] dir : directions) {
            int count = 1;
            count += countDirection(x, y, dir[0], dir[1], current);
            count += countDirection(x, y, -dir[0], -dir[1], current);

            if (count >= board.length) {
                return true;
            }
        }
        return false;
    }

    public boolean isDraw() {
        for (Square[] squares : board) {
            for (Square square : squares) {
                if (square.getMarker() == Player.none) {
                    return false;
                }
            }
        }
        return true;
    }

    // Counts equal markers in one direction until the line ends.
    private int countDirection(int x, int y, int dx, int dy, Player current) {
        int count = 0;
        int nx = x + dx;
        int ny = y + dy;

        while (nx >= 0 && nx < board.length && ny >= 0 && ny < board.length
                && board[nx][ny].getMarker() == current) {
            count++;
            nx += dx;
            ny += dy;
        }
        return count;
    }

    public void resetBoard() {
        for (Square[] squares : board) {
            for (Square square : squares) {
                square.setMarker(Player.none);
            }
        }
    }
}
