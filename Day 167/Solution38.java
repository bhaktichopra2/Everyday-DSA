// 38. Count and Say

// The count-and-say sequence is a sequence of digit strings defined by the recursive formula:

// countAndSay(1) = "1"
// countAndSay(n) is the run-length encoding of countAndSay(n - 1).
// Run-length encoding (RLE) is a string compression method that works by replacing consecutive identical characters (repeated 2 or more times) with the concatenation of the character and the number marking the count of the characters (length of the run). For example, to compress the string "3322251" we replace "33" with "23", replace "222" with "32", replace "5" with "15" and replace "1" with "11". Thus the compressed string becomes "23321511".

// Given a positive integer n, return the nth element of the count-and-say sequence.

public class Solution38 {

    public static String countAndSay(int n) {

        String result = "1";

        for (int i = 1; i < n; i++) {
            StringBuilder current = new StringBuilder();
            int count = 1;

            for (int j = 1; j < result.length(); j++) {
                if (result.charAt(j) == result.charAt(j - 1)) {
                    count++;
                } else {
                    current.append(count).append(result.charAt(j - 1));
                    count = 1;
                }
            }

            current.append(count).append(result.charAt(result.length() - 1));
            result = current.toString();
        }

        return result;
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println(countAndSay(n));
    }
}