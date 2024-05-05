package chess.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {

  private static final Scanner scanner = new Scanner(System.in);
  public static final String START_COMMAND = "start";
  public static final String END_COMMAND = "end";
  public static final String MOVE_COMMAND = "move";

  public String receiveStartCommand() {
    String receivedCommand = scanner.nextLine();
    if (!receivedCommand.equals(START_COMMAND)) {
      throw new IllegalArgumentException(ErrorMessage.INVALID_START_COMMAND.getMessage());
    }
    return receivedCommand;
  }

  public List<String> receiveMoveOrEndCommand() {
    String receivedCommand = scanner.nextLine();
    List<String> dividedCommand =
        Arrays.stream(receivedCommand.split(" ")).toList();
    if (dividedCommand.size() == 3 && dividedCommand.get(0).equals(MOVE_COMMAND)) {
      return List.of(dividedCommand.get(1), dividedCommand.get(2));
    }
    if (dividedCommand.get(0).equals(END_COMMAND)) {
      return List.of(dividedCommand.get(0));
    }
    throw new IllegalArgumentException(ErrorMessage.INVALID_MOVE_COMMAND.getMessage());
  }
}
