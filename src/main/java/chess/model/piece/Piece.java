package chess.model.piece;

import chess.model.movement.Movement;
import chess.model.movement.Path;
import chess.model.position.Color;
import chess.model.position.Position;
import chess.view.ErrorMessage;
import java.util.List;
import java.util.Objects;

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

  public void validateTurn(Color turn) {
    if (color != turn) {
      throw new IllegalArgumentException(ErrorMessage.INVALID_TURN.getMessage());
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Piece piece = (Piece) o;
    return color == piece.color;
  }

  @Override
  public int hashCode() {
    return Objects.hash(color);
  }

  public Color getColor() {
    return color;
  }
}
