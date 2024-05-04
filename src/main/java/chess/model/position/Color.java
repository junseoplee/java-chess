package chess.model.position;

public enum Color {

  BLACK,
  WHITE,
  NONE;

  public boolean isDifferentColor(Color color) {
    return this != color;
  }

  public boolean isSameColor(Color color) {
    return this == color;
  }
}
