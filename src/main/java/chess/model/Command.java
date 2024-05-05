package chess.model;

import chess.view.ErrorMessage;

import java.util.List;

public class Command {

  public static final String START_COMMAND = "start";
  public static final String END_COMMAND = "end";
  public static final String MOVE_COMMAND = "move";
  private static final int COMMAND_INDEX = 0;
  private static final int SOURCE_POSITION_INDEX = 1;
  private static final int TARGET_POSITION_INDEX = 2;
  private static final int MOVE_COMMAND_PARTS_COUNT = 3;

  private final String command;
  private final String sourcePosition;
  private final String targetPosition;

  public Command(String inputCommand) {
    validateCommand(inputCommand);
    List<String> commandParts = List.of(inputCommand.split(" "));
    this.command = commandParts.get(COMMAND_INDEX);
    this.sourcePosition = getPositionFromCommandParts(commandParts, SOURCE_POSITION_INDEX);
    this.targetPosition = getPositionFromCommandParts(commandParts, TARGET_POSITION_INDEX);
  }

  private String getPositionFromCommandParts(List<String> commandParts, int positionIndex) {
    if (commandParts.size() > positionIndex) {
      return commandParts.get(positionIndex);
    }
    return null;
  }

  private void validateCommand(String inputCommand) {
    List<String> commandParts = List.of(inputCommand.split(" "));
    String command = commandParts.get(COMMAND_INDEX);
    if (!command.equals(START_COMMAND) && !command.equals(END_COMMAND) && !command.equals(MOVE_COMMAND)) {
      throw new IllegalArgumentException(ErrorMessage.INVALID_COMMAND.getMessage());
    }
    if (command.equals(MOVE_COMMAND) && commandParts.size() != MOVE_COMMAND_PARTS_COUNT) {
      throw new IllegalArgumentException(ErrorMessage.INVALID_MOVE_COMMAND.getMessage());
    }
  }

  public String getCommand() {
    return command;
  }

  public String getSourcePosition() {
    return sourcePosition;
  }

  public String getTargetPosition() {
    return targetPosition;
  }
}
