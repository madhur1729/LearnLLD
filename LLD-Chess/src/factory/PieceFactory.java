package factory;

import Enums.Colour;
import Enums.Pieces;
import model.Piece;
import strategy.PiceceStrategyImpl.PawnPiece;

public class PieceFactory {

    public Piece createPiece(Colour colour, Pieces type){
        return switch((type)){
            case PAWN -> new Piece(colour, new PawnPiece());
            default -> null;
        };
    }
}
