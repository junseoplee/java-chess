package chess.model.piece.pieces;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import chess.model.position.Color;
import chess.model.position.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class QueenTest {

  @Test
  @DisplayName("퀸_초기화_테스트")
  void 퀸_초기화_테스트() {
    //given
    Color color = Color.WHITE;
    Position position = new Position('d', 1);

    //when
    Queen queen = new Queen(color, position);

    //then
    assertThat(queen.getColor()).isEqualTo(color);
    assertThat(queen.getPosition()).isEqualTo(position);
  }
}
