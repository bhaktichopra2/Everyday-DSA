// 383. Ransom Note
// Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.

// Each letter in magazine can only be used once in ransomNote.
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] freq = new int[26]; // counts for 'a' to 'z'

        // Count letters in magazine
        for (int i = 0; i < magazine.length(); i++) {
            char ch = magazine.charAt(i);
            freq[ch - 'a']++;
        }

        // Use letters for ransomNote
        for (int i = 0; i < ransomNote.length(); i++) {
            char ch = ransomNote.charAt(i);
            int idx = ch - 'a';
            freq[idx]--;
            if (freq[idx] < 0) {
                return false; // not enough of this char in magazine
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.canConstruct("aa", "ab"));   // false
        System.out.println(sol.canConstruct("aa", "aab"));  // true
    }
}
