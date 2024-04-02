package chess.model.board;


import static org.assertj.core.api.Assertions.assertThat;

import chess.model.piece.Piece;
import chess.model.piece.pieces.Pawn;
import chess.model.position.Color;
import chess.model.position.InitialPosition;
import chess.model.position.Position;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BoardTest {

  @Test
  @DisplayName("보드_테스트")
  void 보드_테스트() {
    //given
    Map<Position, Piece> initialBoard = new HashMap<>();
    Position position = InitialPosition.BLACK_PAWN_F.getPosition();
    Piece pawn = new Pawn(Color.BLACK);

    //when
    initialBoard.put(position, pawn);
    Board board = new Board(initialBoard);
    Map<Position, Piece> retrievedMap = board.getMap();

    //then
    assertThat(retrievedMap).containsEntry(position, pawn);
  }
}
