package chess.controller;

import chess.model.Command;
import chess.model.board.Board;
import chess.model.board.InitialBoard;
import chess.model.piece.Piece;
import chess.model.position.Position;
import chess.view.ErrorMessage;
import chess.view.InputView;
import chess.view.OutputView;
import java.util.Map;

public class ChessController {

  private final InputView inputView;
  private final OutputView outputView;
  private final InitialBoard initialBoard;

  public ChessController(InputView inputView, OutputView outputView, InitialBoard initialBoard) {
    this.inputView = inputView;
    this.outputView = outputView;
    this.initialBoard = initialBoard;
  }

  public void runChess() {
    outputView.printStartMessage();
    processCommand();
  }

  private void processCommand() {
    try {
      Command command = inputView.receiveCommand();
      Board board = initialBoard.createInitialBoard();
      Map<Position, Piece> boardMap = board.getMap();

      switch (command.getCommand()) {
        case "start":
          outputView.printBoard(boardMap);
          processCommand();
          break;
        case "end":
          break;
        default:
          throw new IllegalArgumentException(ErrorMessage.MISMATCH_COMMAND.getMessage());
      }
    } catch (IllegalArgumentException exception) {
      System.out.println(exception.getMessage());
      processCommand();
    }
  }
}
