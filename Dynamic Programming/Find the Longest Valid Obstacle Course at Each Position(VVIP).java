// https://leetcode.com/problems/find-the-longest-valid-obstacle-course-at-each-position/submissions/946032743/

class Solution {
    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        int n = obstacles.length;
        int[] ans = new int[n];

        List<Integer> subsequence = new ArrayList<>();

        for(int i = 0; i < n; i++){
          int idx = 0;
          if(subsequence.size() == 0 || obstacles[i] >= subsequence.get(subsequence.size() - 1)){
            idx = subsequence.size();
            subsequence.add(obstacles[i]);
          }
          else{
            int low = 0, high = subsequence.size() - 1;

            while(low <= high){
              int mid = (low + high) / 2;
              if(subsequence.get(mid) > obstacles[i]){
                idx = mid;
                high = mid - 1;
              }
              else{
                low = mid + 1;
              }
            }
  
            subsequence.set(idx, obstacles[i]);
          }

          ans[i] = idx + 1;
        }

        return ans;
    }
}
