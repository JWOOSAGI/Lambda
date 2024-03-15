package com.von.api.strategy;

import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Stream;

public enum WeekendStrategy {
    Monday("1", i -> "Monday"),
    Tuesday("2", i -> "Monday"),
    Wednesday("3", i -> "Monday"),
    Thursday("4", i -> "Thursday"),
    Friday("5", i -> "Friday"),
    Saturday("6", i -> "Saturday"),
    Sunday("7", i -> "Sunday"),
    Wrong("x", i -> "Wrong");
    private final String name;
    private final Function<String, String> function;

    WeekendStrategy(String name, Function<String, String> function) {
        this.name = name;
        this.function = function;
    }


    public static String execute(Scanner sc) {
        System.out.println("1~7 입력: ");
        String s = sc.next();
        return Stream.of(values())
                .filter(i->i.name.equals(s))
                .findAny()
                .orElseGet(()-> Wrong)
                .function.apply(s)
                ;
    }
}
