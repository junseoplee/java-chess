package chess.model.board;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import chess.model.piece.Piece;
import chess.model.piece.pieces.Pawn;
import chess.model.position.Color;
import chess.model.position.InitialPosition;
import chess.model.position.Position;
import chess.view.ErrorMessage;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BoardTest {

  private Board board;

  @BeforeEach
  void setUp() {
    Map<Position, Piece> initialBoard = new HashMap<>();
    board = new Board(initialBoard);
  }

  @Test
  @DisplayName("보드_테스트")
  void 보드_테스트() {
    // given
    Position position = InitialPosition.BLACK_PAWN_F.getPosition();
    Piece pawn = new Pawn(Color.BLACK);

    // when
    board.getMap().put(position, pawn);
    Map<Position, Piece> retrievedMap = board.getMap();

    // then
    assertThat(retrievedMap).containsEntry(position, pawn);
  }

  @Test
  @DisplayName("출발점에_말이_없으면_예외_발생")
  void 출발점에_말이_없으면_예외_발생() {
    // given
    Position from = new Position(1, 1);
    Position to = new Position(1, 2);

    // when & then
    assertThatThrownBy(() -> board.move(from, to, Color.WHITE))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining(ErrorMessage.NO_PIECE_AT_SOURCE.getMessage());
  }
}
