// 168. Excel Sheet Column Title

// Given an integer columnNumber, return its corresponding column title as it appears in an Excel sheet.

public class Solution168 {

    public static String convertToTitle(int columnNumber) {
        StringBuilder result = new StringBuilder();

        while (columnNumber > 0) {
            columnNumber--; // adjust for 1-based indexing
            char ch = (char) ('A' + (columnNumber % 26));
            result.append(ch);
            columnNumber /= 26;
        }

        return result.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(convertToTitle(1));    // A
        System.out.println(convertToTitle(28));   // AB
        System.out.println(convertToTitle(701));  // ZY
    }
}