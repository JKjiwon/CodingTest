/**
 * '('문자로 열렸으면 반드시 ')'로 닫혀야 한다.
 * stack을 단순 int형으로 정의 하겠다.
 * '(': +1 , ')': -1
 * '(' 이 있어야 ')'이 나올 수있다. 즉  stack 값이 음수이면 안된다.
 */

class Solution {
    boolean solution(String s) {
        int stack = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '(') stack++;
            else stack--;
            if (stack < 0) return false;
        }

        if (stack == 0) return true;
        return false;
    }
}