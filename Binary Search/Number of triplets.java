// 3 arrays each of size n and an integer D

// You have to find (i,j,k) such that:
// |A[i] - B[j]| <= D
// |B[j] - C[k]| <= D
// |A[i] - C[k]| <= D

// Return count of such tuples

class Solution {
    int getCountOfTuples(int[] A, int[] B, int[] C, int D) {
        // Case 1, a < b && a < c (b = c case would be covered here)
        // b - a <= D => b lies between [a + 1, a + D]
        // c - b <= D => c lies between [b + 1, b + D] = [a + 1, a + D]
        // c - a <= D => c lies between [a + 1, a + D]

        // Case 2, b < a && b < c (a = c case would be covered here)
        // Case 3, c < a && c < b (b = a case would be covered here)


        int count = 0;

        count += getCount(A, B, C, D, 1);
        count += getCount(B, A, C, D, 1);
        count += getCount(B, C, A, D, 1);


        // Now the case where a = b = c
        count += getCount(A, B, C, 0, 0);

        return count;
    }

    int getCount(int[] A, int[] B, int C, int D, int offset) {
        int count = 0;
        for (int a: A) {
            int bLeft = getIdx(B, a + offset, false);
            int bRight = getIdx(B, a + D, true);


            int cLeft = getIdx(C, a + offset, false);
            int cRight = getIdx(c, a + D, true);

            if (bLeft != -1 && cLeft != -1 && bRight != -1 && cRight != -1) {
                count += (bRight - bLeft + 1) * (cRight - cLeft + 1);
            }
        }
        return count;
    }

    int getIdx(int[] arr, int val, boolean flag) {
        int low = 0, high = arr.length - 1;
        int idx = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (flag) {
                if (arr[mid] <= val) {
                    idx = mid;
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            } else {
                if (arr[mid] >= val) {
                    idx = mid;
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        return idx;
    }
}