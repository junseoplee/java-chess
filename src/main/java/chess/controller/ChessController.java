package chess.controller;

import static chess.view.InputView.END_COMMAND;

import chess.model.board.Board;
import chess.model.board.InitialBoard;
import chess.model.position.Color;
import chess.model.position.Position;
import chess.view.InputView;
import chess.view.OutputView;
import java.util.List;

public class ChessController {

  private final InputView inputView;
  private final OutputView outputView;
  private final Board board;
  private Color currentTurn;

  public ChessController(InputView inputView, OutputView outputView, InitialBoard initialBoard) {
    this.inputView = inputView;
    this.outputView = outputView;
    this.board = initialBoard.createInitialBoard();
    this.currentTurn = Color.WHITE;
  }

  public void runChess() {
    outputView.printStartMessage();
    String receivedCommand = inputView.receiveStartCommand();
    if (!receivedCommand.equals(InputView.START_COMMAND)) {
      return;
    }

    outputView.printBoard(board.getMap());

    while (true) {
      try {
        List<String> receivedMoveOrEndCommand = inputView.receiveMoveOrEndCommand();
        if (receivedMoveOrEndCommand.get(0).equals(END_COMMAND)) {
          break;
        }
        Position sourcePosition = parsePosition(receivedMoveOrEndCommand.get(0));
        Position targetPosition = parsePosition(receivedMoveOrEndCommand.get(1));
        board.move(sourcePosition, targetPosition, currentTurn);
        currentTurn = currentTurn.changeTurn(currentTurn);
        outputView.printBoard(board.getMap());
      } catch (IllegalArgumentException exception) {
        System.out.println(exception.getMessage());
      }
    }
  }

  private Position parsePosition(String position) {
    int file = position.charAt(0) - 'a' + 1;
    int rank = position.charAt(1) - '0';
    return new Position(file, rank); // 생성자에 1~8 유효성 검사
  }
}
