package chess.model.piece.pieces;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import chess.model.position.Color;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class KingTest {

  @Test
  @DisplayName("킹_초기화_테스트")
  void 킹_초기화_테스트() {
    //given
    Color color = Color.WHITE;

    //when
    King king =new King(color);

    //then
    assertThat(king.getColor()).isEqualTo(color);
  }
}
