package ch01arraystring;

/**
 * 1.4 주어진 문자열 내의 모든 공백을 '%20' 으로 바꾸는 메서드를 작성하라.
 *     문자열 끝에 추가로 필요한 문자들을 더할 수 있는 충분한 공간이 있다고 가정하라.
 *     그리고 공백을 포함하는 문자열의 길이도 함께 주어진다고 가정하라.
 *     (주의 : 만일 Java 로 구현한다면, 문자 배열을 사용하여 필요한 연산을 각 문자에 바로 적용할 수 있도록 한다)
 *
 * 1.5 Write a method to replace all spaces in a string with ‘%20’.
 */
public class Question04 {
    public static void replaceSpaces(char[] str, int length) {
        int spaceCount = 0;
        for (char c : str) {
            if (c == ' ')
                spaceCount++;
        }

        int index = length + spaceCount * 2;

        for (int i = length - 1; i >= 0; i--) {
            if (str[i] == ' ') {
                str[--index] = '0';
                str[--index] = '2';
                str[--index] = '%';
            } else {
                str[--index] = str[i];
            }
        }
    }

    public static void main(String[] args) {
        String str = "abc d e f";
        char[] arr = new char[str.length() + 3 * 2];

//        for (int i = 0; i < str.length(); i++) {
//            arr[i] = str.charAt(i);
//        }
        System.arraycopy(str.toCharArray(), 0, arr, 0, str.length());

        replaceSpaces(arr, str.length());
        System.out.println(str + " -> " + String.valueOf(arr));
    }
}
