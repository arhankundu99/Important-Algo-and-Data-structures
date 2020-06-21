	public static void initPrime(boolean[] isPrime)
	{
	    isPrime[0] = false;
	    isPrime[1] = false;
	    for(int i = 2; i*i < isPrime.length; i++)
	        for(int j = i*i; j < isPrime.length; j += i)
	        isPrime[j] = false;
	}
