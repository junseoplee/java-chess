package chess.view;

import chess.model.Command;
import java.util.Scanner;

public class InputView {

  private static final Scanner scanner = new Scanner(System.in);

  public Command receiveStartCommand() {
    System.out.println("체스 게임을 시작합니다.");
    System.out.println("게임 시작은 start, 종료는 end 명령을 입력하세요.");

    String inputCommand = scanner.nextLine();
    return new Command(inputCommand);
  }
}