import java.util.ArrayList;

/**
 * List<Integer> to IntArray: list.stream().mapToInt(i -> i).toArray()
 */

class Solution {
    private final static int NUM_OF_STUDENTS = 3;

    public int[] solution(int[] answers) {

        Student[] students = new Student[NUM_OF_STUDENTS];
        int[] score = new int[NUM_OF_STUDENTS];

        students[0] = new Student(new int[] { 1, 2, 3, 4, 5 });
        students[1] = new Student(new int[] { 2, 1, 2, 3, 2, 4, 2, 5 });
        students[2] = new Student(new int[] { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 });

        for (int i = 0; i < NUM_OF_STUDENTS; i++) {
            score[i] = students[i].countOfAnswers(answers);
        }

        ArrayList<Integer> ret = new ArrayList<>();
        
        int maxScore = -1;
        for (int i = 0; i < NUM_OF_STUDENTS; i++) {
            maxScore = Math.max(maxScore, score[i]);
        }

        for (int i = 0; i < NUM_OF_STUDENTS; i++) {
            if (score[i] == maxScore)
                ret.add(i + 1);
        }
        
        return ret.stream().mapToInt(i -> i).toArray();
    }

    static class Student {
        private int[] studentAnswers;

        public Student(int[] studentAnswers) {
            this.studentAnswers = studentAnswers;
        }

        public int countOfAnswers(int[] answers) {
            int count = 0;
            int numOfstudentAnswers = studentAnswers.length;
            for (int i = 0; i < answers.length; i++) {
                if (answers[i] == studentAnswers[i % numOfstudentAnswers]) {
                    count += 1;
                }
            }
            return count;
        }
    }
}
