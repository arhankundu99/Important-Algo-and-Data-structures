// https://leetcode.com/discuss/interview-question/5962545/google-screening-round-l4-game-theory-oct-2024/2696451
import java.util.*;

/*
candiesInBasket < candiesLimit => L
candiesInBasket = candiesLimit => W
candiesInBasket = candiesLimit + 1 => L (Always)

[3, 3] => W
[4, 3] => [3, 3] => L
[5, 3] => [4, 3] => W
[6, 3] => [5, 3], [4, 3] => W
[7, 3] => [6, 3], [5, 3] => L
[8, 3] => [7, 3], [6, 3] => W
[9, 3] => [8, 3], [7, 3], [6, 3] => W
[10, 3] => [9, 3], [8, 3], [7, 3] => W
[11, 3] => L

(currentPosition * candiesLimit) / (candiesLimit - 1) + 1 = 11
*/

class Solution {
    String getWinner(int[][] candies) {
        int winsCount = 0;
        for (int i = 0; i < candies.length; i++) {
            
            boolean isWinningState = false;
            if (candies[i][1] > 1) {
                isWinningState = getStateOptimised(candies[i][0], candies[i][1]);
            } else {
                isWinningState = true;
            }
            if (isWinningState) {
                System.out.println(i + " index is a winning state.");
                winsCount++;
            }
        }
        System.out.println("Wins count: " + winsCount);
        if (winsCount % 2 != 0) {
            return "Alice";
        }
        return "Bob";
    }
    
    boolean getStateOptimised(int candiesInBasket, int candiesLimit) {
        if (candiesInBasket < candiesLimit) {
            return false;
        }
        
        if (candiesInBasket == candiesLimit) {
            return true;
        }
        int currentLosingPosition = candiesLimit + 1;
        while (currentLosingPosition < candiesInBasket) {
            currentLosingPosition = ((currentLosingPosition * candiesLimit) / (candiesLimit - 1)) + 1;
        }
        return currentLosingPosition == candiesInBasket? false: true;
    }
    
    boolean getState(int candiesInBasket, int candiesLimit) {
        for (int i = 1; i <= candiesInBasket / candiesLimit; i++) {
            if (!getState(candiesInBasket - i, candiesLimit)) {
                return true;
            }
        }
        return false;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        int[][] candies = new int[][]{{5, 1}};
        System.out.println("\nTest case 1");
        String winner = solution.getWinner(candies);
        System.out.println(winner);
        
        System.out.println("\nTest case 2");
        candies = new int[][]{{10, 4}, {7, 2}, {9, 3}, {2, 1}};
        System.out.println(solution.getWinner(candies));
        
        System.out.println("\nTest case 3");
        candies = new int[][]{{20, 5}, {3, 7}, {17, 2}, {3, 4}};
        System.out.println(solution.getWinner(candies));
        
        for (int i = 3; i <= 11; i++) {
            System.out.println(solution.getState(i, 3) + " " + solution.getStateOptimised(i, 3));
        }
    }
}