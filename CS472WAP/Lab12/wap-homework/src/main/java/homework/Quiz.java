package homework;

public class Quiz {
        private static String[] questions = { "3, 1, 4, 1, 5", // pi
                        "1, 1, 2, 3, 5", // fibonacci
                        "1, 4, 9, 16, 25", // squares
                        "2, 3, 5, 7, 11", // primes
                        "1, 2, 4, 8, 16" // powers of 2
        };
        private static int[] answers = { 9, 8, 36, 13, 32 };
        private int score = 0;
        private boolean[] isShowed = { false, false, false, false, false };

        private int getNextQuestionIndex() {
                int index = -1;
                while (true) {
                        index = Integer.parseInt(Math.random() * questions.length);
                        if (isShowed[index] == false) {
                                isShowed[index] = true;
                                return index;
                        } else {
                                boolean show = true;
                                for (boolean x : isShowed) {
                                        if (x == false) {
                                                continue;
                                        }
                                }
                                if (show == true) {
                                        break;
                                }
                        }
                }
                return index;
        }

        private int setScore() {
                this.score++;
        }

        private int setIsShowed(int index) {
                this.isShowed[index] = true;
        }
}