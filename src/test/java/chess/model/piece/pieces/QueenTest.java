package chess.model.piece.pieces;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import chess.model.position.Color;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class QueenTest {

  @Test
  @DisplayName("퀸_초기화_테스트")
  void 퀸_초기화_테스트() {
    //given
    Color color = Color.WHITE;

    //when
    Queen queen = new Queen(color);

    //then
    assertThat(queen.getColor()).isEqualTo(color);
  }
}
