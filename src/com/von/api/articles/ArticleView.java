package com.von.api.articles;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class ArticleView {

    public static void main(Scanner sc) throws SQLException {
        ArticleController controller = new ArticleController();
        while(true){
            System.out.println("Menu: 0.Exit, 1.List");
            switch (sc.next()){
                case "0":
                    return;
                case "1":
                    controller.findAll().forEach(i-> System.out.println(i));
                    break;
            }

        }
    }
}