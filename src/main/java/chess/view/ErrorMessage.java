package chess.view;

public enum ErrorMessage {
  MISMATCH_COMMAND("[ERROR] 명령은 start, end 중 하나여야 합니다."),
  MISMATCH_FILE_ARGUMENT("[ERROR] 잘못된 파일 규격입니다."),
  MISMATCH_RANK_ARGUMENT("[ERROR] 잘못된 랭크 규격입니다."),
  MISMATCH_SYMBOL("[ERROR] 잘못된 피스 타입입니다.");

  private final String message;

  ErrorMessage(String message) {
    this.message = message;
  }

  public String getMessage() {
    return message;
  }
}
