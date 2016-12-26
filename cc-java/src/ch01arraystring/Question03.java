package ch01arraystring;

import java.util.Arrays;

/**
 * 1.3 문자열 두 개를 입력을 받아 그 중 하나가 다른 하나의 순열인지 판별하는 메서드를 작성하라.
 *
 * 1.4 Write a method to decide if two strings are anagrams or not.
 */
public class Question03 {
    // Anagram is a part of permutation.

    //--------------------------------------------------------------------------------
    // Solution #1: Sort the strings
    //--------------------------------------------------------------------------------
    public static String sort(String str) {
        char[] strArray = str.toCharArray();
        Arrays.sort(strArray);
        return new String(strArray);    // String.valueOf(strArray);
    }

    public static boolean permutation(String s, String t) {
        if (s.length() < 1 || s.length() != t.length())
            return false;

        return sort(s).equals(sort(t));
    }


    //--------------------------------------------------------------------------------
    // Solution #2: Check if the two strings have identical counts for each unique char.
    //--------------------------------------------------------------------------------
    public static boolean permutation02(String s, String t) {
        if (s.length() != t.length())
            return false;

        char[] charSet = new char[256]; // Extended ASCII
        int numOfUniqueChar = 0;
        int numOfCompletedChar = 0;

        for (int i = 0; i < s.length(); i++) {
            int value = s.charAt(i);

            if (charSet[value] == 0)
                numOfUniqueChar++;

            charSet[value]++;
        }

        for (int j = 0; j < t.length(); j++) {
            int value = t.charAt(j);

            if (--charSet[value] < 0)
                return false;

            if (charSet[value] == 0)
                numOfCompletedChar++;
        }

        if (numOfUniqueChar != numOfCompletedChar)
            return false;

//        for (int k = 0; k < 256; k++) {
//            if(charSet[k] > 0)
//                return false;
//        }

        return true;
    }


    public static void main(String[] args) {
        String[][] pairs = {{"apple", "papel"}, {"carrot", "tarroc"}, {"hello", "llloh"}};

        for (String[] pair : pairs) {
            String s = pair[0];
            String t = pair[1];

            System.out.println(s + " - " + t + " : "
                    + permutation(s, t) + ", "
                    + permutation02(s, t));
        }
    }
}
