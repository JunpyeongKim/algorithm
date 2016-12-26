package ch01arraystring;

/**
 * 1.8 한 단어가 다른 단어에 포함된 문자열인지 판별하는 isSubString 이라는 메서드가 있다고 하자.
 *     s1과 s2의 두 문자열이 주어졌을 때, s2가 s1을 회전시킨 결과인지 판별하는 코드를 isSubString 을 한번만 호출하도록 하여 작성하라.
 *     (가령 'waterbottle'은 'erbottlewat'을 회전하여 얻을 수 있는 문자열이다.)
 *
 * 1.8 Assume you have a method isSubstring which checks if one word is a substring of another.
 *     Given two strings, s1 and s2,
 *     write code to check if s2 is a rotation of s1 using only one call to isSubstring
 *     (i.e., “waterbottle” is a rotation of “erbottlewat”).
 */
public class Question08 {
    public static boolean isSubString(String big, String small) {
        if (big.indexOf(small) >= 0)    // if (big.contains(small))
            return true;

        return false;
    }

    public static boolean isRotation(String s1, String s2) {
        int len = s1.length();

        if (len == s2.length() && len > 0) {
            String s1s1 = s1 + s1;
            return isSubString(s1s1, s2);
        }

        return false;
    }

    public static void main(String[] args) {
        String[][] pairs = {{"apple", "pleap"}, {"waterbottle", "erbottlewat"}, {"camera", "macera"}};

        for (String[] pair : pairs) {
            String s1 = pair[0];
            String s2 = pair[1];
            boolean isRotation = isRotation(s1, s2);
            System.out.println(s1 + ", " + s2 + " : " + isRotation);
        }
    }
}
