// https://www.hackerrank.com/challenges/count-triplets-1/problem?h_l=interview&isFullScreen=false&playlist_slugs%5B%5D=virtusa

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Solution {

    // Complete the countTriplets function below.
    static long countTriplets(List<Long> arr, long r) {
        if(arr.size() <= 2)return 0;
        Map<Long, Integer>leftMap = new HashMap<>();
        Map<Long, Integer>rightMap = new HashMap<>();


        for(long x: arr){
            if(rightMap.containsKey(x))rightMap.put(x, rightMap.get(x)+1);
            else rightMap.put(x, 1);
        }

        leftMap.put(arr.get(0), 1);
        if(rightMap.get(arr.get(0)) == 1)rightMap.remove(arr.get(0));
        else rightMap.put(arr.get(0), rightMap.get(arr.get(0))-1);

        long ans = 0;
        int idx = 0;

        for(long x: arr){
            if(idx < 1){
                idx++;
                continue;
            }
            if(rightMap.get(x) == 1)rightMap.remove(x);
            else rightMap.put(x, rightMap.get(x)-1);

            if(x % r == 0 && leftMap.containsKey(x/r) && rightMap.containsKey(r*x)){
                long count1 = leftMap.get(x/r);
                long count2 = rightMap.get(r*x);
                ans += (count1 * count2);
            }
            
            if(!leftMap.containsKey(x))leftMap.put(x, 1);
            else leftMap.put(x, leftMap.get(x)+1);
        }
        System.out.println(ans);
        return ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nr[0]);

        long r = Long.parseLong(nr[1]);

        List<Long> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Long::parseLong)
            .collect(toList());

        long ans = countTriplets(arr, r);

        bufferedWriter.write(String.valueOf(ans));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
