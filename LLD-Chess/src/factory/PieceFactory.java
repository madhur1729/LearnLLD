package factory;

import Enums.Colour;
import Enums.Pieces;
import model.Piece;
import strategy.PiceceStrategyImpl.*;

public class PieceFactory {

    public Piece createPiece(Colour colour, Pieces type){
        return switch((type)){
            case PAWN -> new Piece(colour, new PawnPiece());
            case ROOK -> new Piece(colour, new RookPiece());
            case KNIGHT -> new Piece(colour, new KnightPiece());
            case BISHOP -> new Piece(colour, new BishopPiece());
            case QUEEN -> new Piece(colour, new QueenPiece());
            case KING -> new Piece(colour, new KingPiece());
            default -> null;
        };
    }
}
