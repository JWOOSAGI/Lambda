package com.von.api.enums;

import com.von.api.account.AccountView;
import com.von.api.articles.ArticleView;
import com.von.api.board.BoardView;
import com.von.api.crawler.CrawlerView;
import com.von.api.menu.MenuController;
import com.von.api.user.UserView;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Stream;

public enum NavigationOfFunction {
    Exit("x",i->"x"),
    User("u",i-> {
        try {
             UserView.main(i);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return "";
    }),
    Board("b",i->{
        System.out.println("Board Menu");
        BoardView.main(i);
        return "";
    }),
    Account("ac",i->  {
        System.out.println("Account Menu");
        AccountView.main(i);
        return "";
    }),
    Crawler("c",i-> {
        try {
            CrawlerView.main(i);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return "";
    }),
    Article("a",i-> {
        try {
            ArticleView.main(i);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return "";
    })
    ;
    private final String name;
    private final Function<Scanner, String> function;

    NavigationOfFunction(String name, Function<Scanner, String> function) {
        this.name = name;
        this.function = function;
    }

    public static String select(Scanner sc){

//        List<String> ls = MenuController.getInstance();

        System.out.println("\n === x-Exit " +
                "u-User " +
                "b-Board " +
                "ac-Account " +
                "c-Crawler " +
                "a-Articles" +
                "===");
        String selectMenu = sc.next();
        System.out.println("선택한 메뉴 : "+selectMenu);

        return Stream.of(values())
                .filter(i->i.name.equals(selectMenu))
                .findAny()
                .orElseGet(()->Exit)
                .function.apply(sc)
                ;

    }
}
