package chess.model.piece.pieces;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import chess.model.position.Color;
import chess.model.position.Position;
import chess.view.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class KnightTest {

  @Test
  @DisplayName("나이트_초기화_테스트")
  void 나이트_초기화_테스트() {
    //given
    Color color = Color.WHITE;

    //when
    Knight knight = new Knight(color);

    //then
    assertThat(knight.getColor()).isEqualTo(color);
  }

  @Test
  @DisplayName("나이트는_L자_형태_외의_방식으로는_움직일_수_없다")
  void 나이트는_L자_형태_외의_방식으로는_움직일_수_없다() {
    // given
    Knight knight = new Knight(Color.WHITE);
    Position from = new Position(4, 4);
    Position to = new Position(6, 6);

    // when & then
    assertThatThrownBy(() -> knight.findPath(from, to))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining(ErrorMessage.INVALID_DIRECTION.getMessage());
  }
}
