//leetcode 564: Difficulty Hard 
//Given an integer n, find the closest integer (not including itself), which is a palindrome.
//The 'closest' is defined as absolute difference minimized between two integers.

class Solution {
    public String nearestPalindromic(String n) {
        int midIdx = n.length() % 2 != 0? n.length()/2: n.length()/2-1;
        
        long left = Long.parseLong(n.substring(0, midIdx+1));
        
        List<Long>list = new ArrayList<>();
        
        list.add(getPalindrome(left, n.length() % 2 == 0));
        list.add(getPalindrome(left-1, n.length() % 2 == 0));
        list.add(getPalindrome(left+1, n.length() % 2 == 0));
        list.add((long)Math.pow(10, n.length())+1);
        list.add((long)Math.pow(10, n.length()-1)-1);
        
        System.out.println(list);
        Collections.sort(list);
        
        long diff = Long.MAX_VALUE;
        long ans = 0;
        
        for(long num: list){
            if(num == Long.valueOf(n))continue;
            long currDiff = (long)Math.abs(num-Long.valueOf(n));
            if(currDiff < diff){
                ans = num;
                diff = currDiff;
            }
        }
        return String.valueOf(ans);
    }
    public long getPalindrome(long left, boolean even){
        long res = left;
        if(!even)left /= 10;
        while(left != 0){
            res = (res*10) + (left%10);
            left /= 10;
        }
        return res;
    }
}
