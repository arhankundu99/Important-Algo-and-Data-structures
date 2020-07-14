  // https://www.geeksforgeeks.org/maximum-sum-iarri-among-rotations-given-array/ 
    int max_sum(int A[], int n)
    {
        int sum = 0;
        for(int i = 0; i < A.length; i++)sum += A[i];
        
        int ans = 0;
        for(int i = 0; i < A.length; i++)ans += (i*A[i]);
        
        int max = ans;
        
        for(int i = 0; i < n; i++){
            ans = ans + (A[i] - sum) + (A[i]*(n-1));
            max = Math.max(max, ans);
        }
        return max;
    }
