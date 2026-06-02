package model;

import Enums.Pieces;
import Enums.Colour;

public class Tile {
    Colour colour;
    Pieces piece;

    public Tile(Colour colour, Pieces piece) {
        this.colour = colour;
        this.piece = piece;
    }

    public Colour getColour() {
        return colour;
    }

    public void setColour(Colour colour) {
        this.colour = colour;
    }

    public Pieces getPiece() {
        return piece;
    }

    public void setPiece(Pieces piece) {
        this.piece = piece;
    }
}
