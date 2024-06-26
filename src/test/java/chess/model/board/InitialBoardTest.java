package chess.model.board;

import chess.model.piece.Piece;
import chess.model.piece.pieces.*;
import chess.model.position.Color;
import chess.model.position.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;

public class InitialBoardTest {

  @Test
  @DisplayName("초기 보드에는 정확히 32개의 말이 있어야 한다")
  public void 초기_보드에는_정확히_32개의_말이_있어야_한다() {
    InitialBoard initialBoard = new InitialBoard();
    Board board = initialBoard.createInitialBoard();
    Map<Position, Piece> boardMap = board.getMap();

    assertEquals(32, boardMap.size());
  }

  @Test
  @DisplayName("초기 보드에는 각 말의 정확한 수가 있어야 한다")
  public void 초기_보드에는_각_말의_정확한_수가_있어야_한다() {
    InitialBoard initialBoard = new InitialBoard();
    Board board = initialBoard.createInitialBoard();
    Map<Position, Piece> boardMap = board.getMap();

    long whitePawns = boardMap.values().stream().filter(piece -> piece instanceof Pawn && piece.getColor() == Color.WHITE).count();
    long blackPawns = boardMap.values().stream().filter(piece -> piece instanceof Pawn && piece.getColor() == Color.BLACK).count();
    assertEquals(8, whitePawns);
    assertEquals(8, blackPawns);

    long whiteKnights = boardMap.values().stream().filter(piece -> piece instanceof Knight && piece.getColor() == Color.WHITE).count();
    long blackKnights = boardMap.values().stream().filter(piece -> piece instanceof Knight && piece.getColor() == Color.BLACK).count();
    assertEquals(2, whiteKnights);
    assertEquals(2, blackKnights);
  }
}
