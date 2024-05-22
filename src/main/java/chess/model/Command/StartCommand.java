package chess.model.Command;

import chess.controller.ChessController;

public class StartCommand implements CommandLauncher {
  @Override
  public void execute(ChessController controller) {
    controller.startGame();
  }
}
