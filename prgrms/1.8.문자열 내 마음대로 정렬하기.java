import java.util.Arrays;

/**
 * 정렬기준
 * 외부 정렬인 Comparator 인터페이스를 구현한다.
 * 오름차순(사전순)으로 정렬하고 싶다.
 * 정수 num1, num2 이 주어 졌을때 : return num1 - num2;
 * 문자열 str1, str2,이 주어졌을때 : return str1.compareTo(str2);
 */

class Solution {
    public String[] solution(String[] strings, int n) {
        Arrays.sort(strings, (str1, str2) -> {
            if (str1.charAt(n) == str2.charAt(n)) {
                return str1.compareTo(str2);
            }
            return str1.charAt(n) - str2.charAt(n);
        });
        return strings;
    }
}