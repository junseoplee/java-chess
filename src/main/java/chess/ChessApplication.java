package chess;

import chess.controller.ChessController;
import chess.model.command.CommandFactory;
import chess.model.board.InitialBoard;
import chess.view.InputView;
import chess.view.OutputView;

public class ChessApplication {

  public static void main(String[] args) {

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    CommandFactory commandFactory = new CommandFactory();
    InitialBoard initialBoard = new InitialBoard();

    ChessController chessController = new ChessController(inputView, outputView, commandFactory,
        initialBoard);
    chessController.runChess();
  }
}
