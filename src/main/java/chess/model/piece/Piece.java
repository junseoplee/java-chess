package chess.model.piece;

import chess.model.movement.Movement;
import chess.model.movement.Path;
import chess.model.position.Color;
import chess.model.position.Position;
import chess.view.ErrorMessage;
import java.util.List;

public abstract class Piece {

  private final Color color;

  public Piece(final Color color) {
    this.color = color;
  }

  public abstract Path findPath(Position from, Position to);

  public void validateMovement(final Movement movement, List<Movement> availableMovements) {
    if (!availableMovements.contains(movement)) {
      throw new IllegalArgumentException(ErrorMessage.INVALID_DIRECTION.getMessage());
    }
  }

  public void validateSameColor(Piece other) {
    if (other != null && color.isSameColor(other.color)) {
      throw new IllegalArgumentException(ErrorMessage.SAME_COLOR_PIECE.getMessage());
    }
  }

  public Color getColor() {
    return color;
  }
}
