// https://leetcode.com/problems/reorganize-string/
// https://leetcode.com/discuss/interview-question/1673300/google-phone-coloring
class Solution {
    public String reorganizeString(String s) {
        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 97]++;
        }

        PriorityQueue<Character> queue = new PriorityQueue<>(new Comparator<Character>() {
            public int compare(Character a, Character b) {
                return freq[b - 97] - freq[a - 97];
            }
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (freq[i] != 0) {
                queue.add((char)('a' + i));
            }
        }
        //System.out.println(queue);

        while (queue.size() > 1) {
            System.out.println(queue + " " + freq[0] + " " + freq[1]);
            char char1 = queue.poll();
            char char2 = queue.poll();

            sb.append(char1);
            sb.append(char2);


            freq[char1 - 97]--;
            freq[char2 - 97]--;

            if (freq[char1 - 97] > 0) {
                queue.add(char1);
            }

            if (freq[char2 - 97] > 0) {
                queue.add(char2);
            }
        }

        if (queue.size() != 0) {
            char ch = queue.poll();
            if (freq[ch - 97] > 1) {
                return "";
            }
            sb.append(ch);
        }
        return sb.toString();
    }
}