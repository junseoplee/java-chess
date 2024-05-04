package chess.model.piece.pieces;

import chess.model.movement.Movement;
import chess.model.movement.Path;
import chess.model.piece.Piece;
import chess.model.position.Color;
import chess.model.position.Position;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Rook extends Piece {

  private static final List<Movement> availableMovements = Arrays.asList(
      Movement.UP, Movement.DOWN, Movement.LEFT, Movement.RIGHT
  );

  public Rook(final Color color) {
    super(color);
  }

  @Override
  public Path findPath(final Position from, final Position to) {
    Movement movement = to.convertMovement(from);
    validateMovement(movement, availableMovements);

    return calculatePath(from, to, movement);
  }

  private Path calculatePath(final Position from, final Position to, final Movement movement) {
    List<Position> positions = new ArrayList<>();

    Position current = from;
    while (!current.equals(to)) {
      current = current.calculateNextPosition(movement);
      positions.add(current);
    }

    return new Path(positions);
  }
}
