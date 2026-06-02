package model;

import Enums.Colour;
import Enums.Pieces;

public class Board {
//    int row; int col;
    Tile[][] tiles;
    int size;

    public Board(int size){
        this.tiles = new Tile[size][size];
        this.size = size;

        for(int row = 0 ;row<size;row++){
            for(int col = 0; col<size;col++){
                tiles[row][col] = new Tile(Colour.BLACK, Pieces.PAWN);
            }
        }
    }
}
