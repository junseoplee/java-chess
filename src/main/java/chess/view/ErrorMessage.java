package chess.view;

public enum ErrorMessage {

  MISMATCH_COMMAND("[ERROR] 명령은 start, end 중 하나여야 합니다.");

  private final String message;

  ErrorMessage(String message) {
    this.message = message;
  }

  public String getMessage() {
    return message;
  }
}
