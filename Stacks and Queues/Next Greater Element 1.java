//Leetcode problem no 496

//You are given two arrays (without duplicates) nums1 and nums2 where nums1’s elements are subset of nums2. 
//Find all the next greater numbers for nums1's elements in the corresponding places of nums2.
//The Next Greater Number of a number x in nums1 is the first greater number to its right in nums2. 
//If it does not exist, output -1 for this number.

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer>stack = new Stack<>();
        Map<Integer,Integer>map = new HashMap<>();
        for(int i=0;i<nums2.length;i++)
        {
            while(!stack.isEmpty() && stack.peek()<nums2[i])
                map.put(stack.pop(), nums2[i]);
            stack.push(nums2[i]);
        }
        int[]ret = new int[nums1.length];
        for(int i=0;i<nums1.length;i++)
        {
            if(map.containsKey(nums1[i]))ret[i]=map.get(nums1[i]);
            else ret[i] = -1;
        }
        return ret;
    }
}

//Idea : Keep decreasing sequence in stack and if we encounter an element x which is greater than stack.peek(),
//then pop until stack.peek() is less than x

//Implementing the above solution using decreasing monoqueue
// monoqueue is a queue where the elements are either strictly increasing or decreasing
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Deque<Integer>deque = new LinkedList<>();
        Map<Integer,Integer>map = new HashMap<>();
        for(int i=0;i<nums2.length;i++)
        {
            while(!deque.isEmpty() && deque.peekLast() < nums2[i])
                map.put(deque.pollLast(), nums2[i]);
            deque.addLast(nums2[i]);
        }
        int[] ret = new int[nums1.length];
        for(int i=0;i<nums1.length;i++)
        {
            if(!map.containsKey(nums1[i]))ret[i]=-1;
            else ret[i] = map.get(nums1[i]);
        }
        return ret;
    }
}
