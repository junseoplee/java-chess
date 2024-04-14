package chess.model.position;

import chess.view.ErrorMessage;
import java.util.Arrays;

public enum File {
  FILE_A(1),
  FILE_B(2),
  FILE_C(3),
  FILE_D(4),
  FILE_E(5),
  FILE_F(6),
  FILE_G(7),
  FILE_H(8);

  private final int value;

  File(int file) {
    this.value = file;
  }

  public static File from(int value) {
    return Arrays.stream(File.values())
                 .filter(file -> file.getValue() == value)
                 .findFirst()
                 .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.MISMATCH_ARGUMENT.getMessage()));
  }

  public int getValue() {
    return value;
  }
}
