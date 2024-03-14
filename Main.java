package com.von.api;

import com.von.api.account.AccountView;
import com.von.api.articles.ArticleView;
import com.von.api.board.BoardView;
import com.von.api.crawler.CrawlerView;
import com.von.api.user.UserView;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

enum MainDoor {
    EXIT("x", input -> {
        return;
    }),
    USER("u", sc -> {
        try {
            UserView.main(sc);
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
    }),
    BOARD("b", sc -> BoardView.main(sc)),
    ACCOUNT("ac", sc -> AccountView.main(sc)),
    ARTICLE("a", sc -> {
        try {
            ArticleView.main(sc);
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
    }),
    CRAWLER("c", sc -> {
        try {
            CrawlerView.main(sc);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }),
    ;
    private final String key;
    private final Consumer<Scanner> consumer;

    MainDoor(String key, Consumer<Scanner> consumer) {
        this.key = key;
        this.consumer = consumer;
    }

    static void getPage(Scanner sc) {
        getP(sc.next()).consumer.accept(sc);
    }

    private static MainDoor getP(String sc) {
        return Arrays.stream(values()).filter(o -> o.key.equals(sc))
                .findFirst().orElseThrow(() -> new IllegalArgumentException("올바른 값이 아닙니다."));
    }

}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("x-EXIT u-USER b-BOARD ac-ACCOUT a-ARTCLE c-CRAWLER");
        MainDoor.getPage(sc);
    }
}