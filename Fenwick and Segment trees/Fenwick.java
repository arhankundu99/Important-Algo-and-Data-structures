// an idx in fenwick tree contains sum of indices of range (idx-2^r+1 to idx) where r is the position of rightmost set bit.
//for example in 110 the pos of right most set bit is 1

void update(int idx, int val) 
{  
    idx = idx + 1;  // fenwick tree indices are 1 based
    while (idx <= N){
       BIT[idx] += val;
       idx += idx & (-idx);    // move to the idx whose range contains idx
       // or idx += idx&((~idx)+1);  // ~(idx) flips 1 to 0 and 0 to 1
    } 
}
void build()
{
    for(int i=0; i<N; i++){
        update(i, arr[i]);
    }
}
int sum(int idx)   // this function returns sum from i = 0 to i = idx
{
    int sum = 0;
    idx = idx + 1;  // fenwick tree indices are 1 based
 
    while (idx>0) 
    {
        sum += BIT[idx]; 
        idx -= idx += idx&((~idx)+1);  // move to parent idx
    } 
    return sum;
}



***************************************---------------------******************************************
//for 2d array
void update(int x, int y, int val) 
{  
    for (int i = x+1; i <= N; i += i & (-i))
        for (int j = y+1; j <= M; j+= j & (-j))
            BIT[i][j] += val;
}

int sum(int x, int y) {
    int sum= 0;
    for (int i = x+1; i > 0; i -= i & (-i))
        for (int j = y+1; j > 0; j-= j & (-j))
            sum += BIT[i][j];
    return sum;
}
