// https://practice.geeksforgeeks.org/contest-problem/lexicographical-smallest-sub-sequence-of-k-length-in-a-string/1/
Lexicographical smallest sub-sequence of k length in a string                                                                                          class Solution {
    public String lexicoSmallestSubSeq(String s, int k) {
        // letters[] will store indexes for all letters
        // appearing in string
        ArrayList<LinkedList<Integer>> letters =
            new ArrayList<LinkedList<Integer>>();
        for (int i = 0; i < 26; i++) {
            letters.add(new LinkedList<Integer>());
        }
        for (int i = 0; i < s.length(); i++) {
            letters.get(s.charAt(i) - 'a').add(i);
        }
        StringBuilder sb = new StringBuilder();
        int lowerLimit = 0, upperLimit = 0;
        while (k-- > 0) {
            // while deciding uppper limit for any pick, some margin
            // is to be left to make sure that k character can be picked
            // for the sub seq
            upperLimit = s.length() - k - 1;

            // starting pick(next character for sub seq) should as
            // small as possible
            int pick = 0;

            while (true) {
                // removing indexes lower than lower_lim
                while (!letters.get(pick).isEmpty() &&
                       lowerLimit > letters.get(pick).get(0)) {
                    letters.get(pick).remove(0);
                }

                // if an index lower than upper_lim
                // is found, pick is finalized
                if (!letters.get(pick).isEmpty() &&
                    upperLimit >= letters.get(pick).get(0)) {
                    break;
                }
                pick++;
            }
            sb.append((char)(pick + 'a'));
            // next char should have higher index
            // hence changing lower_lim
            lowerLimit = letters.get(pick).get(0) + 1;
        }
        return sb.toString();
    }
}
