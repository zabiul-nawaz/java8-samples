package com.dups;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DuplicateCharCheck {

    public static void main(String[] args) {
        String s = "AAbCCdEFF";
        System.out.println("Way 1 =====>");
        printDuplicates(s);
        System.out.println("Way 2 =====>");
        displayDuplicates(s);
    }

    private static void printDuplicates(String s) {
        IntStream stream = s.chars();
        Set<Integer> set = new HashSet<>();
        stream.filter(i -> !set.add(i)).forEach(x -> System.out.println((char)x));
    }

    private static void displayDuplicates(String s) {

        s.chars()
        .boxed()
        .collect( Collectors.groupingBy( Function.identity(), Collectors.counting())).forEach((k,v) -> {
            for(long i = v; i > 1; i--) {
                System.out.println((char)k.intValue());
            }
        }); ;

    }

}

