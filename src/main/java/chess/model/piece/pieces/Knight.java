package chess.model.piece.pieces;

import chess.model.piece.Piece;
import chess.model.position.Color;
import chess.model.position.Position;

public class Knight extends Piece {

  private final Position position;

  public Knight(final Color color, final Position position) {
    super(color);
    this.position = position;
  }

  public Position getPosition() {
    return position;
  }
}
