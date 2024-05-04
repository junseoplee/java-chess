package chess.model.piece.pieces;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import chess.model.position.Color;
import chess.model.position.Position;
import chess.view.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BishopTest {

  @Test
  @DisplayName("비숍_초기화_테스트")
  void 비숍_초기화_테스트() {
    //given
    Color color = Color.WHITE;

    //when
    Bishop bishop = new Bishop(color);

    //then
    assertThat(bishop.getColor()).isEqualTo(color);
  }

  @Test
  @DisplayName("비숍은_상하좌우로는_움직일_수_없다")
  void 비숍은_상하좌우로는_움직일_수_없다() {
    // given
    Bishop bishop = new Bishop(Color.WHITE);
    Position from = new Position(4, 4);
    Position to = new Position(4, 6);

    // when & then
    assertThatThrownBy(() -> bishop.findPath(from, to))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining(ErrorMessage.INVALID_DIRECTION.getMessage());
  }
}
