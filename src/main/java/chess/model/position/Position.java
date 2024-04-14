package chess.model.position;

public class Position {

  private final File file;
  private final Rank rank;

  public Position(final int file, final int rank) {
    this.file = File.from(file);
    this.rank = Rank.from(rank);
  }

  public File getFile() {
    return file;
  }

  public Rank getRank() {
    return rank;
  }
}
