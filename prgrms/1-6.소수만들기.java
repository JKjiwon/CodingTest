/**
 * 주어진 숫자 중 3개의 수를 더해 소수가 되는 경우의 수
 * 클래스 필드 변수 사용 안하기
 * 어떻게 뽑냐? 조합!!
 */
class Solution {
    public int solution(int[] nums) {
        return solve(0, 0, 0, nums);
    }

    private int solve(int index, int selectCount,int sum, int[] nums) {

        if (selectCount == 3) {
            if (isPrime(sum)) {
                return 1;
            }
            return 0;
        }

        if (index == nums.length) {
            return 0;
        }
        int countOfPrime = 0;
        countOfPrime += solve(index + 1, selectCount + 1, sum + nums[index], nums);
        countOfPrime += solve(index + 1, selectCount, sum, nums);
        return countOfPrime;
    }

    private boolean isPrime(int x) {
        if (x < 2)
            return false;
        int sqrtI = (int) Math.sqrt(x);
        for (int i = 2; i <= sqrtI; i++) {
            if (x % i == 0)
                return false;
        }
        return true;
    }
}