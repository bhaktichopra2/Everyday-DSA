// 67. Add Binary

// Given two binary strings a and b, return their sum as a binary string.

 public class Solution67 {

    public static String addBinary(String a, String b) {
        return Integer.toBinaryString(
            Integer.parseInt(a, 2) + Integer.parseInt(b, 2)
        );
    }

    public static void main(String[] args) {
        String a = "1010";
        String b = "1011";

        System.out.println(addBinary(a, b)); // Output: "10101"
    }
}