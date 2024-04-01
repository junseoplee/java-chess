package chess.model.piece.pieces;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import chess.model.position.Color;
import chess.model.position.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class KingTest {

  @Test
  @DisplayName("킹_초기화_테스트")
  void 킹_초기화_테스트() {
    //given
    Color color = Color.WHITE;
    Position position = new Position('e', 1);

    //when
    King king =new King(color, position);

    //then
    assertThat(king.getColor()).isEqualTo(color);
    assertThat(king.getPosition()).isEqualTo(position);
  }
}
