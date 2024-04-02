package chess.model.piece.pieces;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import chess.model.position.Color;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PawnTest {
  @Test
  @DisplayName("폰_초기화_테스트")
  void 폰_초기화_테스트() {
    //given
    Color color = Color.WHITE;

    //when
    Pawn pawn = new Pawn(color);

    //then
    assertThat(pawn.getColor()).isEqualTo(color);
  }
}
