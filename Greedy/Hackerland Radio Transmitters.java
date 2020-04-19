//Hackerland is a one-dimensional city with houses aligned at integral locations along a road. 
//The Mayor wants to install radio transmitters on the roofs of the city's houses. 
//Each transmitter has a fixed range meaning it can transmit a signal to all houses within that number of units distance away.
//Given a map of Hackerland and the transmission range, determine the minimum number of transmitters so that every house is within range of at least one transmitter. 
//Each transmitter must be installed on top of an existing house.

//hackerlandRadioTransmitters has the following parameter(s):
//x: integer array that denotes the locations of houses
//k: an integer that denotes the effective range of a transmitter


import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the hackerlandRadioTransmitters function below.
    static int hackerlandRadioTransmitters(int[] x, int k) {
        Arrays.sort(x);
        int ret = 0;
        int i=0;
        while(i<x.length)
        {
            int loc = x[i]+k;
            while(i<x.length && x[i]<=loc)i++;

            i--;   // This is where we place the transmitter
            ret++;
            
            loc = x[i]+k;
            while(i<x.length && x[i]<=loc)i++;
        }
        return ret;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] x = new int[n];

        String[] xItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int xItem = Integer.parseInt(xItems[i]);
            x[i] = xItem;
        }

        int result = hackerlandRadioTransmitters(x, k);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
