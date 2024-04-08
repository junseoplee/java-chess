package chess.model.position;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PositionTest {

  @Test
  @DisplayName("포지션_객체_생성_시_파일과_랭크가_올바르게_설정되어야_한다")
  void 포지션_객체_생성_시_파일과_랭크가_올바르게_설정되어야_한다() {
    //given
    int file = 3;
    int rankNumber = 4;

    //when
    Position position = new Position(file, rankNumber);

    //then
    assertThat(position.getFile()).isEqualTo(File.C);
    assertThat(position.getRank()).isEqualTo(Rank.RANK_4);
  }
}
