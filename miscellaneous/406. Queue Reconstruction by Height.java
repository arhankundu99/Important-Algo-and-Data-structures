// https://leetcode.com/problems/queue-reconstruction-by-height/description/
// Explanation: https://leetcode.com/problems/queue-reconstruction-by-height/solutions/2211641/visual-explanation-java-greedy/
class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            public int compare(int[] person1, int[] person2) {
                if (person1[0] == person2[0]) {
                    return person1[1] - person2[1];
                }
                return person2[0] - person1[0];
            }
        });

        List<int[]> orderedList = new ArrayList<>();
        for(int[] person: people) {
            orderedList.add(person[1], person);
        }

        return orderedList.toArray(new int[people.length][2]);
    }
}