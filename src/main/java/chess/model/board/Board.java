package chess.model.board;

import chess.model.piece.Piece;
import chess.model.position.Position;
import java.util.Map;

public class Board {

  private final Map<Position, Piece> board;

  public Board(Map<Position, Piece> board) {
    this.board = board;
  }

  public Map<Position, Piece> getMap() {
    return board;
  }
}
