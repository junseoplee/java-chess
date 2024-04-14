package chess.view;

import chess.model.piece.Piece;
import chess.model.piece.pieces.Bishop;
import chess.model.piece.pieces.King;
import chess.model.piece.pieces.Knight;
import chess.model.piece.pieces.Pawn;
import chess.model.piece.pieces.Queen;
import chess.model.piece.pieces.Rook;

public enum Symbol {
  KING_WHITE("k"),
  QUEEN_WHITE("q"),
  ROOK_WHITE("r"),
  BISHOP_WHITE("b"),
  KNIGHT_WHITE("n"),
  PAWN_WHITE("p"),

  KING_BLACK("K"),
  QUEEN_BLACK("Q"),
  ROOK_BLACK("R"),
  BISHOP_BLACK("B"),
  KNIGHT_BLACK("N"),
  PAWN_BLACK("P"),

  EMPTY(".");

  private final String symbol;

  Symbol(String symbol) {
    this.symbol = symbol;
  }

  public static String getSymbolForWhitePiece(Class<? extends Piece> pieceClass) {
    if (pieceClass == King.class) {
      return Symbol.KING_WHITE.getSymbol();
    }
    if (pieceClass == Queen.class) {
      return Symbol.QUEEN_WHITE.getSymbol();
    }
    if (pieceClass == Rook.class) {
      return Symbol.ROOK_WHITE.getSymbol();
    }
    if (pieceClass == Bishop.class) {
      return Symbol.BISHOP_WHITE.getSymbol();
    }
    if (pieceClass == Knight.class) {
      return Symbol.KNIGHT_WHITE.getSymbol();
    }
    if (pieceClass == Pawn.class) {
      return Symbol.PAWN_WHITE.getSymbol();
    }
    throw new IllegalArgumentException(ErrorMessage.MISMATCH_SYMBOL.getMessage());
  }

  public static String getSymbolForBlackPiece(Class<? extends Piece> pieceClass) {
    if (pieceClass == King.class) {
      return Symbol.KING_BLACK.getSymbol();
    }
    if (pieceClass == Queen.class) {
      return Symbol.QUEEN_BLACK.getSymbol();
    }
    if (pieceClass == Rook.class) {
      return Symbol.ROOK_BLACK.getSymbol();
    }
    if (pieceClass == Bishop.class) {
      return Symbol.BISHOP_BLACK.getSymbol();
    }
    if (pieceClass == Knight.class) {
      return Symbol.KNIGHT_BLACK.getSymbol();
    }
    if (pieceClass == Pawn.class) {
      return Symbol.PAWN_BLACK.getSymbol();
    }
    throw new IllegalArgumentException(ErrorMessage.MISMATCH_SYMBOL.getMessage());
  }

  public String getSymbol() {
    return symbol;
  }
}
