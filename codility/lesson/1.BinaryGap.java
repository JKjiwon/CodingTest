class Solution {
    public int solution(int N) {
        int countBinaryGap = 0;
        int maxBinaryGap = 0;
        boolean isCounting = false;

        while (N > 0) {
            int digit = N % 2;
            N = N / 2;

            if (digit == 1) {
                if (isCounting) {
                    maxBinaryGap = Math.max(countBinaryGap, maxBinaryGap);
                    countBinaryGap = 0;
                } else {
                    isCounting = true;
                }
            }

            if (digit == 0 && isCounting) {
                countBinaryGap++;
            }
        }
        return maxBinaryGap;
    }
}