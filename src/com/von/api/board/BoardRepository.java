package com.von.api.board;

public class BoardRepository {
    private static BoardRepository instance = new BoardRepository();
    private BoardRepository(){};
    public static BoardRepository getInstance(){return instance;}
}
