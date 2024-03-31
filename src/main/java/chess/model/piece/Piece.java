package chess.model.piece;

import chess.model.position.Color;

public abstract class Piece {

  private final Color color;

  public Piece(final Color color) {
    this.color = color;
  }

  public Color getColor() {
    return color;
  }
}
