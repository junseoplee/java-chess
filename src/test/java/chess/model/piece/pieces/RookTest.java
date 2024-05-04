package chess.model.piece.pieces;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import chess.model.movement.Path;
import chess.model.position.Color;
import chess.model.position.Position;
import chess.view.ErrorMessage;
import org.assertj.core.api.InstanceOfAssertFactories;
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

  @Test
  @DisplayName("룩은_상하좌우_외의_방향으로는_움직일_수_없다")
  void 룩은_상하좌우_외의_방향으로는_움직일_수_없다() {
    //given
    Rook rook = new Rook(Color.WHITE);
    Position from = new Position(4, 4);
    Position to = new Position(6, 5);

    //when & then
    assertThatThrownBy(() -> rook.findPath(from, to))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining(ErrorMessage.INVALID_DIRECTION.getMessage());
  }
}
