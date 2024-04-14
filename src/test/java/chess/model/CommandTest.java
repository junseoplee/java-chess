package chess.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CommandTest {

  @Test
  @DisplayName("게임_시작_명렁어_입력이_올바르지_않다면_예외_처리한다")
  void 게임_시작_명렁어_입력이_올바르지_않다면_예외_처리한다() {
    assertThatThrownBy(() -> new Command("invalid"))
        .isInstanceOf(IllegalArgumentException.class);
  }
}
