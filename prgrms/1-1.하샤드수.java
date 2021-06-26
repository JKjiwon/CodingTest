class Solution {
    public boolean solution(int x) {
        return check(x);
    }
    
    private boolean check(int x) {
        if (x % sum(x) == 0) {
            return true;
        }
        return false;
    }
    
    private int sum(int x) {
        int sum = 0;
        while (x != 0) {
            sum += x % 10;
            x /= 10;
        }
        return sum;
    }
}