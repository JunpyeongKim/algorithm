package ch01arraystring;

/**
 * 1.5 같은 문자가 연속으로 반복될 경우, 그 횟수를 사용해 문자열을 압축하는 메서드를 구현하라.
 *     가령 압축해야 할 문자열이 aabccccccccaaa 라면 a2b1c8a3 과 같이 압축되어야 한다
 *     압축 결과로 만들어지는 문자열이 원래 문자열보다 짧아지지 않는 경우, 이 메서드는 원래 문자열 그대로 반환해야 한다.
 */
public class Question05 {
    //--------------------------------------------------------------------------------
    // Solution #1
    //--------------------------------------------------------------------------------
    public static String compressBad(String str) {
//        int size = countCompression(str);
//        if (str == null || size >= str.length())
//            return str;

        String compressed = "";
        char last = str.charAt(0);
        int count = 1;

        for (int i = 1; i < str.length(); i++) {
            if (last == str.charAt(i)) {
                count++;
            } else {
                compressed += last + String.valueOf(count); // last + "" + count;
                last = str.charAt(i);
                count = 1;
            }
        }

        compressed += last + String.valueOf(count); // last + "" + count;

        return compressed;
    }


    //--------------------------------------------------------------------------------
    // Solution #2
    //--------------------------------------------------------------------------------
    private static int countCompression(String str) {
        if (str == null || str.isEmpty())
            return 0;

        int size = 0;

        char last = str.charAt(0);
        int count = 1;

        for (int i = 1; i < str.length(); i++) {
            if (last == str.charAt(i)) {
                count++;
            } else {
                size += 1 + String.valueOf(count).length();
                last = str.charAt(i);
                count = 1;
            }
        }

        size += 1 + String.valueOf(count).length();

        return size;
    }

    public static String compressBetter(String str) {
        int size = countCompression(str);
        if (str == null || size >= str.length())
            return str;

        StringBuffer compressed = new StringBuffer();
        char last = str.charAt(0);
        int count = 1;

        for (int i = 1; i < str.length(); i++) {
            if (last == str.charAt(i)) {
                count++;
            } else {
                compressed.append(last);
                compressed.append(count);

                last = str.charAt(i);
                count = 1;
            }
        }

        compressed.append(last);
        compressed.append(count);
        return compressed.toString();
    }


    //--------------------------------------------------------------------------------
    // Solution #3
    //--------------------------------------------------------------------------------
    private static int setChar(char[] array, char c, int index, int count) {
        array[index++] = c;

//        char[] countArray = String.valueOf(count).toCharArray();
        char[] countArray = Integer.toString(count).toCharArray();

        for (char ch : countArray) {
            array[index++] = c;
        }

        return index;
    }

    public static String compressAlternative(String str) {
        int size = countCompression(str);
        if (str == null || size >= str.length())
            return str;

        char[] array = new char[size];
        int index = 0;
        char last = str.charAt(0);
        int count = 1;

        for (int i = 1; i < str.length(); i++) {
            if (last == str.charAt(i)) {
                count++;
            } else {
                index = setChar(array, last, index, count);
                last = str.charAt(i);
                count = 1;
            }
        }

        index = setChar(array, last, index, count);

        return String.valueOf(array);   // new String(array)
    }

    public static void main(String[] args) {
        String[] strs = {"aa", "aabccccccccaaa"};

        for (String str : strs) {
            System.out.println(str + " : "
                    + compressBad(str) + ", "
                    + compressBetter(str) + ", "
                    + compressAlternative(str));
        }
    }
}