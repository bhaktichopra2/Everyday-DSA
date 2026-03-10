// 441. Arranging Coins

// You have n coins and you want to build a staircase with these coins. The staircase consists of k rows where the ith row has exactly i coins. The last row of the staircase may be incomplete.

// Given the integer n, return the number of complete rows of the staircase you will build.

public class Solution441 {

    public static int arrangeCoins(int n) {
        int row = 1;

        while (n >= row) {
            n -= row;
            row++;
        }

        return row - 1;
    }

    public static void main(String[] args) {

        int n = 8;

        int result = arrangeCoins(n);

        System.out.println("Complete rows: " + result);
    }
}