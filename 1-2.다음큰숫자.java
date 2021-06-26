/**
 * 2진수 1의자리 수를 구하는 방식
 * mod 연산자: x % 2
 * 비트 연산자: x & 1
 */
class Solution {
    public int solution(int n) {
        int nCountOf1s = countOf1s(n);
        for (int i = n + 1; i <= 1_000_000; i++) {
            if (nCountOf1s == countOf1s(i))
                return i;
        }
        return -1;
    }

    private int countOf1s(int x) {
        int sum = 0;
        while (x > 0) {
            sum += x & 1;
            x >>= 1;
        }
        return sum;
    }
}
