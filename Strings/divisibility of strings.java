// Given 2 strings s and t, if s can written as tttt(n times), return smallest string length whose concatenations would give t
// solution 1
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        String s = scan.next();
        String t = scan.next();
        
         
        System.out.println(findSmallestDivisor(s, t));
    }
    public static int findRepeat(String t){
        int len =0;
        int strLen = t.length();
        int lps[] = new int[strLen];

        lps[0]=0;

        int i=1;

        while(i<strLen){
            if(t.charAt(i)== t.charAt(len)){
                len++;
                lps[i]=len;
                i++;
            }
            else{
                if(len!=0){
                    len = lps[len-1];
                }   
                else{
                    lps[i]=0;
                    i++;
                }
            }
        }

        int res = lps[strLen-1];  // longest lps length
        if(res > 0 && (strLen % (strLen-res)==0)){
            return strLen-res;
        }
        else{
            return strLen;
        }
    }
    public static int findSmallestDivisor(String s, String t) {
        if(s==null || t==null || s.isEmpty() || t.isEmpty()){
        return -1;
        }

        if(s.length() % t.length() != 0){
            return -1;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(t);

        while(sb.length()<s.length()){
            sb.append(t);
        }

        if(!sb.toString().equals(s)){
            return -1;
        }

        return findRepeat(t);
    }
}

// solution 2
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        String s = scan.next();
        String t = scan.next();
        
        if(s.length() % t.length() != 0)System.out.println(-1);
        else{
            StringBuilder sb = new StringBuilder();
            
            sb = pow(new StringBuilder(t), s.length()/t.length());
            
            if(!s.equals(sb.toString()))System.out.println(-1);
            else{
                boolean flag = false;
                StringBuilder smallest = new StringBuilder();
                for(int i = 1; i <= t.length(); i++){
                    
                    if(t.length() % i != 0)continue;
                    
                    sb = new StringBuilder();
                    smallest.append(t.charAt(i-1));
                    
                    sb = pow(new StringBuilder(smallest), t.length()/i);
                    
                    if(sb.toString().equals(t)){
                        System.out.println(i);
                        flag = true;
                        break;
                        
                    }
                }
                if(!flag)System.out.println(-1);
            } 
        }
    }
    public static StringBuilder pow(StringBuilder t, int n){
        if(n == 0)return new StringBuilder();
        if(n == 1)return new StringBuilder(t);
        
        StringBuilder half = pow(t, n/2);
        
        half.append(half);
        if(n % 2 != 0){
            half.append(t);
        }
        return half;
    }
