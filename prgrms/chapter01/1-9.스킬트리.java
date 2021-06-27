/** 
 * 스킬이 순서대로 배워져야한다.
 * 스킬 트리에 선행 스킬 요소가 하나도 없으면, 그래도 배울수 있다.
 * 약간 까다로운 문제다.!
 */


class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        for (String skill_tree : skill_trees) {
            int skillNum = 0;
            boolean check = true;

            for (char ch : skill_tree.toCharArray()) {
                if (skill.indexOf(ch) != -1) { // 스킬 트리에 선행 스킬 트리 요소가 있다면
                    if (skill.indexOf(ch) == skillNum) { // 스킬 트리의 스킬 순서와 선행 스킬 트리의 스킬 순서가 같다면
                        skillNum++;
                        continue;
                    }
                    check = false; // 스킬 트리의 스킬 순서와 선행 스킬 트리의 스킬 순서가 다르면
                    break;
                }
            }
            if (check) answer++;
        }
        return answer;
    }
}