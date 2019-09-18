package homework;

public class Quiz {
    public static final String[] questions = {"3, 1, 4, 1, 5", // pi
            "1, 1, 2, 3, 5", // fibonacci
            "1, 4, 9, 16, 25", // squares
            "2, 3, 5, 7, 11", // primes
            "1, 2, 4, 8, 16" // powers of 2
    };
    public static final int[] answers = {9, 8, 36, 13, 32};
    private int score = 0;
    private boolean[] isShowed = {false, false, false, false, false};

    public int getNextQuestionIndex() {
        int index = -1;
        while (true) {
            index = (int) (Math.random() * questions.length);
            if (isShowed[index] == false) {
                isShowed[index] = true;
                return index;
            } else {
                boolean show = true;
                for (boolean x : isShowed) {
                    if (x == false) {
                        show = false;
                        break;
                    }
                }
                if (show == true) {
                    break;
                }
            }
        }
        return -1;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public boolean[] getIsShowed() {
        return isShowed;
    }

    public void setIsShowed(boolean[] isShowed) {
        this.isShowed = isShowed;
    }

    public int getScore() {
        return this.score;
    }

    public int addScore() {
        this.score++;
        return this.score;
    }

    public void setIsShowed(int index) {
        this.isShowed[index] = true;
    }
}