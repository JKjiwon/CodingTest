class Solution {
    public int solution(String s) {
        int answer = s.length();

        for (int unit = 1; unit < s.length() / 2 + 1; unit++) {
            String prev = s.substring(0, unit);
            String compressed = "";
            int count = 1;

            for (int i = unit; i < s.length(); i += unit) {
                String sub = "";

                for (int j = i; j < i + unit; j++) {
                    if (j < s.length()) sub += s.charAt(j);
                }

                if (prev.equals(sub)) count++;
                else {
                    compressed += (count >= 2) ? count + prev : prev;
                    prev = sub;
                    count = 1;
                }
            }
            compressed += (count >= 2) ? count + prev : prev;
            answer = Math.min((answer), compressed.length());)
        }
        return answer;
    }
}
