// https://leetcode.com/discuss/interview-question/2095524/google-onsite-interview-29th-may
// The game Babylon is a two-player alternating-moves game - like tic-tac-toe, or chess, or go. It's played with twelve tiles: three each of four colors.

// The tiles start out in 12 stacks of height 1.
// A move consists of combining two stacks: putting one whole stack on top of another.
// You are allowed to combine two stacks if either the heights match, or the top tile colors match.
// You win if you are the last player to move. You lose if it's your turn and there are no moves.
// Write a program to answer the question: who wins, with perfect play? (The first or the second player?)
import java.util.*;
class Babylon {
  public boolean isWinner(char[] colors, int[] heights, int currPlayer) {
      // System.out.println(String.valueOf(colors));
      
      for (int i = 0; i < 12; i++) {
          for (int j = 0; j < 12; j++) {
              if (i == j) continue;
              
              if (colors[i] == ' ' || heights[i] == 0 || colors[j] == ' ' || heights[j] == 0) {
                  continue;
              }
              boolean option1 = false, option2 = false, option3 = false;

              // Case 1: Same color: Merge i to j
              if (colors[i] == colors[j]) {
                  int oldHeightI = heights[i];
                  char oldColorI = colors[i];
                  char oldColorJ = colors[j];
                  
                  heights[j] += heights[i];
                  colors[j] = colors[i];
                  
                  heights[i] = 0;
                  colors[i] = ' ';
                  
                  option1 = !isWinner(colors, heights, 1 - currPlayer);
                  
                  heights[i] = oldHeightI;
                  colors[i] = oldColorI;
                  
                  heights[j] -= heights[i];
                  colors[j] = oldColorJ;
              }
              
              // Case 2: Same height: Merge i to j and merge j to i
              if (heights[i] == heights[j]) {
                  char oldColorI = colors[i];
                  char oldColorJ = colors[j];
                  int oldHeightI = heights[i];
                  int oldHeightJ = heights[j];
                  
                  // Merge i to j
                  colors[i] = ' ';
                  heights[i] = 0;
                  
                  colors[j] = oldColorI;
                  heights[j] += heights[i];
                  
                  option2 = !isWinner(colors, heights, 1 - currPlayer);
                  
                  colors[i] = oldColorI;
                  colors[j] = oldColorJ;
                  heights[i] = oldHeightI;
                  heights[j] = oldHeightJ;
                  
                  // Merge j to i
                  colors[j] = ' ';
                  heights[j] = 0;
                  
                  colors[i] = oldColorJ;
                  heights[i] += heights[j];
                  
                  option3 = !isWinner(colors, heights, 1 - currPlayer);
              }
              
              if (option1 || option2 || option3) {
                  return true;
              }
          }
      }
      return false;
  }
}

public class Main {
    public static void main(String[] args) {
        char[] colors = new char[]{'Y', 'Y', 'Y', 'W', 'W', 'W', 'G', 'G', 'G', 'B', 'B', 'B'};
        int[] heights = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        
        boolean isPlayerOneWinner = (new Babylon()).isWinner(colors, heights, 0);
        System.out.println("Is player 1 winner: " + isPlayerOneWinner);
    }
}