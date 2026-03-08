// 796. Rotate String

// Given two strings s and goal, return true if and only if s can become goal after some number of shifts on s.

// A shift on s consists of moving the leftmost character of s to the rightmost position.

// For example, if s = "abcde", then it will be "bcdea" after one shift.

class Solution796 {
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        
        String doubled = s + s;
        return doubled.contains(goal);
    }

    public static void main(String[] args) {
        Solution796 sol = new Solution796();

        String s = "abcde";
        String goal = "cdeab";

        System.out.println(sol.rotateString(s, goal)); // true
    }
}