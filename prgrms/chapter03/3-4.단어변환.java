
/**
 * 최대값을 나타내는 수: 대략 10억 -> (int) 1e9;
 */
class Solution {

    private static final int INVALID_COUNT = (int) 1e9;

    public int solution(String begin, String target, String[] words) {
        int wordLen = words.length;
        boolean[] used = new boolean[wordLen];
        int answer = solve(begin, 0, used, target, words, wordLen);
        return answer == INVALID_COUNT ? 0 : answer;
    }

    private int solve(String word, int count, boolean[] used, String target, String[] words, int wordLen) {
        if (word.equals(target)) {
            return count;
        }

        int minValue = INVALID_COUNT;
        for (int i = 0; i < wordLen; i++) {
            if (!used[i] && isNext(word, words[i])) {
                used[i] = true;
                minValue = Math.min(minValue, solve(words[i], count + 1, used, target, words, wordLen));
                used[i] = false;
            }
        }
        return minValue;
    }
    
    private boolean isNext(String word, String nextWord) {
        int count = 0;
        for (int i = 0; i < word.length() && count < 2; i++) {
            if (word.charAt(i) != nextWord.charAt(i)) {
                count++;
            }
        }
        return count == 1;
    }
}