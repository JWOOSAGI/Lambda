package com.von.api.enums;

import com.von.api.user.User;
import com.von.api.user.UserController;

import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Stream;

public enum UserRouter {
    Join("1", scanner -> {
        System.out.println("Join Start");
        return UserController.getInstance().save(scanner);
    }),
    Login("2", scanner -> {
        System.out.println("Login Start");
        return UserController.getInstance().login(scanner);
    }),
    IDsearch("3", scanner -> {
        System.out.println("IDsearch Start");
        return UserController.getInstance().findUsersByNameFromMap(scanner).toString();
    }),
//    PWchange("4", scanner -> {
//        System.out.println("PWchange Start");
//    }),
//    RemoveID("5", scanner -> {
//        System.out.println("RemoveID Start");
//    }),
//    ListOfMember("6", scanner -> {
//        System.out.println("ListOfMember Start");
//    }),
//    NameSearch("7", scanner -> {
//        System.out.println("NameSearch Start");
//    }),
//    JobSearch("8", scanner -> {
//        System.out.println("JobSearch Start");
//    }),
//    MemberCount("9", scanner -> {
//        System.out.println("MemberCount Start");
//    }),
//    CreateTable("10", scanner -> {
//        System.out.println("CreateTable Start");
//    }),
//    RemoveTable("11", scanner -> {
//        System.out.println("RemoveTable Start");
//    }),
    Exit("x", scanner-> "Exit")
   ;
    private final String name;
    private final Function<Scanner, String> function;

    UserRouter(String name, Function<Scanner, String> function) {
        this.name = name;
        this.function = function;
    }

    public static String execute(Scanner sc) {
        System.out.println("[사용자메뉴] 0-종료 |" +
                " 1-회원가입 |" +
                " 2-로그인 |" +
                " 3-ID검색 |" +
                " 4-비번변경 |" +
                " 5-탈퇴 |" +
                " ls-회원목록 |" +
                " 7-이름검색 |" +
                " 8-직업검색 |" +
                " 9-회원수 |" +
                " touch-테이블생성 |" +
                " rm-테이블삭제"
        );
        String menu = sc.next();
        return Stream.of(values())
                .filter(i->i.name.equals(menu))
                .findAny()
                .orElseGet(()->Exit)
                .function.apply(sc);
    }
}
