package chess.view;

import chess.model.Command;
import java.util.Scanner;

public class InputView {

  private static final Scanner scanner = new Scanner(System.in);

  public Command receiveCommand() {
    String inputCommand = scanner.nextLine();
    return new Command(inputCommand);
  }
}
