package board;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@Getter
@ToString

public class Board {
    private int id;
    private String title;
    private String content;
    private String writer;

  @Builder (builderMethodName = "builder")
  public Board(int id, String title, String content, String writer) {

  }
}
