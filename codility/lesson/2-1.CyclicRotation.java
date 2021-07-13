class Solution {
    public int[] solution(int[] A, int K) {
        int lenA = A.length;
        if (lenA == 0) {
            return A;
        }
        
        for (int i = 0; i < K; i++) {
            int temp = A[lenA - 1];
            for (int j = lenA - 1; j > 0; j--) {
                A[j] = A[j - 1];
            }
            A[0] = temp;
        }
        return A;
    }
}