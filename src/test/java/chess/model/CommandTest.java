package chess.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CommandTest {

  @ParameterizedTest
  @ValueSource(strings = {"start", "end", "move e2 e4"})
  @DisplayName("올바른_명령어_입력_시_Command_객체가_생성된다")
  void 올바른_명령어_입력_시_Command_객체가_생성된다(String inputCommand) {
    // when
    Command command = new Command(inputCommand);

    // then
    assertThat(command).isNotNull();
  }

  @ParameterizedTest
  @ValueSource(strings = {"invalid", "move", "move e2", "move e2 e4 e5"})
  @DisplayName("올바르지_않은_명령어_입력_시_예외가_발생한다")
  void 올바르지_않은_명령어_입력_시_예외가_발생한다(String inputCommand) {
    // when & then
    assertThatThrownBy(() -> new Command(inputCommand))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  @DisplayName("move_명령어의_출발_위치와_도착_위치가_올바르게_파싱된다")
  void move_명령어의_출발_위치와_도착_위치가_올바르게_파싱된다() {
    // given
    String inputCommand = "move e2 e4";

    // when
    Command command = new Command(inputCommand);

    // then
    assertThat(command.getSourcePosition()).isEqualTo("e2");
    assertThat(command.getTargetPosition()).isEqualTo("e4");
  }
}
