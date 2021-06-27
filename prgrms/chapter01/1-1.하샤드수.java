class Solution {
    public boolean solution(int x) {
        return x % sumOfDigit(x) == 0;
    }
    
    private int sumOfDigit(int x) {
        int sum = 0;
        while (x > 0) {
            sum += x % 10;
            x /= 10;
        }
        return sum;
    }
}