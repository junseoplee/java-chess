package chess.controller;

import chess.model.Command;
import chess.model.board.Board;
import chess.model.board.InitialBoard;
import chess.model.piece.Piece;
import chess.model.position.Position;
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
    boolean running = true;

    while (running) {
      try {
        Command command = inputView.receiveCommand();
        Board board = initialBoard.createInitialBoard();
        Map<Position, Piece> boardMap = board.getMap();

        if ("start".equals(command.getCommand())) {
          outputView.printBoard(boardMap);
        }
        if ("end".equals(command.getCommand())) {
          running = false;
        }
      } catch (IllegalArgumentException exception) {
        System.out.println(exception.getMessage());
      }
    }
  }
}
