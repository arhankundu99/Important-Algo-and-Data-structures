// https://www.interviewbit.com/problems/equal/
// O(N^3) solution
public class Solution {
    public int[] equal(int[] A) {
        int[]ans = new int[4];
        Arrays.fill(ans, Integer.MAX_VALUE);
        for(int i = 0; i < A.length; i++){
            for(int j = i+1; j < A.length; j++){ //A1 < B1
                int sum = A[i] + A[j];
                Map<Integer, Integer>map = new HashMap<>();
                for(int k = i+1; k < A.length; k++){ //A1 < C1
                    if(k == j)continue; //B1 != C1
                    if(map.containsKey(sum-A[k])){
                        int[] temp = new int[4];
                        temp[0] = i;
                        temp[1] = j;
                        temp[2] = map.get(sum-A[k]);
                        temp[3] = k;
                        
                        for(int p = 0; p < 4; p++){
                            if(ans[p] < temp[p])break;
                            if(ans[p] > temp[p]){
                                ans = temp;
                                break;
                            }
                        }
                    }
                    else if(!map.containsKey(A[k]))map.put(A[k], k);
                }
            }
        }
        if(ans[0] != Integer.MAX_VALUE)return ans;
        int[] temp = new int[0];
        return temp;
    }
}
// O(N^2) solution
public class Solution {
    public int[] equal(int[] A) {
        int[] ans = new int[4];
        Arrays.fill(ans, Integer.MAX_VALUE);
        Map<Integer, List<Integer>>map = new HashMap<>();
        for(int i = 0; i < A.length; i++){
            for(int j = i+1; j < A.length; j++){
                int sum = A[i] + A[j];
                if(!map.containsKey(sum)){
                    List<Integer>list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    map.put(sum, list);
                }
                else{
                    List<Integer>list = map.get(sum);
                    int[] temp = new int[4];
                    temp[0] = list.get(0);
                    temp[1] = list.get(1);
                    temp[2] = i;
                    temp[3] = j;
                    
                    if(temp[0] < temp[2] && temp[1] != temp[2] && temp[1] != temp[3]){
                        for(int p = 0; p < 4; p++){
                            if(ans[p] < temp[p])break;
                            else if(ans[p] > temp[p]){
                                ans = temp;
                                break;
                            }
                        }
                    }
                }
            }
        }
        if(ans[0] != Integer.MAX_VALUE)return ans;
        int[] temp = {};
        return temp;
    }
}
