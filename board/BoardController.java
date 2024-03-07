package board;

public class BoardController {
    BoardServiceImpl boardService;

    public BoardController() {
        this.boardService = BoardServiceImpl.getInstance();
    }
    public boolean boardName;

    public boolean boardType;
}
