// https://leetcode.com/problems/russian-doll-envelopes/
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, new Comparator<int[]>(){
            public int compare(int[] envelope1, int[] envelope2) {
                if (envelope1[0] - envelope2[0] == 0) {
                    return envelope2[1] - envelope1[1];
                }
                return envelope1[0] - envelope2[0];
            }
        });

        List<Integer> heightSequence = new ArrayList<>();
        heightSequence.add(envelopes[0][1]);

        for (int i = 1; i < envelopes.length; i++) {
            if (envelopes[i][1] > heightSequence.get(heightSequence.size() - 1)) {
                heightSequence.add(envelopes[i][1]);
            } else {
                int left = 0, right = heightSequence.size() - 1;

                int idx = -1;
                while (left <= right) {
                    int mid = left + (right - left) / 2;

                    if (heightSequence.get(mid) >= envelopes[i][1]) {
                        idx = mid;
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                } 

                if (idx == -1) {
                    idx = 0;
                }

                heightSequence.set(idx, envelopes[i][1]);
            }
        }
        return heightSequence.size();
    }
}