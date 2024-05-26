package chess.model.movement;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import chess.model.position.Position;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PathTest {

  @Test
  @DisplayName("경로에_다른_체스_말이_있다면_예외_처리한다")
  void 경로에_다른_체스_말이_있다면_예외_처리한다() {
    //given
    Position position = new Position(1, 1);
    //when
    Path path = new Path(List.of(position));
    //then
    assertThatThrownBy(() -> path.validatePath(Set.of(position)))
        .isInstanceOf(IllegalArgumentException.class);
  }
}
