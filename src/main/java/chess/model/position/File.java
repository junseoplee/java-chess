package chess.model.position;

import chess.view.ErrorMessage;
import java.util.Arrays;

public enum File {
  FILE_A('a'),
  FILE_B('b'),
  FILE_C('c'),
  FILE_D('d'),
  FILE_E('e'),
  FILE_F('f'),
  FILE_G('g'),
  FILE_H('h');

  private final char file;

  File(char file) {
    this.file = file;
  }

  public static File from(char fileChar) {
    return Arrays.stream(File.values())
                 .filter(file -> file.getFile() == fileChar)
                 .findFirst()
                 .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.MISMATCH_ARGUMENT.getMessage()));
  }

  public char getFile() {
    return file;
  }
}
