// https://leetcode.com/discuss/interview-question/2328651/Google-Phone-Interview-Question
// Suppose we are creating a string replacement library. Given a map of string replacements, replace the value in the input string

// Given map {X=>123, Y=456}
// Input: %X%_%Y%
// Output: 123_456

// Given map {USER=>admin, HOME=>/%USER%/home}
// Input: I am %USER% My home is %HOME%
// Output: I am admin My home is /admin/home
import java.util.*;

class Solution {
    String replace(Map<String, String> replacementMap, String input) {
        Map<String, Set<String>> adjMap = new HashMap<>();

        // Build the map for topological sorting
        for (String key: replacementMap.keySet()) {
            String value = replacementMap.get(key);

            int left = 0, right = 0;

            while (left < value.length() && right < value.length()) {
                while (left < value.length() && value.charAt(left) != '%') {
                    left++;
                } 

                right = left + 1;
                while (right < value.length() && value.charAt(right) != '%') {
                    System.out.println(value.charAt(right));
                    right++;
                }

                if (left < value.length() && right < value.length()) {
                    String dependant = value.substring(left + 1, right);

                    if (!adjMap.containsKey(dependant)) {
                        adjMap.put(dependant, new HashSet<>());
                    }

                    adjMap.get(dependant).add(key);
                    right = right + 1;
                    left = right;
                }
            }
        }

        Map<String, String> finalReplacements = new HashMap<>();
        for (String key: adjMap.keySet()) {
            dfs(adjMap, key, replacementMap, finalReplacements);
        }

        StringBuilder output = new StringBuilder();
        int left = 0, right = 0;

        while (left < input.length() && right < input.length()) {
            while (left < input.length() && input.charAt(left) != '%') {
                output.append(input.charAt(left));
                left++;
            } 

            right = left + 1;
            while (right < input.length() && input.charAt(right) != '%') {
                right++;
            }

            if (left < input.length() && right < input.length()) {
                String value = input.substring(left + 1, right);
                output.append(finalReplacements.get(value));
                right = right + 1;
                left = right;
            }
        }
        return output.toString();
    }

    private void dfs(Map<String, Set<String>> adjMap, String key, Map<String, String> replacements, Map<String, String> finalReplacements) {
        if (finalReplacements.containsKey(key)) {
            return;
        }
        String value = replacements.get(key);

        StringBuilder valueToBeReplaced = new StringBuilder();

        int left = 0, right = 0;

        while (left < value.length() && right < value.length()) {
            while (left < value.length() && value.charAt(left) != '%') {
                valueToBeReplaced.append(value.charAt(left));
                left++;
            } 

            right = left + 1;
            while (right < value.length() && value.charAt(right) != '%') {
                right++;
            }

            if (left < value.length() && right < value.length()) {
                String dependant = value.substring(left + 1, right);
                valueToBeReplaced.append(finalReplacements.get(dependant));
                right = right + 1;
                left = right;
            }
        }

        finalReplacements.put(key, valueToBeReplaced.toString());

        if (adjMap.containsKey(key)) {
            for (String nextKey: adjMap.get(key)) {
                dfs(adjMap, nextKey, replacements, finalReplacements);
            }
        }

    }
}

public class StringReplacementLibrary {
    public static void main(String[] args) {
        Map<String, String> replacementMap = new HashMap<>();
        replacementMap.put("USER", "admin");
        replacementMap.put("HOME", "/%USER%/home");

        String input = "I am %USER% My home is %HOME%";
        System.out.println((new Solution()).replace(replacementMap, input));
    }
}