// https://codingee.com/metro-land-hacker-rank/
int cost(x, y, a, b) {
   return (abs(x-a)+abs(y-b));
}
int greedy(vector<int> numpeople, vector<int> x, vector<int> y){
    vector<int> xx, yy;
    int ans = 0;
    for(int i = 0 ; i < numpeople.size();i++){
        int count = numpeople[i];
        while(count--){
            xx.push_back(x[i]);
            yy.push_back(y[i]);
        }
    }

    sort(xx.begin(), xx.end());
    sort(yy.begin(), yy.end());
    int mx, my;

    mx = xx[xx.size() / 2];
    my = yy[yy.size() / 2];

    for(int i = 0; i < numpeople.size();  i++){
        ans += numpeople[i] * cost(mx, my, x[i], y[i]);
    }
    return ans;
}
