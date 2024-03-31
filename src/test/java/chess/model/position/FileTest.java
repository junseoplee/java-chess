package chess.model.position;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class FileTest {

  @Test
  @DisplayName("규격이_올바르지_않은_경우_예외_처리한다")
  void 규격이_올바르지_않은_경우_예외_처리한다() {
    assertThatThrownBy(() -> File.from('z'))
        .isInstanceOf(IllegalArgumentException.class);
  }
}
