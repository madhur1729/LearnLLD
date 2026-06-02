package model;

public class Game {
    Board board;
    Player player1;
    Player player2;
    boolean turn;

    public Game(Player player2, Player player1, int size) {
        this.turn = false;
        this.player2 = player2;
        this.player1 = player1;
        this.board = new Board(size);
    }
}
