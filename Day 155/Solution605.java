// 605. Can Place Flowers

// You have a long flowerbed in which some of the plots are planted, and some are not. However, flowers cannot be planted in adjacent plots.

// Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1 means not empty, and an integer n, return true if n new flowers can be planted in the flowerbed without violating the no-adjacent-flowers rule and false otherwise.

public class Solution605 {

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {

        for (int i = 0; i < flowerbed.length; i++) {

            if (flowerbed[i] == 0) {

                boolean leftEmpty = (i == 0) || flowerbed[i - 1] == 0;
                boolean rightEmpty = (i == flowerbed.length - 1) || flowerbed[i + 1] == 0;

                if (leftEmpty && rightEmpty) {
                    flowerbed[i] = 1;
                    n--;
                }

                if (n == 0) {
                    return true;
                }
            }
        }

        return n <= 0;
    }

    public static void main(String[] args) {

        int[] flowerbed = {1,0,0,0,1};
        int n = 1;

        boolean result = canPlaceFlowers(flowerbed, n);

        System.out.println("Can place flowers: " + result);
    }
}