package chess.model.Command;

import chess.controller.ChessController;

public class EndCommand implements CommandLauncher {
  @Override
  public void execute(ChessController controller) {
    controller.endGame();
  }
}
