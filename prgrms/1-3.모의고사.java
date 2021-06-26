import java.util.ArrayList;

/**
 * List<Integer> to IntArray: list.stream().mapToInt(i -> i).toArray()
 */

class Solution {
    private final static int NUM_OF_STUDENTS = 3;

    public int[] solution(int[] answers) {
        Student[] students = new Student[NUM_OF_STUDENTS];
        students[0] = new Student(1, new int[] { 1, 2, 3, 4, 5 });
        students[1] = new Student(2, new int[] { 2, 1, 2, 3, 2, 4, 2, 5 });
        students[2] = new Student(3, new int[] { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 });

        for (int i = 0; i < NUM_OF_STUDENTS; i++) {
            students[i].calculateScore(answers);
        }

        ArrayList<Integer> maxScoreStudents = new ArrayList<>();
        
        int maxScore = -1;
        for (int i = 0; i < NUM_OF_STUDENTS; i++) {
            maxScore = Math.max(maxScore, students[i].getScore());
        }

        for (int i = 0; i < NUM_OF_STUDENTS; i++) {
            if (maxScore == students[i].getScore())
                maxScoreStudents.add(students[i].getId());
        }
        
        return maxScoreStudents.stream().mapToInt(i -> i).toArray();
    }

    static class Student {
        private int id;
        private int[] studentAnswers;
        private int score;

        public Student(int id, int[] studentAnswers) {
            this.id = id;
            this.studentAnswers = studentAnswers;
        }

        public int getId() {
            return id;
        }

        public int getScore() {
            return score;
        }

        public void calculateScore(int[] rightAnswers) {
            for (int i = 0; i < rightAnswers.length; i++) {
                if (rightAnswers[i] == studentAnswers[i % studentAnswers.length]) {
                    this.score += 1;
                }
            }
        }
    }
}
