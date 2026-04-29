// 171. Excel Sheet Column Number


// Given a string columnTitle that represents the column title as appears in an Excel sheet, return its corresponding column number.

public class Solution171 {

    public static int titleToNumber(String columnTitle) {
        int result = 0;

        for (char ch : columnTitle.toCharArray()) {
            result = result * 26 + (ch - 'A' + 1);
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(titleToNumber("A"));   // 1
        System.out.println(titleToNumber("AB"));  // 28
        System.out.println(titleToNumber("ZY"));  // 701
    }
}