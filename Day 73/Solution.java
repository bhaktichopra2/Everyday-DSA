// 374. Guess Number Higher or Lower
// We are playing the Guess Game. The game is as follows:

// I pick a number from 1 to n. You have to guess which number I picked (the number I picked stays the same throughout the game).

// Every time you guess wrong, I will tell you whether the number I picked is higher or lower than your guess.

// You call a pre-defined API int guess(int num), which returns three possible results:

// -1: Your guess is higher than the number I picked (i.e. num > pick).
// 1: Your guess is lower than the number I picked (i.e. num < pick).
// 0: your guess is equal to the number I picked (i.e. num == pick).
// Return the number that I picked.


class GuessGame {
    private int pick; // the number to guess

    public GuessGame(int pick) {
        this.pick = pick;
    }

    // API: returns -1 if num is higher, 1 if num is lower, 0 if correct
    public int guess(int num) {
        if (num > pick) return -1;
        if (num < pick) return 1;
        return 0;
    }
}

public class Solution extends GuessGame {

    public Solution(int pick) {
        super(pick);
    }

    public int guessNumber(int n) {
        int start = 1;
        int end = n;

        while (start <= end) {
            int mid = start + (end - start) / 2; // avoid overflow
            int res = guess(mid);
            if (res == 0) {
                return mid;
            } else if (res == 1) {      // mid is lower than pick
                start = mid + 1;
            } else {                    // res == -1, mid is higher than pick
                end = mid - 1;
            }
        }
        return -1; // should not reach here if pick is in [1, n]
    }

    public static void main(String[] args) {
        int n = 100;
        int pick = 73;
        Solution sol = new Solution(pick);
        System.out.println(sol.guessNumber(n)); // prints 73
    }
}
