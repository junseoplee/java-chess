package chess.model.movement;

import chess.model.position.File;
import chess.model.position.Position;
import chess.model.position.Rank;
import chess.view.ErrorMessage;
import java.util.Arrays;

public enum Movement {
  UP(0, 1),
  DOWN(0, -1),
  LEFT(-1, 0),
  RIGHT(1, 0),

  UP_LEFT(-1, 1),
  UP_RIGHT(1, 1),
  DOWN_LEFT(-1, -1),
  DOWN_RIGHT(1, -1),

  UP_UP_LEFT(-1, 2),
  UP_UP_RIGHT(1, 2),
  DOWN_DOWN_LEFT(-1, -2),
  DOWN_DOWN_RIGHT(1, -2),
  LEFT_LEFT_UP(-2, 1),
  LEFT_LEFT_DOWN(-2, -1),
  RIGHT_RIGHT_UP(2, 1),
  RIGHT_RIGHT_DOWN(2, -1);

  private final int fileChange;
  private final int rankChange;

  Movement(int fileChange, int rankChange) {
    this.fileChange = fileChange;
    this.rankChange = rankChange;
  }

  public static Movement findMovement(final int file, final int rank) {
    return Arrays.stream(Movement.values())
                 .filter(movement -> movement.fileChange == file && movement.rankChange == rank)
                 .findAny()
                 .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.INVALID_DIRECTION.getMessage()));
  }

  public Position findNextPositionFrom(File file, Rank rank) {
    return new Position(file.getValue() + this.fileChange,
        rank.getValue() + this.rankChange);
  }
}
