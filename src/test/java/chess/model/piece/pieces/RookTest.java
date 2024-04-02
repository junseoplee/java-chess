package chess.model.piece.pieces;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import chess.model.position.Color;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RookTest {

  @Test
  @DisplayName("룩_초기화_테스트")
  void 룩_초기화_테스트() {
    //given
    Color color = Color.WHITE;

    //when
    Rook rook = new Rook(color);

    //then
    assertThat(rook.getColor()).isEqualTo(color);
  }
}
