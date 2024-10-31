// https://leetcode.com/discuss/interview-question/4009445/Help-needed-or-Interview-Question-or-Google-or-Longest-Increasing-Subsequence-Variation
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    int getLengthOfLIS(int[] nums) {
        // Create an array A[nums.length][2] where the other value is index
        // Sort A based on value
        // Now for i = 0...nums.length - 1
        //         for j = i + 1...nums.length - 1
        //               max = Math.max(max, 1 + getLengthOfLIS(A, i, j))
        
        
        // getLengthOfLIS(A, prevIdx, currIdx) 
        //      choice1: Do not choose currIdx and move to nextIdx
        //      int length = getLengthOfLIS(A, prevIdx, currIdx + 1)
        
        //      choice2: Choose currIdx
        //      if A[currIdx][1] > A[prevIdx][1]:
        //             int diff = A[currIdx][0] - A[prevIdx][0]
        //             int nextIdx = findIdx(A[currIdx][0] + diff + 1)
        //             if nextIdx != -1
        //                  length = Math.max(length, 1 + getLengthOfLIS(A, currIdx, nextIdx))
        //      return length
        
        
        int[][] A = new int[nums.length][2];
        for (int i = 0; i < A.length; i++) {
            A[i] = new int[]{nums[i], i};
        }
        
        Arrays.sort(A, new Comparator<int[]>() {
            public int compare(int[] a1, int[] a2) {
                return a1[0] - a2[0];
            }
        });
        
        int maxLISLength = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                maxLISLength = Math.max(maxLISLength, 1 + getLengthOfLIS(A, i, j));
            }
        }
        return maxLISLength;
    }
    
    private int getLengthOfLIS(int[][] A, int prevIdx, int currIdx) {
        if (currIdx >= A.length || currIdx < 0) {
            return 0;
        }
        
        // Do not choose current idx
        int maxLength = getLengthOfLIS(A, prevIdx, currIdx + 1);
        
        // Choose current idx
        if (A[currIdx][1] > A[prevIdx][1]) {
            int diff = A[currIdx][0] - A[prevIdx][0];
            int nextIdx = find(A, A[currIdx][0] + diff + 1);
            
            maxLength = Math.max(maxLength, 1 + getLengthOfLIS(A, currIdx, nextIdx));
        }
        return maxLength;
    }
    
    private int find(int[][] A, int target) {
        int left = 0, right = A.length - 1;
        int index = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (A[mid][0] >= target) {
                index = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return index;
    }
}
public class Main {
   public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{1, 2, 3, 4, 5, 6};
       System.out.println(solution.getLengthOfLIS(nums));
   }
}
