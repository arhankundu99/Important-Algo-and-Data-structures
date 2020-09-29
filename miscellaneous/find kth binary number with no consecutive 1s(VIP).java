// 1, 10, 100, 101, 1000, 1001, 1010.....find kth binary number.

/*package whatever //do not write package name here */




import java.util.*;


// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

class TestClass {
    public static void main(String args[] ) throws Exception {
		long[] fib = new long[50];
		fib[0] = 1;
		fib[1] = 2;

		for(int i = 2; i < 40; i++)fib[i] = fib[i-1] + fib[i-2];

		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();

		while(t-->0){
			int n = scan.nextInt();
			System.out.println(Long.toBinaryString(solve(n, fib)));
		}
    }
	public static long solve(int n, long[] fib){
		long ans = 0;
		int f = 0;

		for(int i = 39; i >= 0; i--){
			if(fib[i] <= n){
				ans += (1L << i);
				n -= fib[i];
			}
		}
		return ans;
	}
}

