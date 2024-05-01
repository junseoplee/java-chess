package chess.model.movement;

import chess.model.position.File;
import chess.model.position.Position;
import chess.model.position.Rank;

public enum Movement {
  UP(0, 1),
  DOWN(0, -1),
  LEFT(-1, 0),
  RIGHT(1, 0),

  UP_LEFT(-1, 1),
  UP_RIGHT(1, 1),
  DOWN_LEFT(-1, -1),
  DOWN_RIGHT(1, -1),

  L_UP_LEFT(-1, 2),
  L_UP_RIGHT(1, 2),
  L_DOWN_LEFT(-1, -2),
  L_DOWN_RIGHT(1, -2),
  L_LEFT_UP(-2, 1),
  L_LEFT_DOWN(-2, -1),
  L_RIGHT_UP(2, 1),
  L_RIGHT_DOWN(2, -1);

  private final int fileChange;
  private final int rankChange;

  Movement(int fileChange, int rankChange) {
    this.fileChange = fileChange;
    this.rankChange = rankChange;
  }

  public Position findNextPositionFrom(File file, Rank rank) {
    return new Position(file.getValue() + this.fileChange,
        rank.getValue() + this.rankChange);
  }
}
