package model;

public class Game {
    Board board;
    Player player1;
    Player player2;
    boolean turn;

    public Game(boolean turn, Player player2, Player player1, int size) {
        this.turn = turn;
        this.player2 = player2;
        this.player1 = player1;
        this.board = new Board(size);
    }
}
