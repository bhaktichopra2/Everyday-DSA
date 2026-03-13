// 263. Ugly Number

// An ugly number is a positive integer which does not have a prime factor other than 2, 3, and 5.

// Given an integer n, return true if n is an ugly number.

public class Solution263 {

    public static boolean isUgly(int n) {

        if (n <= 0) return false;

        int[] factors = {2,3,5};

        for(int f : factors){
            while(n % f == 0){
                n /= f;
            }
        }

        return n == 1;
    }

    public static void main(String[] args) {

        int n = 8;
        System.out.println(isUgly(n));

    }
}