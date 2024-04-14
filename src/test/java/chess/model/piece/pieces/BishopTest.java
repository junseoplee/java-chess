package chess.model.piece.pieces;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import chess.model.position.Color;
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
}
