    // https://leetcode.com/discuss/interview-question/719623/interview-question-min-the-max-diff
    public static int binaryMinMax(int[] arr, int k){
        int left = 0;
        int right = arr[arr.length-1]-arr[0];
        int[] diff = new int[arr.length-1];
        for(int i=1; i<arr.length; i++){
            diff[i-1] = arr[i]-arr[i-1];
        }
        while(left<right){
            int mid = left+(right-left)/2;
            if(canDivide(diff, k, mid))
                right = mid;
            else
                left = mid+1;
        }
        return left;
    }
    public static boolean canDivide(int[] arr, int k, int max){
        int i =0;
        k++;
        while(k>0 && i<arr.length ){
            int sum = 0;
            while(i<arr.length && sum+arr[i]<max){
                sum+=arr[i++];
            }
            k--;
        }
        return i==arr.length;
    }
