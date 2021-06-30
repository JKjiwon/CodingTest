class Solution {

    private static int MOD = 1_000_000_007;
    private static int N = 60000;

    public int solution(int n) {
        int[] d = new int[N+1];

        d[0] = 1;
        d[1] = 1;
        d[2] = 2;
        
        for (int i = 3; i <= n; i++) {
            d[i] = d[i - 1] + d[i - 2];
            d[i] %= MOD;
        }
        return d[n];
    }
}