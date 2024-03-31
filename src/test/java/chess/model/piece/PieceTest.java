package chess.model.piece;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import chess.model.position.Color;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PieceTest {

  @Test
  @DisplayName("피스_객체_생성_시_색이_올바르게_설정되어야_한다")
  void 피스_객체_생성_시_색이_올바르게_설정되어야_한다() {
    //given
    Color color = Color.WHITE;

    //when
    Piece piece = new TestPiece(color);

    //then
    assertThat(piece.getColor()).isEqualTo(color);
  }

  private static class TestPiece extends Piece {
    public TestPiece(Color color) {
      super(color);
    }
  }
}
