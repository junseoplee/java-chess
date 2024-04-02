package chess.model.piece.pieces;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import chess.model.position.Color;
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
}
