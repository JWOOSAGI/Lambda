package com.von.api.enums;

import java.util.Scanner;
import java.util.function.Predicate;

public class NavigationOfPredicate {
    private final String name;
    private final Predicate<String> predicate;

    public NavigationOfPredicate(String name, Predicate<String> predicate) {
        this.name = name;
        this.predicate = predicate;
    }

    public static boolean select(Scanner sc) {
        return false;
    }
}
