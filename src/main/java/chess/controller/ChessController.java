package chess.controller;

import chess.model.command.CommandFactory;
import chess.model.command.CommandLauncher;
import chess.model.ErrorMessage;
import chess.model.board.Board;
import chess.model.board.InitialBoard;
import chess.model.piece.Piece;
import chess.model.piece.PieceInfo;
import chess.model.position.Color;
import chess.model.position.Position;
import chess.view.InputView;
import chess.view.OutputView;

public class ChessController {

  private final InputView inputView;
  private final OutputView outputView;
  private final CommandFactory commandFactory;
  private final Board board;
  private Color currentTurn;
  private boolean isRunning;

  public ChessController(InputView inputView, OutputView outputView, CommandFactory commandFactory, InitialBoard initialBoard) {
    this.inputView = inputView;
    this.outputView = outputView;
    this.commandFactory = commandFactory;
    this.board = initialBoard.createInitialBoard();
    this.currentTurn = Color.WHITE;
    this.isRunning = true;
  }

  public void runChess() {
    outputView.printStartMessage();
    CommandLauncher receivedCommand = null;

    while (receivedCommand == null) {
      try {
        String initialCommandInput = inputView.receiveCommand();
        receivedCommand = commandFactory.createCommand(initialCommandInput);
        if (receivedCommand.validateInitialCommandType()) {
          break;
        }
        System.out.println(ErrorMessage.INVALID_INITIAL_COMMAND.getMessage());
        receivedCommand = null;
      } catch (IllegalArgumentException exception) {
        System.out.println(exception.getMessage());
      }
    }

      receivedCommand.execute(this);

    while (isRunning) {
      try {
        receivedCommand = commandFactory.createCommand(inputView.receiveCommand());
        receivedCommand.execute(this);
      } catch (IllegalArgumentException exception) {
        System.out.println(exception.getMessage());
      }
    }
  }

  public void startGame() {
    outputView.printBoard(board.getMap());
  }

  public void endGame() {
    isRunning = false;
  }

  public void movePiece(Position source, Position target) {
    Piece capturedPiece = board.move(source, target, currentTurn);
    if (capturedPiece.pieceType() == PieceInfo.KING) {
      endGame();
    }
    currentTurn = currentTurn.changeTurn(currentTurn);
    outputView.printBoard(board.getMap());
  }
}
