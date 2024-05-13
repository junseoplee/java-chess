package chess.model.position;

public enum Color {

  BLACK,
  WHITE;

  public boolean isSameColor(Color color) {
    return this == color;
  }

  public Color changeTurn(Color currentTurn) {
    if (currentTurn == WHITE) {
      return BLACK;
    }
    return WHITE;
  }
}
