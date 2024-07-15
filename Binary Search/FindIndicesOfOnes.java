// https://leetcode.com/discuss/interview-question/4834179/Google-L4-or-Onsite

// Given a sparse bit array A of size M stored in a database. The database provides an API query(L,R) which returns 1 if there is at least one bit equal to one in A[L..R] and 0 otherwise.

// You want to find all the 1 bits in a reasonable number of queries. E.g. for array 01100000001, positions of 1 bits are {1, 2, 10}.

// Return the array of all the positions of 1's.

// T.C -> It should not be linear.
// S.C -> It should be constant.

// You should not use recursion or extra function. (this part was the followup to the recursive and queue approach).

class Solution {
    int query(int[] A, int left, int right) {
        int count = 0;
        for (int i = left; i <= right; i++) {
            if (A[i] == 1) {
                count++;
            }
        }
        return count == 0? 0: 1;
    }
    int[] getPositionsOfOne(int[] A) {
        int M = A.length;

        int currIdx = 0;
        int[] positions = new int[M];

        while (currIdx <= M - 1 && query(A, currIdx, M - 1) != 0) {
            int left = currIdx, right = M - 1;
            int idx = -1;
            
            while (left <= right) {
                int mid = left + (right - left) / 2;

                if (query(A, currIdx, mid) == 1) {
                    idx = mid;
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            // System.out.println(currIdx + " " + M + " " + idx);
            positions[idx] = 1;
            currIdx = idx + 1;
        }
        return positions;
    }
}

public class FindIndicesOfOnes {
    public static void main(String[] args) {
        int[] A = new int[]{0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1};
        int[] positions = (new Solution()).getPositionsOfOne(A);
        for (int position: positions) {
            System.out.println(position);
        }
    }
}