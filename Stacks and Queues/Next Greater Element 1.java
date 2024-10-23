//Leetcode problem no 496

//You are given two arrays (without duplicates) nums1 and nums2 where nums1’s elements are subset of nums2. 
//Find all the next greater numbers for nums1's elements in the corresponding places of nums2.
//The Next Greater Number of a number x in nums1 is the first greater number to its right in nums2. 
//If it does not exist, output -1 for this number.

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // Stack and map
        // For each element in nums2, pop out stack elements whose value < element amd map[value] = element, and then add the element

        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums2.length; i++) {
            if (stack.size() == 0) {
                stack.push(nums2[i]);
            } else {
                while (stack.size() != 0 && stack.peek() < nums2[i]) {
                    map.put(stack.pop(), nums2[i]);
                }
                stack.push(nums2[i]);
            }
        }

        int[] result = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {
            result[i] = map.containsKey(nums1[i])? map.get(nums1[i]): -1;
        }
        return result;
    }
}