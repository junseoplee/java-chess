package chess.model.board;

import chess.model.movement.Path;
import chess.model.piece.Piece;
import chess.model.position.Color;
import chess.model.position.Position;
import chess.model.ErrorMessage;
import java.util.Map;

public class Board {

  private final Map<Position, Piece> board;

  public Board(final Map<Position, Piece> board) {
    this.board = board;
  }

  public Piece move(final Position from, final Position to, final Color turn) {
    validateMove(from, to, turn);
    Piece capturedPiece = capturePiece(to);
    movePiece(from, to);
    return capturedPiece;
  }

  private void validateMove(final Position from, final Position to, final Color turn) {
    validateNotEmpty(from);
    validateTurn(from, turn);

    Piece destination = board.getOrDefault(to, null);
    board.get(from).validateSameColor(destination);

    Path path = board.get(from).findPath(from, to);
    path.validatePath(board.keySet(), to);
  }

  private void validateNotEmpty(final Position from) {
    if (!board.containsKey(from)) {
      throw new IllegalArgumentException(ErrorMessage.NO_PIECE_AT_SOURCE.getMessage());
    }
  }

  private void validateTurn(final Position from, final Color turn) {
    board.get(from).validateTurn(turn);
  }

  private void movePiece(final Position from, final Position to) {
    Piece piece = board.remove(from);
    board.put(to, piece);
  }

  private Piece capturePiece(final Position to) {
    return board.remove(to);
  }

  public Map<Position, Piece> getMap() {
    return Map.copyOf(board);
  }
}
