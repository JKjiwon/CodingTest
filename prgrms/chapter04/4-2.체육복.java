/**
 * 체육복이 없는 사람을 기준으로 생각하자.
 */
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] students = new int[n + 2];

        for (int i = 1; i <= n; i++) students[i] += 1;
        for (int i : reserve) students[i] += 1;
        for (int i : lost) students[i] -= 1;

        for (int i = 1; i <= n; i++) {
            // 잃어버리지 않은 사람
            if (students[i] >= 1)
                continue;
            if (students[i - 1] > 1) {
                // 잃어버렷는데 앞 사람에게 여분이 있는 경우
                students[i - 1] -= 1;
                students[i] += 1;
            } else if (students[i + 1] > 1) {
                // 잃어버렷는데 뒷 사람에게 여분이 있는 경우
                students[i + 1] -= 1;
                students[i] += 1;
            }
        }

        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if (students[i] >= 1)
                answer++;
        }
        return answer;
    }
}