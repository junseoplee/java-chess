package chess.model.piece.pieces;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import chess.model.position.Color;
import chess.model.position.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class KnightTest {

  @Test
  @DisplayName("나이트_초기화_테스트")
  void 나이트_초기화_테스트() {
    //given
    Color color = Color.WHITE;
    Position position = new Position('b', 1);

    //when
    Knight knight = new Knight(color, position);

    //then
    assertThat(knight.getColor()).isEqualTo(color);
    assertThat(knight.getPosition()).isEqualTo(position);
  }
}
