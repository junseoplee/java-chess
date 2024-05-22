package chess.model.Command;

import chess.controller.ChessController;
import chess.model.position.Position;

public class MoveCommand implements CommandLauncher {
  private final Position source;
  private final Position target;

  public MoveCommand(Position source, Position target) {
    this.source = source;
    this.target = target;
  }

  @Override
  public void execute(ChessController controller) {
    controller.movePiece(source, target);
  }
}
