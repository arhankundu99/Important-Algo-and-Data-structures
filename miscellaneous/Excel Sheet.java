// https://practice.geeksforgeeks.org/problems/excel-sheet5448/1
class Solution {
    public String excelColumn(int N){
        
        StringBuilder sb = new StringBuilder();
        while(N > 0){
            int col = N % 26;
            
            if(col == 0){
                sb.append('Z');
                N = (N/26) - 1;
            }
            else{
                sb.append((char)('A' + col - 1));
                N = N/26;
            }
        }
        return sb.reverse().toString();
        
    }
}
