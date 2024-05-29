package chess.model.command.commands;

import chess.controller.ChessController;
import chess.model.command.CommandLauncher;
import chess.model.score.ScoreCalculator;
import chess.model.position.Color;

public class StatusCommand implements CommandLauncher {
  @Override
  public void execute(ChessController controller) {
    controller.calculateAndPrintCurrentTurnScore();
  }

  @Override
  public boolean validateInitialCommandType() {
    return false;
  }
}
