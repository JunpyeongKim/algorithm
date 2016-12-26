package ch01arraystring;

import java.util.Arrays;

/**
 * 1.1 문자열에 포함된 문자들이 전부 유일한지를 검사하는 알고리즘을 구현하라.
 *     다른 자료구조를 사용할 수 없는 상황이라면 어떻게 하겠는가?
 *
 * 1.1 Implement an algorithm to determine if a string has all unique characters.
 *     What if you can not use additional data structures?
 */
public class Question01 {
    //--------------------------------------------------------------------------------
    // Solution #1 Extended ASCII
    //  - Character set: ASCII or Unicode ?
    //      - ASCII(128: 0 ~ 127)
    //      - Extended ASCII(128: 128 ~ 255)
    //      - Unicode: //TODO:
    //--------------------------------------------------------------------------------
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public static boolean isUniqueChars(String str) {
        if (str.length() > 256)
            return false;

        boolean[] charSet = new boolean[256];

        for (int i = 0; i < str.length(); i++) {
            int value = str.charAt(i);

            if (charSet[value])
                return false;

            charSet[value] = true;
        }

        return true;
    }


    //--------------------------------------------------------------------------------
    // Solution #2 ASCII & lowercase 'a' through 'z'
    //--------------------------------------------------------------------------------
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public static boolean isUniqueChars2(String str) {
        if (str.length() > 26)
            return false;

        // a bit vector,
        int checker = 0;

        for (int i = 0; i < str.length(); i++) {
            int shift = str.charAt(i) - 'a';    // normalize
            int value = 1 << shift;

            if ((checker & value) > 0)
                return false;

            checker |= value;
        }

        return true;
    }


    //--------------------------------------------------------------------------------
    // Solution #3 Check every character with every other character for duplicate occurrences
    //--------------------------------------------------------------------------------
    // Time Complexity: O(n^2)
    // Space Complexity: O(1), no space
    public static boolean isUniqueChars3(String str) {
        if (str.length() > 256)
            return false;

        int len = str.length();

        for (int i = 0; i < len - 1; i++) {
            char c = str.charAt(i);

            for (int j = i + 1; j < len; j++) {
                if (c == str.charAt(j))
                    return false;
            }
        }

        return true;
    }


    //--------------------------------------------------------------------------------
    // Solution #4 sort in O(nlogn) time and then check for neighboring characters that are identical.
    //--------------------------------------------------------------------------------
    public static boolean isUniqueChars4(String str) {
        if (str.length() > 256)
            return false;

        char[] strArray = str.toCharArray();
        Arrays.sort(strArray);  // Though many sorting algorithms take up extra space.

        for (int i = 0; i < strArray.length - 1; i++) {
            if (strArray[i] == strArray[i+1])
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        String[] words = {"abcde", "hello", "apple", "kite", "padle"};

        for (String word : words) {
            System.out.println(word + " : "
                    + isUniqueChars(word) + ", "
                    + isUniqueChars2(word) + ", "
                    + isUniqueChars3(word) + ", "
                    + isUniqueChars4(word));
        }
    }
}
