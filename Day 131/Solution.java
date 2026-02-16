// Nth Root of a Number using Binary Search

// Problem Statement: Given two numbers N and M, find the Nth root of M. The nth root of a number M is defined as a number X when raised to the power N equals M. If the 'nth root is not an integer, return -1.
//

//BINARY SEACRH APPROACH
class Solution {
    // Function to find N-th root of M using binary search
    public int nthRoot(int n, int m) {
        int l=0,  h =m;
        while(l<=h){
            int mid = (l+h)/2;
            int ans = 1;
            for(int i=0; i<n; i++){
                ans *= mid;
                if(ans > m) break;
            }
            if(ans == m) return mid;
            if(ans < m) l=mid+1;
            else h = mid - 1;
        }
        return -1;

    }
    public static void main(String[] args) {
        Solution obj = new Solution();
        int result = obj.nthRoot(3, 27);
        System.out.println(result);
    }
}

