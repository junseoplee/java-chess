package chess.controller;

import static chess.model.Command.END_COMMAND;

import chess.model.Command;
import chess.model.board.Board;
import chess.model.board.InitialBoard;
import chess.model.position.Color;
import chess.model.position.Position;
import chess.view.ErrorMessage;
import chess.view.InputView;
import chess.view.OutputView;

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
    Command receivedCommand = new Command(inputView.receiveCommand());

    if (receivedCommand.getCommand().equals(END_COMMAND)) {
      return;
    }
    if (!receivedCommand.getCommand().equals(Command.START_COMMAND)) {
      throw new IllegalArgumentException(ErrorMessage.INVALID_START_COMMAND.getMessage());
    }

    outputView.printBoard(board.getMap());

    while (true) {
      try {
        receivedCommand = new Command(inputView.receiveCommand());
        if (receivedCommand.getCommand().equals(END_COMMAND)) {
          break;
        }
        Position sourcePosition = parsePosition(receivedCommand.getSourcePosition());
        Position targetPosition = parsePosition(receivedCommand.getTargetPosition());
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
    return new Position(file, rank); // 생성자에 1~8 유효성 검사가 있다
  }
}
