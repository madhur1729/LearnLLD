package model;

import Enums.Colour;
import Enums.Pieces;
import factory.PieceFactory;
import strategy.PieceStrategy;

public class Piece {
    Colour colour;
    PieceStrategy pieceStrategy;

    public Piece(Colour color, PieceStrategy pieceStrategy){
        this.colour =colour;
        this.pieceStrategy = pieceStrategy;
    }
}
