https://practice.geeksforgeeks.org/problems/the-celebrity-problem/1
class Celebrity
{
    // The task is to complete this function
    int getId(int M[][], int n)
    {
        int a = 0;
        int b = n-1;
        
        //if a knows b, then a cannot be celebrity. therefore a++;
        //If a does not know b, then b cannot be celebrity, therefore b--;
        
        while(a < b){
            if(M[a][b] == 1){
                a++;
            }
            else b--;
        }
        for(int i = 0; i < n; i++){
            if(i == a)continue;
            if(M[a][i] == 1 || M[i][a] == 0)return -1;
        }
        return a;
    }
}
