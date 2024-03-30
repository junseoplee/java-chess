package chess.model;

import chess.view.ErrorMessage;

public class Command {

  private static final String START_COMMAND = "start";
  private static final String END_COMMAND = "end";

  private final String command;

  public Command(String inputCommand) {
    validateStartCommand(inputCommand);
    this.command = inputCommand;
  }
  private void validateStartCommand(String startCommand) {
    if (!startCommand.equals(START_COMMAND) && !startCommand.equals(END_COMMAND)) {
      throw new IllegalArgumentException(ErrorMessage.MISMATCH_COMMAND.getMessage());
    }
  }

  public String getCommand() {
    return command;
  }
}
