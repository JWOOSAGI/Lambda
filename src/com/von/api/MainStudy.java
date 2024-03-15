package com.von.api;

import com.von.api.account.AccountView;
import com.von.api.board.BoardView;
import com.von.api.enums.NavigationOfConsumer;
import com.von.api.enums.NavigationOfFunction;
import com.von.api.enums.NavigationOfPredicate;
import com.von.api.enums.NavigationOfSupplier;
import com.von.api.user.UserView;
import com.von.api.crawler.CrawlerView;
import com.von.api.articles.ArticleView;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class MainStudy {
    public static void main(String[] args) throws IOException, SQLException {
        Scanner sc = new Scanner(System.in);
//        NavigationOfConsumer.select(sc);

//        boolean booleanFlag = NavigationOfPredicate.select(sc);
//        while (booleanFlag);

//        String stringFlag = NavigationOfSupplier.select(sc);
//        while (stringFlag.equals("x"));

        String stringFlag2 = NavigationOfFunction.select(sc);
        while (!stringFlag2.equals('X'));


//        while (true){
//            System.out.println("= Select Model =");
//            switch (sc.next()){
//                case "exit":  return;
//                case "user": UserView.main(sc);break;
//                case "board": BoardView.main(sc); break;
//                case "account": AccountView.main(sc); break;
//                case "crawler": CrawlerView.main(sc);  break;
//                case "article": ArticleView.main(sc);  break;
//            }
//        }

    }
}