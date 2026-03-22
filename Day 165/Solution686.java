// 686. Repeated String Match

// Given two strings a and b, return the minimum number of times you should repeat string a so that string b is a substring of it. If it is impossible for b​​​​​​ to be a substring of a after repeating it, return -1.

// Notice: string "abc" repeated 0 times is "", repeated 1 time is "abc" and repeated 2 times is "abcabc".

class Solution {
    public int repeatedStringMatch(String a, String b) {
        StringBuilder sb = new StringBuilder(a);
        int cnt = 1;

        while(sb.length()<b.length()){
            sb.append(a);
            cnt++;
        }

        if(sb.toString().contains(b)){
            return cnt;
        }

        if(sb.append(a).toString().contains(b)){
            return cnt+1;
        }

        return -1;
    }
}