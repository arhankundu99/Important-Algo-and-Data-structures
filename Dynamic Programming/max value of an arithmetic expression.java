// solution is taken from https://github.com/aditandadit/Algorithmic-Toolbox/blob/master/week6_dynamic_programming2/3_maximum_value_of_an_arithmetic_expression/PlacingParentheses.java
import java.util.*;

public class PlacingParentheses {
    private static long getMaximValue(String exp) {
        List<Integer> nums = new ArrayList<>(exp.length() / 2);
        List<String> ops = new ArrayList<>(exp.length() / 2);

        int i = 0;
        while (i < exp.length()) {
            nums.add(Integer.parseInt("" + exp.charAt(i)));
            if (i < exp.length() - 1) {
                i++;
                ops.add("" + exp.charAt(i));
            }
            i++;
        }

        if (nums.size() == 1) return nums.get(0);

        // For multiply min * min can be greater than max * max => NEED BOTH MAX AND MIN
        int [][] MAX = new int[nums.size()][nums.size()];
        int [][] MIN = new int[nums.size()][nums.size()];

        for (i = 0; i < nums.size(); i++) {
            for (int j = 0; j <nums.size(); j++) {
                MAX[i][j] = Integer.MIN_VALUE;
                MIN[i][j] = Integer.MAX_VALUE;
            }
        }

        // SubProblem is a Subrange or Smaller Length ie ITERATE OVER LENGTH
        for (int l = 1; l <= nums.size(); l++) {

            for (i = 0; i<= nums.size() - l; i++) {

                int j = i + l - 1;
                if (i == j) {
                    // MAX AND MIN ARE SAME if i == j
                    MAX[i][j] = nums.get(i);
                    MIN[i][j] = nums.get(i);
                } else {

                    // Iterate from I to J - 1 to try each possible Cut and chose max && min accordingly
                    int k = i;
                    while (k<j) {


                        int a = eval(MAX[i][k], MAX[k+1][j], ops.get(k).charAt(0));
                        int b = eval(MAX[i][k], )

                        if (ops.get(k).equalsIgnoreCase("+")) {
                            // Addition Max[Full range] = Max [i..k]  + Max [k+1, j]
                            MAX[i][j] = Math.max(MAX[i][j], MAX[i][k] + MAX[k+1][j]);
                            MIN[i][j] = Math.min(MIN[i][j], MIN[i][k] + MIN[k+1][j]);

                        } else if (ops.get(k).equalsIgnoreCase("*")) {

                            int a = MAX[i][k] * MAX[k+1][j];
                            int b = MAX[i][k] * MIN[k+1][j];
                            int c = MIN[i][k] * MAX[k+1][j];
                            int d = MIN[i][k] * MIN[k+1][j]

                            MAX[i][j] = max(MAX[i][j], a,b,c,d);
                            MIN[i][j] = min(MIN[i][j], a,b,c,d);


                            // // MAX -> max of subrange max * max or min * min (in case of negatives)
                            // MAX[i][j] = Math.max(MAX[i][j] , Math.max(MAX[i][k] * MAX[k+1][j], MIN[i][k] * MIN[k+1][j]));

                            // // MIN -> min of subrange min * min or max * min or min * max
                            // MIN[i][j] = min(MIN[i][j] , MIN[i][k] * MIN[k+1][j], MAX[i][k] * MIN[k+1][j], MIN[i][k] * MAX[k+1][j]);

                        } else if (ops.get(k).equalsIgnoreCase("-")) {

                            MAX[i][j] = Math.max(MAX[i][j], MAX[i][k] - MIN[k+1][j]);
                            MIN[i][j] = Math.min(MIN[i][j], MIN[i][k] - MAX[k+1][j]);
                        }

                        k++;
                    }
                }
            }
        }

        return MAX[0][nums.size() - 1];
    }

    public static int min(int ...arr) {
        int result = arr[0];
        for (int i = 1; i< arr.length; i++){
            result = Math.min(result, arr[i]);
        }
        return result;
    }

    public static int max(int ...arr) {
        int result = arr[0];
        for (int i = 1; i< arr.length; i++){
            result = Math.max(result, arr[i]);
        }
        return result;
    }

    private static long eval(long a, long b, char op) {
        if (op == '+') {
            return a + b;
        } else if (op == '-') {
            return a - b;
        } else if (op == '*') {
            return a * b;
        } else {
            assert false;
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String exp = scanner.next();
        System.out.println(getMaximValue(exp));
    }
}
