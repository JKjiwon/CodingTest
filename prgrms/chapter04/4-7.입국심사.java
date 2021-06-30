import java.util.*;

// 최대 최소 => 힙
// long end = long * int 에서 long * int를 곱하면 int가 나오므로 주의해야 한다.!!!
// int를 long으로 캐스팅하자.

class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        long start = 1;
        long end = n * (long) times[times.length-1];
        
        return binarySearch(times, n, start, end);
    }
    
    private long binarySearch(int[] times, int n, long start, long end){
        long answer = Long.MAX_VALUE;
        long mid = 0;
        
        while (start <= end) {
            mid = (start + end) / 2;

            if (isPossible(times, n, mid)) {
                answer = Math.min(answer, mid);
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return answer;
    }
    
    private boolean isPossible(int[] times, int n, long mid) {
        long amount = 0;
        
        for (int i = 0 ; i < times.length; i++) {
            amount += mid / times[i];
        }
        
        return amount >= n;
    }
}