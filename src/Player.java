public enum Player {
    playerX('X'),
    playerO('O'),
    none(' ');

    public final char displayName;
    Player(char displayName) {
        this.displayName = displayName;
    }
}
