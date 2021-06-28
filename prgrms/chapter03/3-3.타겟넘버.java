class Solution {
    public int solution(int[] numbers, int target) {
        return solve(numbers, target, 0, 0);
    }

    private int solve(int[] numbers, int target, int index, int sum) {
        if (index == numbers.length) {
            return (sum == target) ? 1 : 0;
        }

        int count = 0;
        count += solve(numbers, target, index + 1, sum + numbers[index]);
        count += solve(numbers, target, index + 1, sum - numbers[index]);

        return count;
    }
}