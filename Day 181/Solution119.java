// 119. Pascal's Triangle II

// Given an integer rowIndex, return the rowIndexth (0-indexed) row of the Pascal's triangle.

// In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:

import java.util.*;
import java.util.List;

public class Solution119 {

    public static List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        row.add(1);

        for (int i = 1; i <= rowIndex; i++) {
            int nextElement = row.get(i - 1) * (rowIndex - i + 1) / i;
            row.add(nextElement);
        }

        return row;
    }

    public static void main(String[] args) {
        int rowIndex = 4;
        System.out.println(getRow(rowIndex));
    }
}