package board;

import crawler.CrawlerServiceImpl;

public class BoardServiceImpl implements BoardService {
    private static BoardServiceImpl instance = new BoardServiceImpl();
    private BoardRepository repository;
    private BoardServiceImpl(){
        repository = BoardRepository.getInstance();
    }
    public static BoardServiceImpl getInstance(){return instance;}
}
