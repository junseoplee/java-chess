package chess.model.position;

import chess.view.ErrorMessage;
import java.util.Arrays;

public enum Rank {
  RANK_1(1),
  RANK_2(2),
  RANK_3(3),
  RANK_4(4),
  RANK_5(5),
  RANK_6(6),
  RANK_7(7),
  RANK_8(8);

  private final int rank;

  Rank(int rank) {
    this.rank = rank;
  }

  public static Rank from(int rankInt) {
    return Arrays.stream(Rank.values())
                 .filter(rank -> rank.getRank() == rankInt)
                 .findFirst()
                 .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.MISMATCH_ARGUMENT.getMessage()));
  }

  public int getRank() {
    return rank;
  }
}

