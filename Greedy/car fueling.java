import java.util.*;
// You are going to travel to another city that is located 𝑑 miles away from your home city. Your car can travel
// at most 𝑚 miles on a full tank and you start with a full tank. Along your way, there are gas stations at
// distances stop1 ,stop2, . . . ,stop𝑛 from your home city. What is the minimum number of refills needed?

import java.io.*;

public class CarFueling {
    static int computeMinRefills(int dist, int tank, int[] stops) {
	  int count = 0, fuel = tank - stops[0];
	  if(fuel < 0)return -1;
    for(int i = 0; i < stops.length; i++){
		     int next_stop = i + 1 == stops.length?dist: stops[i+1];
		     int curr_stop = stops[i];
                
         if(fuel >= next_stop - curr_stop){
			      fuel -= next_stop - curr_stop;
			      continue;
		      }
		      fuel = tank;
		      count++;
		      if(next_stop - curr_stop > fuel)return -1;
		      fuel -= next_stop - curr_stop; 
    }
    return count;
}

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dist = scanner.nextInt();
        int tank = scanner.nextInt();
        int n = scanner.nextInt();
        int stops[] = new int[n];
        for (int i = 0; i < n; i++) {
            stops[i] = scanner.nextInt();
        }

        System.out.println(computeMinRefills(dist, tank, stops));
    }
}
