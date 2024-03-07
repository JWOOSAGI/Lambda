package board;

import crawler.CrawlerRepository;
import user.User;
import user.UserRepository;

import java.util.HashMap;
import java.util.Map;

public class BoardRepository {
    private static BoardRepository instance = new BoardRepository();
    private BoardRepository(){};
    public static BoardRepository getInstance(){return instance;}
}
