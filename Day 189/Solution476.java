// 476. Number Complement

// The complement of an integer is the integer you get when you flip all the 0's to 1's and all the 1's to 0's in its binary representation.

// For example, The integer 5 is "101" in binary and its complement is "010" which is the integer 2.
// Given an integer num, return its complement.

public class Solution476 {

    public static int findComplement(int num) {
        return num ^ ((1 << Integer.toBinaryString(num).length()) - 1);
    }

    public static void main(String[] args) {
        int num = 5;
        System.out.println(findComplement(num));
    }
}