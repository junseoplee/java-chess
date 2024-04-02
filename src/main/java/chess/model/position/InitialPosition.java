package chess.model.position;

public enum InitialPosition {
  WHITE_ROOK_LEFT('a', 1),
  WHITE_KNIGHT_LEFT('b', 1),
  WHITE_BISHOP_LEFT('c', 1),
  WHITE_QUEEN('d', 1),
  WHITE_KING('e', 1),
  WHITE_BISHOP_RIGHT('f', 1),
  WHITE_KNIGHT_RIGHT('g', 1),
  WHITE_ROOK_RIGHT('h', 1),
  WHITE_PAWN_A('a', 2),
  WHITE_PAWN_B('b', 2),
  WHITE_PAWN_C('c', 2),
  WHITE_PAWN_D('d', 2),
  WHITE_PAWN_E('e', 2),
  WHITE_PAWN_F('f', 2),
  WHITE_PAWN_G('g', 2),
  WHITE_PAWN_H('h', 2),
  BLACK_ROOK_LEFT('a', 8),
  BLACK_KNIGHT_LEFT('b', 8),
  BLACK_BISHOP_LEFT('c', 8),
  BLACK_QUEEN('d', 8),
  BLACK_KING('e', 8),
  BLACK_BISHOP_RIGHT('f', 8),
  BLACK_KNIGHT_RIGHT('g', 8),
  BLACK_ROOK_RIGHT('h', 8),
  BLACK_PAWN_A('a', 7),
  BLACK_PAWN_B('b', 7),
  BLACK_PAWN_C('c', 7),
  BLACK_PAWN_D('d', 7),
  BLACK_PAWN_E('e', 7),
  BLACK_PAWN_F('f', 7),
  BLACK_PAWN_G('g', 7),
  BLACK_PAWN_H('h', 7);

  private final char file;
  private final int rank;

  InitialPosition(char file, int rank) {
    this.file = file;
    this.rank = rank;
  }

  public Position getPosition() {
    return new Position(file, rank);
  }

  public char getFile() {
    return file;
  }

  public int getRank() {
    return rank;
  }
}
