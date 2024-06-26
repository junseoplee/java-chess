package chess.model.piece.pieces;

import chess.model.movement.Movement;
import chess.model.movement.Path;
import chess.model.piece.Piece;
import chess.model.position.Color;
import chess.model.position.Position;
import chess.view.ErrorMessage;
import java.util.List;

public class King extends Piece {

  private static final List<Movement> availableMovements = List.of(
      Movement.UP, Movement.DOWN, Movement.LEFT, Movement.RIGHT,
      Movement.UP_LEFT, Movement.UP_RIGHT, Movement.DOWN_LEFT, Movement.DOWN_RIGHT);

  public King(final Color color) {
    super(color);
  }

  @Override
  public Path findPath(Position from, Position to) {
    Movement movement = to.convertMovement(from);
    validateMovement(movement, availableMovements);

    validateAvailableDestination(from, to, movement);

    return new Path(List.of(to));
  }

  private void validateAvailableDestination(final Position from, final Position to, final Movement movement) {
    if (!from.calculateNextPosition(movement).equals(to)) { // 한 칸 씩만 움직이기 때문에 목적지만 판단
      throw new IllegalStateException(ErrorMessage.INVALID_DIRECTION.getMessage());
    }
  }
}
