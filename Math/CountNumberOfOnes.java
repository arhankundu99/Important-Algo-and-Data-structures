// https://www.naukri.com/code360/problems/count-number-of-ones_1461958
public class Solution  {
    public static int countNumberofOnes(int n) {
        // Number of ones in ones place
        // 1 - 10 => 1,
        // 11 - 20 => 1
        // 21 - 30 => 1
        // For every 10 numbers, 1 one is present in ones place


        // Number of ones in tens place
        // 1 - 100 => 10
        // 101 - 200 => 10
        // For every 100 numbers, 10 ones are present in tens place


        // numOnes = (n / (factor * 10)) * factor;
        // additionalOnes = (n % (factor * 10) - factor + 1);

        int count = 0;
        int num = n;
        int factor = 1;

        while (num != 0) {
            count += (n / (factor * 10) * factor);
            int additionalOnes = (n % (factor * 10) - factor + 1);
            additionalOnes = Math.max(additionalOnes, 0);
            additionalOnes = Math.min(additionalOnes, factor);

            count += additionalOnes;
            num /= 10;
            factor *= 10;
        }
        return count;
    }
}