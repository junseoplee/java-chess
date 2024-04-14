package chess.model.board;

import static org.assertj.core.api.Assertions.assertThat;

import chess.model.piece.Piece;
import chess.model.piece.pieces.King;
import chess.model.position.Color;
import chess.model.position.InitialPosition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InitialBoardTest {

  @Test
  @DisplayName("블랙_킹이_올바른_위치에_있는지_확인")
  void 블랙_킹이_올바른_위치에_있는지_확인() {
    //given
    InitialBoard initialBoard = new InitialBoard();

    //when
    Board board = initialBoard.createInitialBoard();
    Piece pieceAtBlackKingPosition = board.getMap().get(InitialPosition.BLACK_KING.getPosition());

    //then
    assertThat(pieceAtBlackKingPosition)
        .isInstanceOf(King.class)
        .extracting("color")
        .isEqualTo(Color.BLACK);
  }
}
