package com.dups;

public class AnagramsCheck {

    public static void main(String[] args) {
        String s1 = "palm";
        String s2 = "lamp";

        System.out.println(checkAnagrams(s1,s2));
    }

    private static boolean checkAnagrams(String s1, String s2) {
        return !(s1.chars().filter(i
                -> (s2.replaceFirst(String.valueOf((char)i), "").length() == s2.length())).count() > 0);
    }

}
