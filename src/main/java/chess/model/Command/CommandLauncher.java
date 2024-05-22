package chess.model.Command;

import chess.controller.ChessController;

public interface CommandLauncher {
  void execute(ChessController controller);
}
