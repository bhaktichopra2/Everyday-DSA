// 771. Jewels and Stones
// You're given strings jewels representing the types of stones that are jewels, and stones representing the stones you have. Each character in stones is a type of stone you have. You want to know how many of the stones you have are also jewels.

// Letters are case sensitive, so "a" is considered a different type of stone from "A".
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < jewels.length(); i++) {
            set.add(jewels.charAt(i));
        }

        int count = 0;
        for (int i = 0; i < stones.length(); i++) {
            if (set.contains(stones.charAt(i))) {
                count++;
            }
        }
        return count;
    }
     public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.numJewelsInStones("aA", "aAAbbbb")); // 3
        System.out.println(sol.numJewelsInStones("z", "ZZ"));       // 0
    }
}
