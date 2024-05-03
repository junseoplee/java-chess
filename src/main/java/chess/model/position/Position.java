package chess.model.position;

import chess.model.movement.Movement;
import chess.view.ErrorMessage;

public class Position {
  private final File file;
  private final Rank rank;

  public Position(final int file, final int rank) {
    this.file = File.from(file);
    this.rank = Rank.from(rank);
  }

  public Movement convertMovement(Position from) {
    int fileDiff = this.file.getValue() - from.getFile().getValue();
    int rankDiff = this.rank.getValue() - from.getRank().getValue();

    validateSamePosition(fileDiff, rankDiff);

    int gcd = getGreatestCommonDivisor(Math.abs(fileDiff), Math.abs(rankDiff));

    Movement movement = Movement.findMovement(fileDiff / gcd, rankDiff / gcd);
    if (movement != null) {
      return movement;
    }

    throw new IllegalArgumentException(ErrorMessage.INVALID_DIRECTION.getMessage());
  }

  private int getGreatestCommonDivisor(int a, int b) {
    if (b == 0) {
      return a;
    }
    return getGreatestCommonDivisor(b, a % b);
  }

  private void validateSamePosition(int fileDiff, int rankDiff) {
    if (fileDiff == 0 && rankDiff == 0) {
      throw new IllegalArgumentException(ErrorMessage.SAME_POSITION.getMessage());
    }
  }

  public Position calculateNextPosition(Movement movement) {
    return movement.findNextPositionFrom(file, rank);
  }

  public File getFile() {
    return file;
  }

  public Rank getRank() {
    return rank;
  }
}
