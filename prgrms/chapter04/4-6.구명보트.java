/**
 * 구명보트는 작아서 한 번에 최대 2명씩 밖에 탈 수 없고,
 * 무게 제한도 있습니다.
 */

import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);

        int left = 0;
        int right = people.length - 1;

        while (left <= right) {
            answer++;
            if (people[left] + people[right] <= limit) {
                left++; // 보트에 가벼운사람 태우기
            }
            right--; // 보트에 무거운 사람 태우기
        }
        return answer;

    }
}