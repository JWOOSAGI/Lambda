package com.von.api;

import com.von.api.account.AccountView;
import com.von.api.board.BoardView;
import com.von.api.enums.*;
import com.von.api.menu.MenuController;
import com.von.api.user.UserView;
import com.von.api.crawler.CrawlerView;
import com.von.api.articles.ArticleView;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, SQLException {
        Messenger msg = MenuController.getInstance().returnMessenger();
        List<?> ls = MenuController.getInstance().returnList();



//        Scanner sc = new Scanner(System.in);
//        MenuController.getInstance().makeMenuTable();
//        String stringFlag2 = NavigationOfFunction.select(sc);
//        while (!stringFlag2.equals('X'));



//        NavigationOfConsumer.select(sc);

//        boolean booleanFlag = NavigationOfPredicate.select(sc);
//        while (booleanFlag);

//        String stringFlag = NavigationOfSupplier.select(sc);
//        while (stringFlag.equals("x"));
    }
}