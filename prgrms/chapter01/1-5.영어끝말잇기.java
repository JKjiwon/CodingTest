import java.util.HashSet;
import java.util.Set;

/**
 * hashSet.contains(String str): hashSet에 str이 포함되어 있나?
 * hashSet.add(String s): 추가 되면 true, 추가 안되면 false
 * => 포함을 확인하고, 추가해야한다면 contains, add 두번 쓰자. add만 쓰기에는 읽기에 햇갈릴 수 있다.
 * string.indexOf(char ch), indexOf(String str): 문자열에서 문자 또는 문자열의 index값 찾기.
 * string.charAt(int index): index번째 문자 찾기. return char;
 */
class Solution {
    public int[] solution(int n, String[] words) {

        Set<String> used = new HashSet<>();
        int person = 0;
        int order = 0;
        String currWord = words[0];
        used.add(words[0]);

        for (int i = 1; i < words.length; i++) {
            if (used.contains(words[i]) || notNextWord(currWord, words[i])) {
                person = (i % n) + 1;
                order = i / n + 1;
                break;
            }
            used.add(words[i]);
            currWord = words[i];
        }
        return new int[]{person, order};
    }

    private boolean notNextWord(String cur, String next) {
        if (cur.charAt(cur.length() - 1) != next.charAt(0)) {
            return true;
        }
        return false;
    }
}