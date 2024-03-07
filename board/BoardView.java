package board;


import board.Board;
import common.UtilService;
import common.UtilServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BoardView {
    public static void main(Scanner sc) {
        BoardController boardController = new BoardController();
        while (true){
            System.out.println("[사용자메뉴] 0-종료" +
                    " 1-게시판 이름" +
                    " 2-게시판 타입");
            switch (sc.next()){
                case "0":
                    System.out.println("종료");
                    return;
                case "1":
                    System.out.println("1-게시판 이름");
                    String boardName = "";
                    System.out.println(boardController.boardName);
                    break;
                case "2":
                    System.out.println("2-게시판 타입");
                    System.out.println(boardController.boardType);
                    break;
            }

        }
    }
}