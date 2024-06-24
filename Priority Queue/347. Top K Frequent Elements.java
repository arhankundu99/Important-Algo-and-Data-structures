// https://leetcode.com/problems/top-k-frequent-elements/description/
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();

        for (int num: nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return freqMap.get(a) - freqMap.get(b);
            }
        });

        for (int key: freqMap.keySet()) {
            queue.add(key);
            if (queue.size() == k + 1) {
                queue.poll();
            }
        }

        int[] topK = new int[k];
        for (int i = 0; i < k; i++) {
            topK[i] = queue.poll();
        }
        return topK;
    }
}