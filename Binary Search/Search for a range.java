//Interviewbit problem
//Given a sorted array of integers A(0 based index) of size N, 
//find the starting and ending position of a given integar B in array A.

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public ArrayList<Integer> searchRange(final List<Integer> A, int B) {
        int idx1=findOccurence(A,B,false);
        int idx2=findOccurence(A,B,true);
        
        ArrayList<Integer>ret=new ArrayList<>();
        ret.add(idx1);
        ret.add(idx2);
        
        return ret;
    }
    int findOccurence(List<Integer>A, int B, boolean flag)
    {
        int low=0;
        int high=A.size()-1;
        int idx = -1;
        while(low<=high)
        {
            int mid = (low+high)/2;
            if(A.get(mid)==B)
            {
                idx = mid;
                if(flag)low = mid+1;
                else high = mid-1;
            }
            else if(A.get(mid)<B)low=mid+1;
            else high=mid-1;
        }
        return idx;
    }
}
