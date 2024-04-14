package chess.model.board;

import chess.model.piece.Piece;
import chess.model.piece.pieces.Bishop;
import chess.model.piece.pieces.King;
import chess.model.piece.pieces.Knight;
import chess.model.piece.pieces.Pawn;
import chess.model.piece.pieces.Queen;
import chess.model.piece.pieces.Rook;
import chess.model.position.Color;
import chess.model.position.Position;
import chess.model.position.InitialPosition;
import java.util.HashMap;
import java.util.Map;

public class InitialBoard {

  public Board createInitialBoard() {
    Map<Position, Piece> board = new HashMap<>();

    board.putAll(createPawn());
    board.putAll(createKing());
    board.putAll(createQueen());
    board.putAll(createBishop());
    board.putAll(createRook());
    board.putAll(createKnight());

    return new Board(board);
  }

  private Map<Position, Piece> createPawn() {
    Map<Position, Piece> pieceMap = new HashMap<>();
    for (InitialPosition position : InitialPosition.values()) {
      if (position.name().startsWith("WHITE_PAWN")) {
        pieceMap.put(position.getPosition(), new Pawn(Color.WHITE));
      }
      if (position.name().startsWith("BLACK_PAWN")) {
        pieceMap.put(position.getPosition(), new Pawn(Color.BLACK));
      }
    }
    return pieceMap;
  }

  private Map<Position, Piece> createKing() {
    Map<Position, Piece> pieceMap = new HashMap<>();
    pieceMap.put(InitialPosition.WHITE_KING.getPosition(), new King(Color.WHITE));
    pieceMap.put(InitialPosition.BLACK_KING.getPosition(), new King(Color.BLACK));
    return pieceMap;
  }

  private Map<Position, Piece> createQueen() {
    Map<Position, Piece> pieceMap = new HashMap<>();
    pieceMap.put(InitialPosition.WHITE_QUEEN.getPosition(), new Queen(Color.WHITE));
    pieceMap.put(InitialPosition.BLACK_QUEEN.getPosition(), new Queen(Color.BLACK));
    return pieceMap;
  }

  private Map<Position, Piece> createBishop() {
    Map<Position, Piece> pieceMap = new HashMap<>();
    pieceMap.put(InitialPosition.WHITE_BISHOP_LEFT.getPosition(), new Bishop(Color.WHITE));
    pieceMap.put(InitialPosition.WHITE_BISHOP_RIGHT.getPosition(), new Bishop(Color.WHITE));
    pieceMap.put(InitialPosition.BLACK_BISHOP_LEFT.getPosition(), new Bishop(Color.BLACK));
    pieceMap.put(InitialPosition.BLACK_BISHOP_RIGHT.getPosition(), new Bishop(Color.BLACK));
    return pieceMap;
  }

  private Map<Position, Piece> createKnight() {
    Map<Position, Piece> pieceMap = new HashMap<>();
    pieceMap.put(InitialPosition.WHITE_KNIGHT_LEFT.getPosition(), new Knight(Color.WHITE));
    pieceMap.put(InitialPosition.WHITE_KNIGHT_RIGHT.getPosition(), new Knight(Color.WHITE));
    pieceMap.put(InitialPosition.BLACK_KNIGHT_LEFT.getPosition(), new Knight(Color.BLACK));
    pieceMap.put(InitialPosition.BLACK_KNIGHT_RIGHT.getPosition(), new Knight(Color.BLACK));
    return pieceMap;
  }

  private Map<Position, Piece> createRook() {
    Map<Position, Piece> pieceMap = new HashMap<>();
    pieceMap.put(InitialPosition.WHITE_ROOK_LEFT.getPosition(), new Rook(Color.WHITE));
    pieceMap.put(InitialPosition.WHITE_ROOK_RIGHT.getPosition(), new Rook(Color.WHITE));
    pieceMap.put(InitialPosition.BLACK_ROOK_LEFT.getPosition(), new Rook(Color.BLACK));
    pieceMap.put(InitialPosition.BLACK_ROOK_RIGHT.getPosition(), new Rook(Color.BLACK));
    return pieceMap;
  }
}
